import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
  public static void main(String[] s){
//    define limits for category here
    HashMap<String, Integer> limits = new HashMap<>();
    limits.put("Essential", 5);
    limits.put("Luxury", 3);
    limits.put("Misc", 6);

//    read requests file
    ArrayList<String[]> requests = DataFileReader.read("Input2 - Sheet1.csv");

//    validate requests
    RequestsIterator requestsIterator = new RequestsIterator(requests, new RequestFactory());
    Request r = requestsIterator.next();
    String errors = "";
    while(r!=null){
      ItemsIterator ii = Database.getInstance().getItemsIterator();
      Item item = ii.next();
      while(item!=null){
        if(r.getName().equals(item.getName())){
//          check limits
          limits.put(item.getCategory(), limits.get(item.getCategory()) - r.getQuantity());
          int limit = limits.get(item.getCategory());
//          check quantities
          if(r.getQuantity()>item.getQuantity() || limit < 0){
            errors += r.getName() + " ";
          }
        }
        item = ii.next();
      }
      r = requestsIterator.next();
    }

//    if validation fails, write error to file
    if (!errors.equals("")){
      errors = "Please correct quantities: " + errors;

      try {
        BufferedWriter writer = new BufferedWriter(new FileWriter("output2.txt"));
        writer.write(errors);
        writer.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
      return;
    }

//    if validation is passed, calculate total sum
    Float paid = 0.0f;
    requestsIterator = new RequestsIterator(requests, new RequestFactory());
    r = requestsIterator.next();
    while(r!=null){
//      for each request check if card is in database, if not, add it
      CardsIterator ci = Database.getInstance().getCardsIterator();
      Card c = ci.next();
      boolean cardFound = false;
      while(c!=null){
        if(c.getNumber().equals(r.getCard())){
          cardFound = true;
          break;
        }
        c = ci.next();
      }
      if(!cardFound){
        Database.getInstance().addCard(r.getCard());
      }
      ItemsIterator ii = Database.getInstance().getItemsIterator();
      Item item = ii.next();
      while(item!=null){
        if(r.getName().equals(item.getName())){
          paid += r.getQuantity() * item.getPrice();
        }
        item = ii.next();
      }
      r = requestsIterator.next();
    }

    try {
      BufferedWriter writer = new BufferedWriter(new FileWriter("output.csv"));
      writer.write("Amt Paid\n" + Float.toString(paid));
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return;

  }
}



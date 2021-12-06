import java.util.ArrayList;
// implements SINGLETON pattern, because we only ever need one instance of database and
// NOT to read data files and recreate data each time
public class Database {

  private static Database instance;

  public static Database getInstance() {
    if (instance == null) {
      instance = new Database();
      instance.items = DataFileReader.read("Dataset - Sheet1.csv");
      instance.cards = DataFileReader.read("Cards - Sheet1.csv");
    }
    return instance;
  }

  private ArrayList<String[]> items;

  private ArrayList<String[]> getItems() {
    if(items==null) items = new ArrayList<>();
    return items;
  }

  private void setItems(ArrayList<String[]> items) {
    this.items = items;
  }

  private ArrayList<String[]> getCards() {
    if(cards==null) cards = new ArrayList<>();
    return cards;
  }

  private void setCards(ArrayList<String[]> cards) {
    this.cards = cards;
  }

  private ArrayList<String[]> cards;

  public CardsIterator getCardsIterator(){
    return new CardsIterator(cards, new CardsFactory());
  }

  public ItemsIterator getItemsIterator(){
    return new ItemsIterator(items, new ItemsFactory());
  }

  public void addCard(String card) {
    getCards().add(new String[]{card});
  }
}

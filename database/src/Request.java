public class Request extends AbstractItemAdapter {
  private String[] data;

  public Request(String[] data) {
    this.data = data;
  }

  public String getName(){
    return data[0];
  }

  public Integer getQuantity(){
    return Integer.parseInt(data[1]);
  }

  public String getCard(){
    return data[2];
  }
}

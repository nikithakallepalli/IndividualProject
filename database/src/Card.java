public class Card extends AbstractItemAdapter {
  private String[] data;

  public Card(String[] data) {
    super();
    this.data = data;
  }

  public String getNumber() {
    return data[0];
  }

  public void setNumber(String number) {
    data[0] = number;
  }

}

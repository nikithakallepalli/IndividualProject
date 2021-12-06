public class Item extends AbstractItemAdapter {
  private String[] data;

  public Item(String[] data) {
    this.data = data;
  }

  public String getCategory() {
    return data[0];
  }

  public void setCategory(String category) {
    data[0] = category;
  }

  public String getName() {
    return data[1];
  }

  public void setName(String name) {
    data[1] = name;
  }

  public Integer getQuantity() {
    return Integer.parseInt(data[2]);
  }

  public void setQuantity(Integer quantity) {
    data[2] = Integer.toString(quantity);
  }

  public Float getPrice() {
    return Float.parseFloat(data[3]);
  }

  public void setPrice(Float price) {
    data[3] = Float.toString(price);
  }
}

public class ItemsFactory extends ItemFactory<Item>{
  @Override
  public Item makeItem(String[] data) {
    return new Item(data);
  }
}

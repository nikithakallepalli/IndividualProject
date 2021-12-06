import java.util.ArrayList;

public class ItemsIterator extends Iterator<Item> {
  public ItemsIterator(ArrayList<String[]> items, ItemsFactory itemsFactory) {
    super(items, itemsFactory);
  }
}

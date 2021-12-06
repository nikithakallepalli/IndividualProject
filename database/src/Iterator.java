import java.util.ArrayList;
// implements ITERATOR pattern. provides read access to data arrays using FACTORIES to provide ADAPTER/FLYWEIGHTS
// for underlying data in database
public class Iterator<T extends AbstractItemAdapter>  {
  private int n = 0;
  private ArrayList<String[]> source;
  private ItemFactory<T> factory;

  public Iterator(ArrayList<String[]> source, ItemFactory<T> factory) {
    this.source = source;
    this.factory = factory;
  }

  public T next() {
    try {
      n += 1;
      return factory.makeItem(source.get(n - 1));
    } catch (IndexOutOfBoundsException e) {
      return null;
    }
  }
}

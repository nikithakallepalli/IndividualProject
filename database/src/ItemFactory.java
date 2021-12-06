// implements FACTORY pattern. creates adapters for arrays of data
// see classes CardsFactory, ItemsFactory, RequestsFactory
public abstract class ItemFactory<T extends AbstractItemAdapter> {
  public ItemFactory(){
    super();
  }

  public abstract T makeItem(String[] data);
}

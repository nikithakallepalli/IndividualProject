public class CardsFactory extends ItemFactory<Card>{
  @Override
  public Card makeItem(String[] data) {
    return new Card(data);
  }
}

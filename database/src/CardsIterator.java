import java.util.ArrayList;

public class CardsIterator extends Iterator<Card> {
  public CardsIterator(ArrayList<String[]> source, ItemFactory<Card> factory) {
    super(source, factory);
  }
}

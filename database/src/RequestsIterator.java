import java.util.ArrayList;

public class RequestsIterator extends Iterator<Request>{
  public RequestsIterator(ArrayList<String[]> source, RequestFactory factory) {
    super(source, factory);
  }
}

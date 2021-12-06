public class RequestFactory extends ItemFactory<Request> {
  @Override
  public Request makeItem(String[] data) {
    return new Request(data);
  }
}

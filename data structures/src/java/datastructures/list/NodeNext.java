package java.datastructures.list;

public class NodeNext<T> {
  private T data;
  private NodeNext<T> next;

  public NodeNext(T data, NodeNext<T> next) {
    this.data = data;
    this.next = next;
  }

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public NodeNext<T> getNext() {
    return next;
  }

  public void setNext(NodeNext<T> next) {
    this.next = next;
  }

  @Override
  public String toString() {
    return data.toString();
  }
}


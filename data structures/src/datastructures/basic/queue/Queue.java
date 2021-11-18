package datastructures.basic.queue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<T> implements Iterable<T> {
  private LinkedList<T> list = new LinkedList<>();

  public Queue() {}

  public Queue(T item) {
    offer(item);
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public T peek() {
    if (isEmpty()) {
      throw new RuntimeException("No element");
    }
    return list.peekFirst();
  }

  public T poll() {
    if (isEmpty()) {
      throw new RuntimeException("No element");
    }
    return list.removeFirst();
  }

  public void offer(T item) {
    list.addLast(item);
  }


  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }

}

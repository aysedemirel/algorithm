package java.datastructures.stack;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.LinkedList;

public class Stack<T> implements Iterable<T> {
  private LinkedList<T> list = new LinkedList<>();

  public Stack() {}

  public Stack(T firstItem) {
    push(firstItem);
  }

  public int size() {
    return list.size();
  }

  public boolean isEmpty() {
    return size() == 0;
  }

  public void push(T item) {
    list.add(item);
  }

  public T pop() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return list.removeLast();
  }

  public T peek() {
    if (isEmpty()) {
      throw new EmptyStackException();
    }
    return list.peek();
  }

  @Override
  public Iterator<T> iterator() {
    return list.iterator();
  }


}

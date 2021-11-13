package java.datastructures.list;

import java.util.Iterator;

/**
 * Doubly list performance is better than singly list performance
 */
public class SinglyList<T> implements Iterable<T> {

  private int size = 0;
  private NodeNext<T> head = null;
  private NodeNext<T> tail = null;

  public void clear() {
    NodeNext<T> temp = head;
    while (temp != null) {
      NodeNext<T> next = temp.getNext();
      temp.setNext(null);
      temp = next;
    }
    head = null;
    tail = null;
    temp = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public void add(T obj) {
    addLast(obj);
  }

  public void addFirst(T obj) {
    if (isEmpty()) {
      head = new NodeNext<T>(obj, null);
      tail = new NodeNext<T>(obj, null);
    } else {
      NodeNext<T> node = head;
      head = new NodeNext<T>(obj, node);
    }
    size++;
  }

  public void addLast(T obj) {
    if (isEmpty()) {
      head = new NodeNext<T>(obj, null);
      tail = new NodeNext<T>(obj, null);
    } else {
      NodeNext<T> node = tail;
      tail = new NodeNext<T>(obj, null);
      node.setNext(tail);
    }
    size++;
  }

  public T pickFirst() {
    if (isEmpty()) {
      throw new RuntimeException("No element");
    }
    return head.getData();
  }

  public T pickLast() {
    if (isEmpty()) {
      throw new RuntimeException("No element");
    }
    return tail.getData();
  }

  public T removeFirst() {
    if (isEmpty()) {
      throw new RuntimeException("No element");
    }
    T data = head.getData();
    head = head.getNext();
    size--;
    if (isEmpty()) {
      tail = null;
    }
    return data;
  }

  public T removeLast() {
    if (isEmpty()) {
      throw new RuntimeException("No element");
    }
    T data = tail.getData();
    NodeNext<T> trav = head;
    for (int i = 0; i < size; i++) {
      // before tail
      if (i == size - 2) {
        tail = trav;
      }
      trav = trav.getNext();
    }
    size--;
    if (isEmpty()) {
      head = null;
    }
    return data;
  }

  public T remove(NodeNext<T> node) {
    if (isEmpty()) {
      throw new RuntimeException("No element");
    }
    if (node.equals(head)) {
      return removeFirst();
    } else if (node.equals(tail)) {
      return removeLast();
    }
    NodeNext<T> trav = head;
    for (int i = 0; i < size; i++) {
      if (node.equals(trav.getNext())) {
        trav.setNext(node.getNext());
      }
      trav = trav.getNext();
    }
    T data = node.getData();
    node.setData(null);
    node.setNext(null);
    node = null;
    size--;
    return data;
  }

  public T removeAt(int index) {
    if (isEmpty()) {
      throw new RuntimeException("No element");
    } else if (index < 0 || index >= size) {
      throw new IllegalArgumentException();
    }
    if (index == (size - 1)) {
      return removeLast();
    } else if (index == 0) {
      return removeFirst();
    } else {
      NodeNext<T> trav;
      int i;
      for (i = 0, trav = head; i != index; i++) {
        trav = trav.getNext();
      }
      return remove(trav);
    }
  }

  // remove a particular value in the linked list
  public boolean remove(Object obj) {
    NodeNext<T> trav = head;
    if (obj == null) {
      for (trav = head; trav != null; trav = trav.getNext()) {
        if (trav.getData() == null) {
          remove(trav);
          return true;
        }
      }
    } else {
      for (trav = head; trav != null; trav = trav.getNext()) {
        if (obj.equals(trav.getData())) {
          remove(trav);
          return true;
        }
      }
    }
    return false;
  }

  public int indexOf(Object obj) {
    NodeNext<T> trav = head;
    int index = 0;
    if (obj == null) {
      for (trav = head; trav != null; trav = trav.getNext(), index++) {
        if (trav.getData() == null) {
          return index;
        }
      }
    } else {
      for (trav = head; trav != null; trav = trav.getNext(), index++) {
        if (obj.equals(trav.getData())) {
          return index;
        }
      }
    }
    return -1;
  }

  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private NodeNext<T> trav = head;

      @Override
      public boolean hasNext() {
        return trav != null;
      }

      @Override
      public T next() {
        T data = trav.getData();
        trav = trav.getNext();
        return data;
      }
    };
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder();
    str.append("[ ");
    NodeNext<T> trav1 = head;
    while (trav1 != null) {
      str.append(trav1.getData() + ", ");
      trav1 = trav1.getNext();
    }
    str.append("]");
    return str.toString();
  }
}

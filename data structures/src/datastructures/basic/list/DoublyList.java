package datastructures.basic.list;

import java.util.Iterator;

public class DoublyList<T> implements Iterable<T> {

  private int size = 0;
  private Node<T> head = null;
  private Node<T> tail = null;

  public void clear() {
    Node<T> temp = head;
    while (temp != null) {
      Node<T> next = temp.getNext();
      temp.setPrev(null);
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
      head = new Node<T>(obj, null, null);
      tail = new Node<T>(obj, null, null);
    } else {
      head.setPrev(new Node<T>(obj, null, head));
      head = head.getPrev();
    }
    size++;
  }

  public void addLast(T obj) {
    if (isEmpty()) {
      head = new Node<T>(obj, null, null);
      tail = new Node<T>(obj, null, null);
    } else {
      tail.setNext(new Node<T>(obj, tail, null));
      tail = tail.getNext();
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
    } else {
      head.setPrev(null);
    }
    return data;
  }

  public T removeLast() {
    if (isEmpty()) {
      throw new RuntimeException("No element");
    }
    T data = tail.getData();
    tail = tail.getPrev();
    size--;
    if (isEmpty()) {
      head = null;
    } else {
      tail.setNext(null);
    }
    return data;
  }

  public T remove(Node<T> node) {
    if (isEmpty()) {
      throw new RuntimeException("No element");
    }
    if (node.getNext() == null) {
      return removeLast();
    } else if (node.getPrev() == null) {
      return removeFirst();
    }
    node.getNext().setPrev(node.getPrev());
    node.getPrev().setNext(node.getNext());
    T data = node.getData();
    node.setData(null);
    node.setNext(null);
    node.setPrev(null);
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
    } else if (index < size / 2) {
      Node<T> trav;
      int i;
      for (i = 0, trav = head; i != index; i++) {
        trav = trav.getNext();
      }
      return remove(trav);
    } else {
      Node<T> trav;
      int i;
      for (i = size - 1, trav = tail; i != index; i--) {
        trav = trav.getPrev();
      }
      return remove(trav);
    }
  }

  // remove a particular value in the linked list
  public boolean remove(Object obj) {
    Node<T> trav = head;
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
    Node<T> trav = head;
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
      private Node<T> trav = head;

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
    Node<T> trav1 = head;
    while (trav1 != null) {
      str.append(trav1.getData() + ", ");
      trav1 = trav1.getNext();
    }
    str.append("]");
    return str.toString();
  }
}

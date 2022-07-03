package datastructures.basic.queue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class PQueue<T> implements Comparable<T> {
  private int heapSize = 0;
  private int heapCapacity = 0;
  private List<T> heap = null;
  private Map<T, TreeSet<Integer>> map = new HashMap<>();

  public PQueue() {
    this(1);
  }

  public PQueue(int size) {
    heap = new ArrayList<>(size);
  }

  public PQueue(T[] elems) {
    heapSize = elems.length;
    heapCapacity = elems.length;
    heap = new ArrayList<>(heapCapacity);

    for (int i = 0; i < elems.length; i++) {
      mapAdd(elems[i], i);
      heap.add(elems[i]);
    }

    for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
      sink(i);
    }
  }

  public PQueue(Collection<T> elems) {
    this(elems.size());
    for (T elem : elems) {
      add(elem);
    }
  }

  public boolean isEmpty() {
    return heapSize == 0;
  }

  public void clear() {
    if (isEmpty()) {
      return;
    }
    for (int i = 0; i < heapCapacity; i++) {
      heap.set(i, null);
    }
    map.clear();
    heapSize = 0;
  }

  public int size() {
    return heapSize;
  }

  public T peek() {
    if (isEmpty()) {
      return null;
    }
    return heap.get(0);
  }

  public T poll() {
    return removeAt(0);
  }

  public boolean contains(T elem) {
    if (isEmpty() || elem == null) {
      return false;
    }
    return map.containsKey(elem);
  }

  public void add(T element) {
    if (element == null) {
      throw new IllegalArgumentException();
    }
    if (heapSize < heapCapacity) {
      heap.set(heapSize, element);
    } else {
      heap.add(element);
      heapCapacity++;
    }
    mapAdd(element, heapSize);
    swim(heapSize);
    heapSize++;
  }

  @SuppressWarnings("unchecked")
  public boolean less(int i, int j) {
    T node1 = heap.get(i);
    T node2 = heap.get(j);
    return ((Comparable<T>) node1).compareTo(node2) <= 0;
  }

  // bottom to top
  public void swim(int index) {
    int parent = (index - 1) / 2;

    while (index > 0 && less(index, parent)) {
      swap(parent, index);
      index = parent;
      parent = (index - 1) / 2;
    }
  }

  // Top to bottom
  public void sink(int index) {
    while (true) {
      int left = 2 * index + 1;
      int right = 2 * index + 2;
      int smallest = left;

      if (right < heapSize && less(right, left)) {
        smallest = right;
      }
      if (left >= heapSize || less(index, smallest)) {
        break;
      }

      swap(smallest, index);
      index = smallest;
    }
  }

  public void swap(int i, int j) {
    T iElem = heap.get(i);
    T jElem = heap.get(j);

    heap.set(i, jElem);
    heap.set(j, iElem);

    mapSwap(iElem, jElem, i, j);
  }

  public boolean remove(T element) {
    if (element == null) {
      return false;
    }

    Integer index = mapGet(element);
    if (index != null) {
      removeAt(index);
    }
    return index != null;
  }

  private T removeAt(int i) {
    if (isEmpty())
      return null;

    heapSize--;
    T removedItem = heap.get(i);
    swap(i, heapSize);

    heap.set(heapSize, null);
    mapRemove(removedItem, heapSize);

    if (i == heapSize)
      return removedItem;

    T elem = heap.get(i);
    sink(i);

    if (heap.get(i).equals(elem)) {
      swim(i);
    }
    return removedItem;
  }

  public boolean isMinHeap(int k) {
    if (k >= heapSize)
      return true;
    int left = 2 * k + 1;
    int right = 2 * k + 2;
    return isMinHeap(left) && isMinHeap(right);
  }

  private void mapAdd(T value, int index) {
    TreeSet<Integer> set = map.get(value);

    if (set == null) {
      set = new TreeSet<>();
      set.add(index);
      map.put(value, set);
    } else {
      set.add(index);
    }
  }

  private void mapRemove(T value, int index) {
    TreeSet<Integer> set = map.get(value);
    set.remove(index);
    if (set.size() == 0)
      map.remove(value);
  }

  private Integer mapGet(T value) {
    TreeSet<Integer> set = map.get(value);
    if (set != null)
      return set.last();
    return null;
  }

  private void mapSwap(T vall, T val2, int vallIndex, int val2Index) {
    Set<Integer> set1 = map.get(vall);
    Set<Integer> set2 = map.get(val2);

    set1.remove(vallIndex);
    set2.remove(val2Index);

    set1.add(val2Index);
    set2.add(vallIndex);
  }

  @Override
  public int compareTo(T o) {
    return 0;
  }
}

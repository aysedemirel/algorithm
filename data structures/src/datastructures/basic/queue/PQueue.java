package datastructures.basic.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

  // public PQueue(T[] elems) {
  // heapSize = elems.length;
  // heapCapacity = elems.length;
  // heap = new ArrayList<>(heapCapacity);
  //
  // for (int i = 0; i < elems.length; i++) {
  // mapAdd(elems[i], i);
  // heap.add(elems[i]);
  // }
  //
  // for (int i = Math.max(0, (heapSize / 2) - 1); i >= 0; i--) {
  // sink(i);
  // }
  // }
  //
  // public PQueue(Collection<T> elems) {
  // this(elems.size());
  // for (T elem : elems) {
  // add(elem);
  // }
  // }

  @Override
  public int compareTo(T o) {
    // TODO Auto-generated method stub
    return 0;
  }

}

package basics;

/** @author aysedemirel */
public class QuickUnion {
  private int[] id;

  // o(N)
  public QuickUnion(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  private int root(int i) {
    while (i != id[i]) {
      i = id[i];
    }
    return i;
  }

  // o(N)
  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  // o(N)
  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    id[i] = j;
  }

  public static void main(String[] args) {
    final int sizeOfIdArr = 10;
    QuickUnion quickUnion = new QuickUnion(sizeOfIdArr);
    quickUnion.union(4, 3);
    quickUnion.union(4, 3);
    quickUnion.union(3, 8);
    quickUnion.union(6, 5);
    quickUnion.union(9, 4);
    quickUnion.union(2, 1);
    System.out.println("isConnected 8-9: " + quickUnion.connected(8, 9));
    System.out.println("isConnected 5-0: " + quickUnion.connected(5, 0));
    quickUnion.union(7, 2);
    quickUnion.union(6, 1);
    quickUnion.union(7, 3);
    System.out.println("isConnected 6-8: " + quickUnion.connected(6, 8));
  }
}

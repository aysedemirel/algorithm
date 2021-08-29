package basics;

/** @author aysedemirel */
public class WeightedQuickUnion extends QuickUnion {

  private int[] sizeOfTree;

  public WeightedQuickUnion(int N) {
    super(N);
    sizeOfTree = new int[N];
  }

  // o(lgN)
  @Override
  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    if (i == j)
      return;
    if (sizeOfTree[i] < sizeOfTree[j]) {
      id[i] = j;
      sizeOfTree[j] += sizeOfTree[i];
    } else {
      id[j] = i;
      sizeOfTree[i] += sizeOfTree[j];
    }
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

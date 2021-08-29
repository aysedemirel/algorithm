package basics;

public class WQUPC extends WeightedQuickUnion {

  public WQUPC(int N) {
    super(N);
  }

  @Override
  protected int root(int i) {
    while (i != id[i]) {
      id[i] = id[id[i]];
      i = id[i];
    }
    return i;
  }

  public static void main(String[] args) {
    final int sizeOfIdArr = 10;
    WQUPC wqupc = new WQUPC(sizeOfIdArr);
    wqupc.union(4, 3);
    wqupc.union(4, 3);
    wqupc.union(3, 8);
    wqupc.union(6, 5);
    wqupc.union(9, 4);
    wqupc.union(2, 1);
    System.out.println("isConnected 8-9: " + wqupc.connected(8, 9));
    System.out.println("isConnected 5-0: " + wqupc.connected(5, 0));
    wqupc.union(7, 2);
    wqupc.union(6, 1);
    wqupc.union(7, 3);
    System.out.println("isConnected 6-8: " + wqupc.connected(6, 8));
  }

}

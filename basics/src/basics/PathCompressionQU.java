package basics;

public class PathCompressionQU extends QuickUnion {

  public PathCompressionQU(int N) {
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
    PathCompressionQU pathComp = new PathCompressionQU(sizeOfIdArr);
    pathComp.union(4, 3);
    pathComp.union(4, 3);
    pathComp.union(3, 8);
    pathComp.union(6, 5);
    pathComp.union(9, 4);
    pathComp.union(2, 1);
    System.out.println("isConnected 8-9: " + pathComp.connected(8, 9));
    System.out.println("isConnected 5-0: " + pathComp.connected(5, 0));
    pathComp.union(7, 2);
    pathComp.union(6, 1);
    pathComp.union(7, 3);
    System.out.println("isConnected 6-8: " + pathComp.connected(6, 8));
  }
}

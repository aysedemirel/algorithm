package basics;

import org.junit.jupiter.api.Test;

public class QuickFindTest {

  @Test
  public void weightedQuickUnionTest() {
    final int sizeOfIdArr = 10;
    System.out.println("Weighted Quick Union:");
    WeightedQuickUnion weighted = new WeightedQuickUnion(sizeOfIdArr);
    weighted.union(4, 3);
    weighted.union(3, 8);
    weighted.union(6, 5);
    weighted.union(9, 4);
    weighted.union(2, 1);
    System.out.println("isConnected 8-9: " + weighted.connected(8, 9));
    System.out.println("isConnected 5-0: " + weighted.connected(5, 0));
    weighted.union(7, 2);
    weighted.union(6, 1);
    weighted.union(7, 3);
    System.out.println("isConnected 6-8: " + weighted.connected(6, 8));
  }

  @Test
  public void quickUnionTest() {
    final int sizeOfIdArr = 10;
    System.out.println("Quick Union:");
    QuickUnion quickUnion = new QuickUnion(sizeOfIdArr);
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

  @Test
  public void pathCompressionTest() {
    final int sizeOfIdArr = 10;
    System.out.println("Path compression:");
    PathCompressionQU pathComp = new PathCompressionQU(sizeOfIdArr);
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

  @Test
  public void wqupcTest() {
    final int sizeOfIdArr = 10;
    System.out.println("WQUPC:");
    WQUPC wqupc = new WQUPC(sizeOfIdArr);
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

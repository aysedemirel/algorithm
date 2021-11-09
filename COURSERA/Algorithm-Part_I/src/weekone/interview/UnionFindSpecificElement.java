package weekone.interview;

import weekone.lessonmaterial.WeightedQuickUnionUF;

public class UnionFindSpecificElement {

  private WeightedQuickUnionUF weighted;

  public UnionFindSpecificElement(int N) {
    weighted = new WeightedQuickUnionUF(N);
  }

  public void union(int x, int y) {
    weighted.union(x, y);
  }

  public int findBiggest(int i) {
    int[] idArray = weighted.getIdArray();
    int biggest = i;
    while (i != idArray[i]) {
      i = idArray[i];
      if (biggest < i) {
        biggest = i;
      }
    }
    return biggest;
  }

  public static void main(String[] args) {
    final int sizeOfIdArr = 10;
    UnionFindSpecificElement weighted = new UnionFindSpecificElement(sizeOfIdArr);
    weighted.union(6, 2);
    weighted.union(6, 9);
    weighted.union(2, 1);
    System.out.println("Find biggest in the tree for 3: " + weighted.findBiggest(3));
    System.out.println("Find biggest in the tree for 2: " + weighted.findBiggest(2));
  }
}

package weekone.lessonmaterial;

/**
 * weighted quick union algorithm class (Improvement)
 * 
 */
public class WeightedQuickUnionUF extends QuickUnionUF {

  private int[] sizeOfTree;

  public WeightedQuickUnionUF(int N) {
    super(N);
  }

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
}

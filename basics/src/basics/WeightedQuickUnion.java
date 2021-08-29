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
}

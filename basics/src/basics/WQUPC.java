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
}

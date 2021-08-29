package basics;

/** @author aysedemirel */
public class QuickUnion {
  protected int[] id;

  // o(N)
  public QuickUnion(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  protected int root(int i) {
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
}

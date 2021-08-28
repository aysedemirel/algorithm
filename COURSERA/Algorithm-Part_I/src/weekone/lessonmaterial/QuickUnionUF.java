package weekone.lessonmaterial;

/**
 * quick union algorithm class (Lazy approach)
 * 
 */
public class QuickUnionUF {
  protected int[] id;

  public QuickUnionUF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++)
      id[i] = i;
  }

  protected int root(int i) {
    while (i != id[i])
      i = id[i];
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    id[i] = j;
  }
}

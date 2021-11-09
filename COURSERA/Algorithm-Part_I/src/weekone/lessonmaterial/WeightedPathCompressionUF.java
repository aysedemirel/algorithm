package weekone.lessonmaterial;

public class WeightedPathCompressionUF extends WeightedQuickUnionUF {

  public WeightedPathCompressionUF(int N) {
    super(N);
  }

  @Override
  public int root(int i) {
    while (i != id[i]) {
      id[i] = id[id[i]];
      i = id[i];
    }
    return i;
  }
}

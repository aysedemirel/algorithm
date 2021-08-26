package basics;

/** @author aysedemirel */
public class QuickFind {
  private int[] id;

  // o(N)
  public QuickFind(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  // o(1)
  public boolean connected(int p, int q) {
    return id[p] == id[q];
  }


  /** N Operation: N*N times for union */
  // o(N)
  public void union(int p, int q) {
    int pid = id[p];
    int qid = id[q];
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pid) {
        id[i] = qid;
      }
    }
  }

  public static void main(String[] args) {
    final int sizeOfIdArr = 10;
    QuickFind quickFind = new QuickFind(sizeOfIdArr);
    quickFind.union(4, 3);
    quickFind.union(3, 8);
    quickFind.union(6, 5);
    quickFind.union(9, 4);
    quickFind.union(2, 1);
    System.out.println("isConnected 8-9: " + quickFind.connected(8, 9));
    System.out.println("isConnected 5-0: " + quickFind.connected(5, 0));
    quickFind.union(5, 0);
    quickFind.union(7, 2);
    quickFind.union(6, 1);
  }
}

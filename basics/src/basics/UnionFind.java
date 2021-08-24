package basics;

public class UnionFind {
  private int verticesNo;
  private int edgesNo;
  private Edge[] edge;

  class Edge {
    int source;
    int destination;
  }

  public UnionFind(int verticesNo, int edgesNo) {
    this.verticesNo = verticesNo;
    this.edgesNo = edgesNo;
    createEdge();
  }

  private void createEdge() {
    edge = new Edge[edgesNo];
    for (int i = 0; i < edgesNo; ++i) {
      edge[i] = new Edge();
    }
  }

  // O(v)
  public int find(int[] parent, int i) {
    if (parent[i] == -1) {
      return i;
    }
    return find(parent, parent[i]);
  }

  // O(e)
  public void union(int[] parent, int x, int y) {
    parent[x] = y;
  }

  // O((v+e)*(v))
  public boolean isCycle() {
    boolean isCycle = false;
    int[] parent = initArray();
    for (int i = 0; i < edgesNo; ++i) {
      int x = find(parent, edge[i].source);
      int y = find(parent, edge[i].destination);

      if (x == y) {
        isCycle = true;
      } else {
        union(parent, x, y);
      }
    }
    return isCycle;
  }

  private int[] initArray() {
    int[] array = new int[verticesNo];
    for (int i = 0; i < verticesNo; ++i) {
      array[i] = -1;
    }
    return array;
  }

  public static void main(String[] args) {
    /*
     * Let us create the following graph 2-0-1-3-4 (so there is no cycle)
     */
    int vertices = 5;
    int edges = 4;
    UnionFind graph = new UnionFind(vertices, edges);

    // add edge 0-1
    graph.edge[0].source = 0;
    graph.edge[0].destination = 1;

    // add edge 1-2
    graph.edge[1].source = 1;
    graph.edge[1].destination = 3;

    // add edge 0-2
    graph.edge[2].source = 0;
    graph.edge[2].destination = 2;

    // add edge 3-4
    graph.edge[3].source = 3;
    graph.edge[3].destination = 4;

    if (graph.isCycle()) {
      System.out.println("graph contains cycle");
    } else {
      System.out.println("graph doesn't contain cycle");
    }
  }
}

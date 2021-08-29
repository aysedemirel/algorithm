package weekone.interview;

import weekone.lessonmaterial.WeightedQuickUnionUF;

public class SocialNetworkConnectivity {

  private WeightedQuickUnionUF wqupc;
  private int numOfFriend;

  public SocialNetworkConnectivity(int N) {
    wqupc = new WeightedQuickUnionUF(N);
    numOfFriend = N; // assume that every nodes are connected
  }

  public void addFrienship(int friendA, int friendB) {
    if (!wqupc.connected(friendA, friendB)) {
      numOfFriend--;
    }
    wqupc.union(friendA, friendB);
  }

  public boolean fullyConnected() {
    return numOfFriend == 1;
  }
}

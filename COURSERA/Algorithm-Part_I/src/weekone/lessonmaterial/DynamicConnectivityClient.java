package weekone.lessonmaterial;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.UF;

/**
 * Firstly take input from user to specify interval. Secondly take inputs(pair of numbers) from user
 * to analyze which connected or not
 * 
 * Example input: <br>
 * 10 -> interval<br>
 * 6 5 ->print (not connected)<br>
 * 4 3 ->print (not connected)<br>
 * 3 5 ->print (not connected)<br>
 * 6 3 ->don't print(connected)
 */
public class DynamicConnectivityClient {
  public static void main(String[] args) {
    int numberOfInterval = StdIn.readInt();
    UF uf = new UF(numberOfInterval);
    while (!StdIn.isEmpty()) {
      int firstPair = StdIn.readInt();
      int secondPair = StdIn.readInt();
      boolean isConnected = uf.find(firstPair) == uf.find(secondPair);
      if (!isConnected) {
        uf.union(firstPair, secondPair);
        StdOut.println(firstPair + " " + secondPair);
      }
    }
  }
}

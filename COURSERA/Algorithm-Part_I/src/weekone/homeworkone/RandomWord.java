package weekone.homeworkone;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/** @author aysedemirel */
public class RandomWord {

  public static void main(String[] a) {
    String selectedWord = "";
    int index = 1;
    while (true) {
      String input = StdIn.readString();
      if (StdIn.isEmpty()) {
        break;
      }
      boolean isRandom = StdRandom.bernoulli(1 / (double) index++);
      if (isRandom) {
        selectedWord = input;
      }
    }
    StdOut.println(selectedWord);
  }
}

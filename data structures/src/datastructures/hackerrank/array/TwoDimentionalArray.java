package datastructures.hackerrank.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoDimentionalArray {

  public TwoDimentionalArray() {}

  private int hourglassSum(List<List<Integer>> arr) {
    int max = -63;

    for (int i = 0; i < (arr.size() / 2) + 1; i++) {
      for (int j = 0; j < (arr.get(i).size() / 2 + 1); j++) {
        int sum = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2)
            + arr.get(i + 1).get(j + 1) + arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1)
            + arr.get(i + 2).get(j + 2);
        if (sum > max) {
          max = sum;
          // System.out.println(
          // arr.get(i).get(j) + ", " + arr.get(i).get(j + 1) + ", " + arr.get(i).get(j + 2)
          // + ", \n" + arr.get(i + 1).get(j + 1) + ", \n" + arr.get(i + 2).get(j) + ", "
          // + arr.get(i + 2).get(j + 1) + ", " + arr.get(i + 2).get(j + 2));
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    List<List<Integer>> list = new ArrayList<>();
    List<Integer> firstRow = Arrays.asList(1, 1, 1, 0, 0, 0);
    List<Integer> secondRow = Arrays.asList(0, 1, 0, 0, 0, 0);
    List<Integer> thirdRow = Arrays.asList(1, 1, 1, 0, 0, 0);
    List<Integer> fourthRow = Arrays.asList(0, 0, 2, 4, 4, 0);
    List<Integer> fifthRow = Arrays.asList(0, 0, 0, 2, 0, 0);
    List<Integer> sixthRow = Arrays.asList(0, 0, 1, 2, 4, 0);
    list.add(firstRow);
    list.add(secondRow);
    list.add(thirdRow);
    list.add(fourthRow);
    list.add(fifthRow);
    list.add(sixthRow);
    TwoDimentionalArray twoD = new TwoDimentionalArray();
    int result = twoD.hourglassSum(list);
    System.out.println("Result: " + result);
  }
}

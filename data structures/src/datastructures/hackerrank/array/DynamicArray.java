package datastructures.hackerrank.array;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DynamicArray {

  public DynamicArray() {}

  /*
   *
   * The function is expected to return an INTEGER_ARRAY. The function accepts following parameters:
   * 1. INTEGER n 2. 2D_INTEGER_ARRAY queries
   */

  public static List<List<int[]>> dynamicArray(int n, List<List<Integer>> queries) {
    int lastAnswer = 0;
    int arr[][] = new int[n][n];
    for (int i = 0, len = arr.length; i < len; i++) {
      for (int j = 0; j < arr[i].length; j++) {
        arr[i][j] = -1;
      }
    }
    for (int i = 0; i < queries.size(); i++) {
      List<Integer> query = queries.get(i);
      int first = query.get(0);
      if (first == 1) {
        int result = (query.get(1) ^ lastAnswer) % n;
        for (int j = 0; j < arr[result].length; j++) {
          if (arr[result][j] == -1) {
            arr[result][j] = query.get(2);
            break;
          }
        }

      } else if (first == 2) {
        int result = (query.get(1) ^ lastAnswer) % n;
        lastAnswer = arr[result][query.get(2) % arr[result].length];
        System.out.println(lastAnswer);
      }
    }
    return Arrays.stream(arr).map(Arrays::asList).collect(Collectors.toList());
  }

  public static void main(String[] args) throws IOException {
    int n = 2;
    int q = 5;
    List<List<Integer>> queries = new ArrayList<>();
    List<Integer> liste1 = new ArrayList<>();
    liste1.add(1);
    liste1.add(0);
    liste1.add(5);
    queries.add(liste1);
    List<Integer> liste2 = new ArrayList<>();
    liste2.add(1);
    liste2.add(1);
    liste2.add(7);
    queries.add(liste2);
    List<Integer> liste3 = new ArrayList<>();
    liste3.add(1);
    liste3.add(0);
    liste3.add(3);
    queries.add(liste3);
    List<Integer> liste4 = new ArrayList<>();
    liste4.add(2);
    liste4.add(1);
    liste4.add(0);
    queries.add(liste4);
    List<Integer> liste5 = new ArrayList<>();
    liste5.add(2);
    liste5.add(1);
    liste5.add(1);
    queries.add(liste5);
    dynamicArray(n, queries);
  }
}

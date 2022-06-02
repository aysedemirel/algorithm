package sorting;

import java.util.Arrays;

public class InsertionSort {
  private int[] numbers;

  public InsertionSort(int[] numbers) {
    this.numbers = numbers;
  }

  public int[] sort() {
    System.out.println(Arrays.toString(numbers));
    // time complexity: O(n^2)
    for (int i = 1; i < numbers.length; i++) {
      int key = numbers[i];
      int j = i - 1;
      for (; (j >= 0 && numbers[j] > key); j--) {
        numbers[j + 1] = numbers[j];
      }
      numbers[j + 1] = key;
      System.out.println(Arrays.toString(numbers));
    }
    return numbers;
  }

  public static void main(String[] args) {
    int[] numbers = {22, 27, 16, 2, 18, 6};
    InsertionSort insertionSort = new InsertionSort(numbers);
    insertionSort.sort();
    /**
     * Expected OUTPUT: <br>
     * [22, 27, 16, 2, 18, 6] <br>
     * [22, 27, 16, 2, 18, 6] <br>
     * [16, 22, 27, 2, 18, 6] <br>
     * [2, 16, 22, 27, 18, 6] <br>
     * [2, 16, 18, 22, 27, 6] <br>
     * [2, 6, 16, 18, 22, 27]
     */
  }
}

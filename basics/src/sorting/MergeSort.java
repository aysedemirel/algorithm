package sorting;

import java.util.Arrays;

public class MergeSort {

  public MergeSort() {}

  public void sort(int[] numbers, int left, int right) {
    // time complexity: O(nlogn)
    if (left < right) {
      int middle = left + (right - left) / 2;
      sort(numbers, left, middle);
      sort(numbers, middle + 1, right);
      merge(numbers, left, middle, right);
    }
    System.out.println(Arrays.toString(numbers));
  }

  private void merge(int[] numbers, int left, int middle, int right) {
    int leftLength = middle - left + 1;
    int rigthLength = right - middle;

    int[] leftSide = new int[leftLength];
    int[] rightSide = new int[rigthLength];

    for (int i = 0; i < leftLength; ++i) {
      leftSide[i] = numbers[left + i];
    }
    for (int i = 0; i < rigthLength; ++i) {
      rightSide[i] = numbers[middle + 1 + i];
    }

    int i = 0;
    int j = 0;
    int k = left;
    while (i < leftLength && j < rigthLength) {
      if (leftSide[i] <= rightSide[j]) {
        numbers[k] = leftSide[i];
        i++;
      } else {
        numbers[k] = rightSide[j];
        j++;
      }
      k++;
    }
    while (i < leftLength) {
      numbers[k] = leftSide[i];
      i++;
      k++;
    }
    while (j < rigthLength) {
      numbers[k] = rightSide[j];
      j++;
      k++;
    }
  }

  public static void main(String[] args) {
    int[] numbers = {16, 21, 11, 8, 22, 12};
    new MergeSort().sort(numbers, 0, numbers.length - 1);
    /**
     * Expected OUTPUT: <br>
     * [16, 21, 11, 8, 22, 12] <br>
     * [11, 16, 21, 8, 22, 12] <br>
     * [11, 16, 21, 8, 12, 22] <br>
     * [8, 11, 12, 16, 21, 22]
     */
  }
}

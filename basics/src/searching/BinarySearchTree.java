package searching;

import sorting.MergeSort;

// Time complexity: O(logn)
public class BinarySearchTree {
  private int[] numbers;

  public BinarySearchTree(int[] numbers) {
    this.numbers = numbers;
  }

  public int searchIterative(int no, int low, int high) {
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (numbers[mid] == no)
        return mid;

      if (numbers[mid] < no)
        low = mid + 1;

      else
        high = mid - 1;
    }
    return -1;
  }

  public int searchRecursive(int no, int low, int high) {
    if (high >= low) {
      int mid = low + (high - low) / 2;

      if (numbers[mid] == no)
        return mid;

      if (numbers[mid] > no)
        return searchRecursive(no, low, mid - 1);

      return searchRecursive(no, mid + 1, high);
    }

    return -1;
  }

  public int search(int no, int mid) {
    if (mid > numbers.length - 1 || (mid == numbers.length - 1 && !(numbers[mid] == no))) {
      return -1;
    }
    if (numbers[mid] == no) {
      return mid;
    } else if (no < numbers[mid]) {
      return search(no, mid / 2);
    } else {
      return search(no, mid + (numbers.length - mid) / 2);
    }
  }

  public static void main(String[] args) {
    int[] numbers = {7, 5, 1, 8, 3, 6, 0, 9, 4, 2};
    MergeSort mergeSort = new MergeSort();
    mergeSort.sort(numbers, 0, numbers.length - 1);
    BinarySearchTree bst = new BinarySearchTree(numbers);
    int result = bst.search(9, numbers.length / 2);
    System.out.println("Result index: " + (result == -1 ? "NotFound" : result));
    result = bst.search(119, numbers.length / 2);
    System.out.println("Result index: " + (result == -1 ? "NotFound" : result));
  }
}

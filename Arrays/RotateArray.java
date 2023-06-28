
/* Rotate array by K elements to the right
  Input: N = 7, array[] = {1,2,3,4,5,6,7} , k=2 
  Output: 6 7 1 2 3 4 5
*/

public class RotateArray {
  /*
   * Brute Force: 
   *  TC: O(N) , SC: O(N)
      i.) copy last k elements into a temp arr
      ii.) then traverse from n-k to 0th element and shift it k positions forward
      iii.) finally put back the k elements into the original array
   */
  public static void rotate(int arr[], int k) {
    int temp[] = new int[k];
    int x = 0, n = arr.length;
    for (int i = n-k; i < n; i++)
      temp[x++] = arr[i];

    for (int i = n-k-1; i >= 0; i--) {
      arr[i+k] = arr[i]; 
    }

    x = 0;
    for (int i = 0; i < k; i++)
      arr[i] = temp[x++];
  }

  /*
   * Optimal Approach
   * i.) reverse the first n-k elements & the last k elements 
   * ii.) finally, reverse the whole array
   */
  public static void rotateOptimal(int arr[], int k) {
    int n = arr.length;
    reverseArr(arr, n-k, n-1);
    reverseArr(arr, 0, n-k-1);
    reverseArr(arr, 0, n-1);
  }

  private static void reverseArr(int arr[], int start, int end) {
    while (start < end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;
      start++;
      end--;
    }
  }
  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5,6,7};
    int k = 2;
    rotateOptimal(arr, k);

    for (int i : arr)
      System.out.print(i + " ");
  }
}

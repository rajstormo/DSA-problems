/*
  Input: 1 ,0 ,2 ,3 ,0 ,4  ,0 ,1
  Output: 1 ,2 ,3 ,4 ,1 ,0 ,0 ,0
  Explanation: All the zeros are moved to the end and non-negative integers are moved to front by maintaining order
 */
public class MoveZeroesToEnd {

  /*
   * Naive Approach
   * i.) create a temp arr and push the non-zero elements in it
   * ii.) and then fill the rest of the temp arr with 0
   */
  
  private static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  /*
   * Optimal: O(N) time
   */
  public static void moveZeroes(int arr[]) {
    int i = 0, j = 0;
    // idea is to point to 0 using i variable and using j find the non-zero value, finally swap values at i and j
    while (j < arr.length) {
      if (arr[j] != 0) {
        swap(arr, i, j);
        i++;
      }
      j++;
    }
  }

  public static void main(String[] args) {
    int arr[] = {1,0,2,3,0,4,0,1};
    moveZeroes(arr);

    for (int i : arr) 
      System.out.print(i + " ");
  }
}

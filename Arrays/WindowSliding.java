/* 
Question: Find max sum of K consecutive elements 
e.g: arr = [1,8,30,-5,20,7]
      k = 3
      o/p : 45
 */

public class WindowSliding {
  //naive approach: O(n*k)
  static int maxConsecutiveSum(int arr[], int k) {
    int res = Integer.MIN_VALUE;
    for (int i = 0; i <= arr.length-k; i++) {
      int curr_sum = 0;
      for (int j = 0; j < k; j++) {
        curr_sum += arr[i+j];
      }
      res = Math.max(curr_sum,res);
    }
    return res;
  }

  /*use window sliding technique: O(n)
    compute the sum of first k elements
    now, to calculate sum of next k elements, we will use the already computed sum of first k elements
    how? we will add the next element and then delete the element of the previous window or subarray
  */
  static int maxConsecutiveSum2(int arr[], int k) {
    int curr_sum = 0;
    for (int i = 0; i < k; i++)
      curr_sum += arr[i];
    
    int max_sum = curr_sum;
    for (int i = k; i < arr.length; i++) {
      curr_sum += arr[i] - arr[i-k];
      max_sum = Math.max(max_sum, curr_sum);
    }
    return max_sum;
  }

  public static void main(String[] args) {
    int arr[] = {1,8,30,-5,20,7};
    int k = 3;
    System.out.println(maxConsecutiveSum2(arr, k));
  }
}


/*
 * Longest Subarray with given Sum K(Positives)
  Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
  Example 1:
  Input Format: N = 3, k = 5, array[] = {2,3,5}
  Result: 2
  Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.
*/

public class LongestSubarrSumK {
  /*
   * Brute Force 
   */
  public static int findSubArray(int arr[], int k) {
    int maxLength = 0;
    for (int i = 0; i < arr.length-1; i++) {
      int sum = 0;
      for (int j = i; j < arr.length; j++) {
        sum += arr[j];
        if (sum == k) {
          maxLength = Math.max(maxLength, j-i+1);
          if (j+1 <= arr.length-1 && arr[j+1] != 0)
            break;
        }
      }
    }
    return maxLength;
  }

  /*
   * Optimal 
  */
  public static int findSubArrayOptimal(int arr[], int k) {
    int maxLength = 0, sum = 0;
    int i = 0, j = 0;
    while (j < arr.length) {
      sum += arr[j];
      if (sum < k)
        j++;
      else if (sum == k) {
        maxLength = Math.max(maxLength, j-i+1);
        sum -= arr[i];
        i++;
        j++;
      }
      else {
        if (i < arr.length)
          sum -= arr[i];
        i++;
      }
    }
    return maxLength;
  }

  public static void main(String[] args) {
    int arr[] = {2,3,5,1,1,9};
    int res = findSubArray(arr, 10);
    System.out.println(res);
    System.out.println(findSubArrayOptimal(arr, 10));
  }
}

/*
Question: Given an array. find max sum of a subarray
  subarray: contigous elements picked from an array 
  e.g:
    arr = [2,3,-8,7,-1,2,3]
      o/p: 11
    arr = [5,8,3]
      o/p: 16
*/

public class MaxSumSubarray {
  /* Naive: O(n2)
    try all the possible subarrays and find sum of them. keep on updating the maximum sum find till now
  */
  static int findMaxSubarray1(int arr[]) {
    int ans = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
      int temp = 0;
      for (int j = i; j < arr.length; j++) {
        temp += arr[j];
        ans = Math.max(temp,ans);
      }
    }
    return ans;
  }

  // the idea is to extend the prev arr or start a new subarray  
  // we already have the maximum sum for prev. elements
  //Kadane's algorithm: find's max sum of subarray 
  static int findMaxSubarray2(int arr[]) {
    int ans = arr[0];
    int max_ending_here = arr[0];
    for (int i = 1; i < arr.length; i++) {
      max_ending_here = Math.max(max_ending_here + arr[i], arr[i]); 
      ans = Math.max(max_ending_here,ans);
    }
    return ans;
  }

  
  public static void main(String[] args) {
    int arr[] = {2,3,-8,7,-1,2,3};
    // int arr[] = {-6,-1,-8};
    System.out.println(findMaxSubarray2(arr));
  }
}
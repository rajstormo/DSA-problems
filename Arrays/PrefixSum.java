/*
Question: given an array and q queries. for each query, you are given start index and end index.
find the the subarray sum from start to end
e.g: arr = [2,8,3,9,6,5,4]
      q = 3
        l = 0, r = 2
          o/p: sum = 13
        l = 1, r = 3
          o/p: 20
 */

/*
Naive approach: 
  for each and every query, run a loop from start to end index and calculate the sum 
  it will take, O(q * n) time 
*/

public class PrefixSum {
  
  // Use prefix sum : precompute the sum of array 
  static int computePrefixSum(int arr[], int l, int r) {
    //create a new array and initilize it
    int A[] = new int[arr.length];
    A[0] = arr[0];
    for (int i = 1; i < arr.length; i++) {
      A[i] = A[i-1] + arr[i];
    }
    
    if (l == 0)
      return A[r];
    return A[r] - A[l-1];
  }

  public static void main(String[] args) {
    int arr[] = {2,8,3,9,6,5,4};
    System.out.println(computePrefixSum(arr,1,3));
  }
}
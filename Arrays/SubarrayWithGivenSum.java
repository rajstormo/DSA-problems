/*
Question: Given array of non-negative no. find whether there exists a subarray with the given sum or not
e.g: arr = [1,4,20,3,10,5]
     sum = 33
      o/p: Yes, [20,3,10]
*/

public class SubarrayWithGivenSum {
  //naive approach: try all the possible subarrays and keep checking if sum == given_sum or not
  static boolean findSubarraySum(int arr[], int sum) {
    for (int i = 0; i < arr.length; i++) {
      int curr_sum = 0;
      for (int j = i; j < arr.length; j++) {
        curr_sum += arr[j];
        if (curr_sum == sum)
          return true;
        else if (curr_sum > sum)
          break;
      }
    }
    return false;
  }

  //window sliding technique with window of variable size: O(n)
  static boolean findSubarraySum2(int arr[], int sum) {
    //initial window size is 0
    int s = 0;
    int curr_sum = 0;
    for (int e = 0; e < arr.length; e++) {
      curr_sum += arr[e];
      // while curr_sum comes out to be greater than given sum, then there is no need of inc. the subarray and taking it's sum as it will never be equal to given sum. so, we will consider a new subarray/window and hence increment the variable s.
      while (curr_sum > sum) {
        curr_sum -= arr[s];
        s++;
      }
      if (curr_sum == sum)
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int arr[] = {1,4,20,3,10,5};
    System.out.println(findSubarraySum(arr,33)); 
  }
}
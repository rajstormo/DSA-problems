
/*
find max. difference of arr[j]-arr[i], s.t j > i 
e.g: arr = [2,3,10,6,4,8,1]
o/p: 8 
*/

public class MaxDifference {  
  //Naive Approach: O(n^2)
  static void findMaxDifference(int arr[]) {
    int n = arr.length;
    int max_diff = Integer.MIN_VALUE;
    for (int i = 0; i < n-1; i++) {
      for (int j = i+1; j < n; j++) {
        int diff = arr[j]-arr[i];
        max_diff = Math.max(max_diff,diff);
      }
    }
    System.out.println(max_diff);
  }

  // Optimised: O(n) approach
  // max. diff can be obtained if arr[j] is maximum and arr[i] is minimum possible 
  // so maintain the min. element found till ith index
  static void findMaxDifference_2(int arr[]) {
    int min_element = arr[0];
    int diff = 0;
    for (int i = 1; i < arr.length; i++) {
      diff = Math.max(diff,arr[i]-min_element);
      min_element = Math.min(min_element,arr[i]);
    }
    System.out.println(diff);
  }
  
  public static void main(String[] args) {
    // int arr[] = {2,3,10,6,4,8,1};
    int arr[] = {30,10,8,2};
    findMaxDifference(arr);
    findMaxDifference_2(arr);
  }
}

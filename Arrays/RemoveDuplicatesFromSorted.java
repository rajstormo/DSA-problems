
/* remove duplicate elements from the array
  Input: arr[1,1,2,2,2,3,3]

  Output: arr[1,2,3,_,_,_,_]

  Explanation: Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3 after assigning [1,2,3] in the beginning of the array.
*/

public class RemoveDuplicatesFromSorted {

  /*
   * Brute Force : O(nlogn + n)
      Use Hashset which will store the unique elements
      then, copy back the unique elements from the set to the array
   */

  /*
   * Optimal Approach
   *  TC: O(n)
   *  set i = 0, now traverse from j = 1 to n-1 and search for distinct element in comparison to A[i]
   *  if found -> place that element at A[++i];
   */
  public static void removeDuplicate(int arr[]) {
    int i = 0;
    for (int j = 1; j < arr.length; j++) {
      if (arr[j] != arr[i]) 
        arr[++i] = arr[j]; 
    }
  }

  public static void main(String[] args) {
    int arr[] = {1,1,2,2,2,3,3};
    removeDuplicate(arr);

    for (int i : arr)
      System.out.print(i + " ");
  }
}

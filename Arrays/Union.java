
/*The union of two arrays can be defined as the common and distinct elements in the two arrays.NOTE: Elements in the union should be in ascending order.
  n = 5, m = 5.
  arr1[] = {1,2,3,4,5}  -> sorted
  arr2[] = {2,3,4,4,5} -> sorted
  Output:
 {1,2,3,4,5}
 */

import java.util.*;


public class Union {

  /*
   * Naive Approach 
    * take a set 
    * iterate on both the given arrays and push it into the set 
    * set will provide the unique and distinct elements
  */

  /*
   * Optimal Approach: 2 pointers
   * set i = 0, j = 0
   * traverse till i < arr1.length && j < arr2.length
    * if (arr1[i] <= arr2[j]) -> push it into a new_arr & increment i
    * else -> push arr2[j] and increment j
   * if there can be some elements which are not compared, so run a loop and push them into the new_arr 
   * also add a check so that no duplicate elements are inserted
   */
  public static ArrayList<Integer> getUnion(int A[], int B[]) {
    int i = 0, j = 0;
    ArrayList<Integer> res = new ArrayList<>();

    while (i < A.length && j < B.length) {
      if (A[i] <= B[j]) {
        if (res.size() == 0 ||  res.get(res.size()-1) != A[i])
          res.add(A[i]);
        i++;
      }

      else {
        if (res.size() == 0 ||  res.get(res.size()-1) != B[j])
          res.add(A[j]);
        j++;
      }
    }
    
    for (; i < A.length; i++) {
      if (res.get(res.size()-1) != A[i])
        res.add(A[i]);
    }
    for (; j < B.length; j++) {
      if (res.get(res.size()-1) != B[j])
        res.add(B[j]);
    }
    
    return res;
  }

  public static void main(String[] args) {
    int arr1[] = {1,2,3,4,5};
    int arr2[] = {2,3,4,4,5};
    ArrayList<Integer> ans = getUnion(arr1, arr2);
    for (int i : ans)
      System.out.print(i + " ");
  }
}
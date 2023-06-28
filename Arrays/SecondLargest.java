/* Find 2nd largest element in an Array
  Input: [1,2,4,7,7,5]
  Output: 
    Second Largest : 5
*/

import java.util.*;

public class SecondLargest {

  // Brute force : sort the arr -> O(nlogn)
  public static int findSecondLargest(int arr[]) {
    Arrays.sort(arr);
    int largest = arr[arr.length-1];
    int i = arr.length - 2;
    while (arr[i] == largest) {
      i--;
    }
    return arr[i];
  }

  /*
   * Better Approach
    * first find the largest element -> O(N)
    * again, loop through the array and find the 2nd largest
  */
  public static int findSecondLargestBetter(int arr[]) {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int i : arr)
      largest = Math.max(largest, i);
    
    for (int i : arr) {
      if (i < largest && i > secondLargest)
        secondLargest = i;
    }

    return secondLargest;
  }

  /*
   * Optimal : in one traversal
    * traverse through the array
      if the element > largest , update SL = largest and Largest = element 
      also, if a element > SL but element < L , update SL = element
  */ 
  public static int findSecondLargestOptimal(int arr[]) {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int i : arr) {
      if (i > largest) {
        secondLargest = largest;
        largest = i;
      }
      if (i < largest && i > secondLargest)
        secondLargest = i;
    }
    return secondLargest;
  }

  public static void main(String[] args) {
    int arr[] = {1,2,4,7,7,6,5};
    System.out.println(findSecondLargest(arr));
    System.out.println(findSecondLargestBetter(arr));
    System.out.println(findSecondLargestOptimal(arr));
  }
}
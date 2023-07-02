
/*
 * Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.
 * Example 1:
    Input Format: N = 5, array[] = {1,2,4,5}
    Result: 3
 */

public class MissingNumber {
  /*
   * Naive Approach: O(N^2)
   *  traverse from i = 1 to N
   *    for each of the element i, traverse in the array and check if i exists or not
   *      if (!exists) return it
  */

  /* 
   * Better 
   *  take an hashArr(type = boolean) of size n+1
   *  traverse over the given arr 
   *    for each of element, set it as true in the hashArr
   *  Now, traverse over the hashArr and check at which index the value equals false -> simply return that index which will be the missing element
   
   TC: O(N) + O(N) => O(2N)
   SC: O(N) -> for hashArr
  */
  public static int findMissingNum2(int arr[], int n) {
    boolean freq[] = new boolean[n+1];
    for (int i : arr)
      freq[i] = true;
    
    for (int i = 1; i < freq.length; i++) 
      if (freq[i] == false)
        return i;
      
    return -1;
  }

  /*
   * Optimal: 
   *  take sum = 0
   *  traverse over the array and find the sum of all elements and update sum variable
   *  return (n*(n+1)) - sum
   TC: O(N)
  */
  
  /*
   * Optimal2:
   *  use the property of xor operator -> xor of same elements give 0 and 0 ^ element = element
   *  take xor = 0
   *  run a loop from i = 0 to N-2 and do xor = xor ^ arr[i] and xor = xor ^ (i+1)
   *  xor = (xor ^ n)
   *  return xor
   
   TC: O(N)
   */
  public static int findMissingNum4(int arr[], int n) {
    int xor = 0;
    for (int i = 0; i < n-1 ; i++) {
      xor ^= arr[i];
      xor ^= (i+1);
    }
    xor ^= (n);

    return xor;
  }

   public static void main(String[] args) {
    int arr[] = {1,2,4,5};
    int n = 5;
    System.out.println(findMissingNum2(arr, n));
    System.out.println(findMissingNum4(arr, n));

   }
  
}

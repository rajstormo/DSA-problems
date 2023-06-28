/*
Question: Given a binary array i.e containing 0 and 1
find max no. of consecutive 1's 
e.g: 
  arr = [1,0,1,1,1,1,0,1,1]
    o/p: 4
  arr = [1,1,1,1]
    o/p: 4
*/

public class MaxConsecutive1s {
  /*naive approach: O(n^2)
    traverse through every element, and for every element we count how many consecutive 1's are there 
    we take a ans variable which we update to get the max consective 1's 
  */
  static int countMax1(int arr[]) {
    int ans = 0;
    for (int i = 0; i < arr.length; i++) {
      int count = 0;
      for (int j = i; j < arr.length; j++) {
        if (arr[j] == 1)
          count++;
        else 
          break;
      }
      ans = Math.max(ans,count);
    }
    return ans;
  }

  /*optimized: O(n)
    traverse from left to right, whenever we encounter a 0, reset the current count 
    otherwise increment the count and keep on updating the max consective 1's find till now
  */
  static int countMax2(int arr[]) {
    int ans = 0, curr = 0;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) 
        curr = 0;
      else 
        curr++;
      
      ans = Math.max(ans,curr);
    }
    return ans;
  }

  public static void main(String[] args) {
    int arr[] = {0,1,1,0,1,1,1};
    System.out.println(countMax2(arr));
  }
}

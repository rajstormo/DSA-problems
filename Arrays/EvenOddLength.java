/*
Question: Find max. length even-odd subarray
  e.g: 
    arr = [10,12,14,7,8]
      o/p: 3
    
    arr = [7,10,13,14]
      o/p: 4
*/

public class EvenOddLength {
  static int findMaxEvenOddLength(int arr[]) {
    int res = 1;
    for (int i = 0; i < arr.length-1; i++) {
      int curr = 1;
      for (int j = i+1; j < arr.length; j++) {
        if (arr[j] % 2 == 0 && arr[j-1] % 2 != 0 || arr[j] % 2 != 0 && arr[j-1] % 2 == 0)
          curr++;
        else 
          break; //bcoz subarray elements need to be contiguous
      }
      res = Math.max(res,curr);
    }
    return res;
  }

  // use kadane's algorithm: O(n)
  static int findMaxEvenOddLength2(int arr[]) {
    int res = 1;
    int curr = 1;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] % 2 == 0 && arr[i-1] % 2 != 0 || arr[i] % 2 != 0 && arr[i-1] % 2 == 0)
        curr++;
      
      // if the array till i is not alternating(even-odd), start a new subarray with i
      else 
        curr = 1;

      res = Math.max(res,curr); //update the max. subarray of alternating odd-even length
    } 
    return res;
  }

  public static void main(String[] args) {
    int arr[] = {7,10,13,14};
    // int arr[] = {10,12,14,7,8};
    System.out.println(findMaxEvenOddLength2(arr));
  }
}
  

/* Find Majority element
  majority element: an element which appears more than n/2 times (where n is size of array)
  e.g: 
    arr = [8,3,4,8,8]
      o/p: 0 or 3 or 4 => return the index of majority element else return -1 if it doesn't exist
*/

public class MajorityElement {
  //Naive Approach: O(n^2)
  static int findMajorityElement(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
      int count = 1;
      for (int j = i+1; j < n; j++) {
        if (arr[j] == arr[i])
          count++;
      }
      if (count > n/2)
        return i;
    }
    return -1;
  } 

  //Moore's Voting algorithm: O(n)
  static int findMajorityElement2(int arr[]) {
    int n = arr.length;
    //phase1: find a candidate
    int count = 1, res = 0;
    for (int i = 1; i < n; i++) {
      if (arr[i] == arr[res])
        count++;  
      else 
        count--;
      
      if (count == 0) {
        res = i;
        count = 1;
      }
    }

    //phase2: check if candidate is actually a majority
    count = 0;
    for (int i = 0; i < n; i++) {
      if (arr[i] == arr[res])
        count++;
    }
    if (count <= n/2)
      return -1;
    else 
      return res;
  }

  public static void main(String[] args) {
    // int arr[] = {8,3,4,8,8};
    int arr[] = {8,8,6,6,4,6};
    System.out.println(findMajorityElement2(arr));
  }
}

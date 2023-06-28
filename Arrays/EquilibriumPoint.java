/* 
Question: given an array. return the index of any equilibrium point that exists
  equilbrium point: if sum of elements before it and after it are same, it is equilbrium point
  e.g: arr = [3,4,8,-9,20,6]
        o/p: true (point is 20)
*/

public class EquilibriumPoint {
  //use precomputation technique
  static int checkEquiPoint(int arr[]) {
    int n = arr.length;
    int sum = 0;
    for (int i = 0; i < n; i++)
      sum += arr[i];
    
    int leftSideSum = 0;
    int rightSideSum = sum;

    for (int i = 0; i < n; i++) {
      rightSideSum -= arr[i];
      if (leftSideSum == rightSideSum)
        return i;
      leftSideSum += arr[i];
    }
    return -1; //if no equilibrium point found
  }
  
  public static void main(String[] args) {
    int arr[] = {3,4,8,-9,20,6};
    System.out.println(checkEquiPoint(arr));
  }  
}

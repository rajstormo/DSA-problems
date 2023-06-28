/*
Trapping Rain Water problem
  arr of non-negative elements
  bars of different heights are given
  how much units of water can be collected b/w the bars

  e.g: arr = [3,0,1,2,5]
      o/p : 6
    arr = [1,2,3]
      o/p: 0
    arr = [3,2,1]
      o/p: 0
*/

public class RainWaterTrap {
  /* Naive Approach
    first thing to notice is that no water can be trapped for the 1st and last bar as there is no bar for support on the left and right respectively 
    find left max bar -> max left bar so that we can store max water
    find rMax -> right max bar 
  */

  static int findWaterTrapped(int arr[]) {
    int ans = 0;
    for (int i = 1; i < arr.length-1; i++) {
      int lMax = arr[i];
      for (int j = 0; j < i; j++)
        lMax = Math.max(lMax,arr[j]);
      
      int rMax = arr[i];
      for (int j = i+1; j < arr.length; j++)
        rMax = Math.max(rMax,arr[j]);
      
      ans += Math.min(rMax,lMax) - arr[i];
    }
    return ans;
  }

  //Optimized O(n): preCompute lMax and rMax so that we don't have to calculate it for every index
  static int findWaterTrapped2(int arr[]) {
    int n = arr.length;
    int lMax[] = new int[n];
    int rMax[] = new int[n];
    lMax[0] = arr[0];
    for (int i = 1; i < n; i++) {
      lMax[i] = Math.max(arr[i],lMax[i-1]);
    }

    rMax[n-1] = arr[n-1];
    for (int i = n-2; i >= 0; i--) {
      rMax[i] = Math.max(arr[i],rMax[i+1]);
    }
    int ans = 0;
    for (int i = 1; i < n-1; i++) {
      ans += Math.min(lMax[i],rMax[i]) - arr[i];
    }
    return ans;
  }
  
  public static void main(String[] args) {
    int arr[] = {3,0,1,2,5};
    System.out.println(findWaterTrapped2(arr));
  }
}
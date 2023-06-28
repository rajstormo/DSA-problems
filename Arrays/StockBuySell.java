
/*
Question: given an array representing the stocks of n days in advance 
we can buy and sell the stock on any day. maximize the profit 
arr = [1,5,3,8,12]
o/p = 13 (5-1 + 12-3)
*/

public class StockBuySell {

  // take the bottom and the peak value and add it to the total profit
  // while the stock value is increasing i.e if it greater than the prev. day stock price, keep it adding to the profit and return it
  static int solve(int arr[]) {
    int profit = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > arr[i-1])
        profit += arr[i] - arr[i-1];
    }
    return profit;
  }

  public static void main(String[] args) {
    int arr[] = {1,5,3,8,12};
    System.out.println(solve(arr));
  }
}

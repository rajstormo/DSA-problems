
// Problem: https://leetcode.com/problems/unique-paths/description/

public class UniquePaths {
  /*
    Finding All unique paths 
    * @param {int} rows - no. of rows
    * @param {int} columns - no. of columns
    * @param {int} currentRow 
    * @param {int} currentCol
    * @returns {int} no. of unique path from [0,0] to [m-1, n-1]
 */
  private int helper(int m, int n, int i, int j, int dp[][]) {
    // base case: when either i reaches m or j reaches n, we have a path available, return 1
    if (i == m - 1 || j == n - 1)
      return 1;

    // if ans already exists, for a particular cell, just return it to avoid further recursion calls
    if (dp[i][j] != 0)
      return dp[i][j];

    // call recursively by moving one cell down
    int exploreBottom = helper(m, n, i + 1, j, dp);

    // move one cell to the right 
    int exploreRight = helper(m, n, i, j + 1, dp);

    // store the ans and then return it back to the prev func call
    dp[i][j] = exploreBottom + exploreRight;
    return dp[i][j];
  }

  public int uniquePath(int m, int n) {
    int dp[][] = new int[100][100];
    return helper(m, n, 0, 0, dp);
  }
}
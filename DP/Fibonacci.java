
class Fibonacci {
    
    static private int getFibo(int n, int dp[]) {
        // base case
        if (n == 1 || n == 2)
            return 1;
        
        // if value already exists, just return it -> no need to do further func calls
        if (dp[n] != -1)
            return dp[n];
        
        // otherwise call for the prev 2 values and store the result in dp array
        int first = getFibo(n-1, dp) % 1000000007;
        int second = getFibo(n-2, dp) % 1000000007;
        dp[n] = (first + second) % 1000000007;
        
        //remember to return it back to the prev func call
        return dp[n];
    }

    static private int getFiboIterative(int n) {
      if (n == 1 || n == 2)
        return 1;
      
      int first = 1, second = 1, third = 0;
      for (int i = 0; i < n-2; i++) {
        third = first + second;
        first = second; 
        second = third;
      }
      return third;
    }
    
    static int nthFibonacci(int n){
        int size = 100001;
        int dp[] = new int[size];
        for (int i = 0; i < size; i++)
            dp[i] = -1;
            
        return getFibo(n, dp);
    }
}
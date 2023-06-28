import java.util.*;

public class trailingZeroes {
  public static void main(String[] args) {
    // 5! -> 120  => 1 trailing zero 
    int n = 10;
    int ans = 0;
    for (int i = 5; i <= n; i=i*5) {
      ans += n/i;
    }
    System.out.println(ans);
  }
}
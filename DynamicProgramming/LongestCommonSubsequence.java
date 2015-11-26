
import java.util.*;
import java.lang.*;

public class LongestCommonSubsequence {
  
  public static void main (String args[]) {
    System.out.println (longestSubSequence("abcdaf", "acbcf"));
  }
  
  public static String longestSubSequence (String s1, String s2) {
    // base case
    if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0)
      return null;

    // generic case
    int n = s1.length();
    int m = s2.length();

    String output= "";

    int[][] grid = new int[n+1][m+1];
    int max = 0;
    for (int i=0; i <= n; i++)
      grid[i][0] = 0;
    for (int j=0; j <= m; j++)
      grid[0][j] = 0;

    for (int i=1; i<= n; i++) {
      for (int j=1; j <= m; j++ ) {
        // if hit
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
          grid[i][j] = grid[i-1][j-1] + 1;
          if (grid[i][j] > max) {
            max = grid[i][j];
            output = output + s1.charAt(i-1);
          }
        }
        // else
        else
          grid[i][j] = Math.max (grid[i-1][j], grid[i][j-1]);
      }
    }
    return output;
  }
}

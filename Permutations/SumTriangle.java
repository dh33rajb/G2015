/*
Imagine you have a row of numbers like below(a triangle) .By starting at the top of the triangle find the maximum number in each line and sum them up example below 
5 
9 6 
4 6 8 
8 7 15 

Answer I.e. 5+9+8+7 = 29 
writw a code to find the maximum total from top to bottom. Assume triangle can have at most 100000 rows.

Input Output specifications 
Input Specification 
A string of n numbers (where 0<=n<=10^10) 
eg.5#9#6#4#6#8#0#7#1#5 

Output Specification 
A sum of the max numbers in each line (as string ) or Output invalid in case of invalid input/triangle 

Examples 
eg1. 
Input :5#9#6#4#6#8#0#7#1#5 
Output:29 
*/
import java.util.*;
import java.lang.*;

class SumTriangle {
  public static void main (String args[]) {
    System.out.println (findSum ("5#9#6#4#6#8#0#7#1#5"));
  }
  
  public static String findSum (String input) {
    // base case
    if (input == null || input.length() == 0)
      return null;

    // generic case
    // Step-1: string array to ints array
    String[] sarr = input.split("#");
    int[] nums = new int[sarr.length];
    int i = 0;
    for (String s : sarr) {
      nums[i++] = Integer.parseInt(s);
    }

    int sum = 0;
    int bracket = 1;
    int currBracket = bracket;
    int currBracketMax = 0;
    // Step-2: Core logic
    for (int j : nums) {
      if (currBracket == 0) {
        sum = sum + currBracketMax;
        bracket++;
        currBracket = bracket;
        currBracketMax = 0;
      }
      if (j > currBracketMax) {
          currBracketMax = j;
        }
      currBracket--;
    }
    sum = sum + currBracketMax;
    if (currBracket > 0)
      return "invalid";
    return Integer.toString(sum);
  }
}

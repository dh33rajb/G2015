/*
write a method that takes in 2 int arrays of any size and returns an array that calculates the sum of both. 

for example, [1,2,3] and [2,3,4] will return [3,5,7] 

Or [1,2,3] and [2,3,5,5] will return [2,4,7,8] 

however, if it's like [9,9,2] and [0,1,3] you need to carry the sum so it returns as [1,0,0,5]
*/

import java.util.*;
import java.lang.*;

class SumOfArraysWithCarry {
  public static void main (String args[]) {
    sum (new int[] {9, 9, 2}, new int[] {0, 1, 3});
  }
  
  public static int[] sum (int[] arr1, int[] arr2) {
    // base case
    if (arr1 == null || arr1.length == 0)
      return arr2;
    if (arr2 == null || arr2.length == 0)
      return arr1;

    // generic case
    int[] output = new int[Math.max (arr1.length, arr2.length) + 1];

    int k = output.length-1;
    int i = arr1.length - 1 ;
    int j = arr2.length - 1;

    int carry = 0;
    while (i >= 0 || j>=0) {
      if (i < 0) {
        int sum = carry + arr2[j];
        output[k] = sum % 10;
        carry = sum / 10;
      } else if (j < 0) {
        int sum = carry + arr1[i];
        output[k] = sum % 10;
        carry = sum / 10;
      } else {
        int sum = carry + arr1[i] + arr2[j];
        output[k] = sum % 10;
        carry = sum / 10;
      }
      i--; j--; k--;
    }
    if (carry != 0) {
      output[k--] = carry;
    }
    System.out.println (Arrays.toString (output));
    return output;
  }
  }

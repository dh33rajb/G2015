/*
Given a string pattern of 0s, 1s, and ?s (wildcards), generate all 0-1 strings that match this pattern. 
e.g. 1?00?101 -> [10000101, 10001101, 11000101, 11001101]. 
You can generate the strings in any order that suits you.
*/

import java.util.*;
import java.lang.*;

public class ZeroOneQuestionMarkPattern {
  
  public static void main (String args[]) {
    allCombinations (("1010?0?1?0").toCharArray(), 0, "");
  }
  
  public static void allCombinations (char[] chars, int level, String output) {
    // recursion end case
    if (level == chars.length) {
      System.out.println (output);
      return;
    }

    if (chars[level] == '?') {
      allCombinations (chars, level + 1, output + "0");
      allCombinations (chars, level + 1, output + "1");
    } else {
      allCombinations (chars, level + 1, output + chars[level]);
    }
  }
}

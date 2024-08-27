package com.practice.dsa.arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

  // recursion
  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> result = new ArrayList<>();
    if (numRows == 0) {
      return result;
    }

    if (numRows == 1) {
      List<Integer> firstRow = new ArrayList<>();
      firstRow.add(1);
      result.add(firstRow);
      return result;
    }

    result = generate(numRows - 1);
    List<Integer> prevRow = result.get(result.size() - 1);
    List<Integer> currentRow = new ArrayList<>();

    currentRow.add(1);
    for (int i = 1; i < prevRow.size(); i++) {
      currentRow.add(prevRow.get(i) + prevRow.get(i - 1));
    }
    currentRow.add(1);
    result.add(currentRow);

    return result;
  }

  public static void main(String[] args) {
    System.out.println(generate(5));
    // [ [1], [1, 1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]
  }
}

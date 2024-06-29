package com.practice.dsa.greedy;

import com.practice.dsa.greedy.FractionalKnapsack.Item.ItemComparator;
import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {

  static class Item {

    static class ItemComparator implements Comparator<Item> {

      @Override
      public int compare(Item i1, Item i2) {
        double rate1 = (double) i1.value / (double) i1.weight;
        double rate2 = (double) i2.value / (double) i2.weight;
        return Double.compare(rate2, rate1);
      }
    }

    int value, weight;

    Item(int x, int y) {
      this.value = x;
      this.weight = y;
    }

    @Override
    public String toString() {
      return "Item{" +
          "value=" + value +
          ", weight=" + weight +
          '}';
    }
  }

  private static double fractionalKnapsack(int weight, Item[] arr, int n) {
    Arrays.sort(arr, new ItemComparator());
    double finalValue = 0.0;
    int currentWeight = 0;

    for (int i = 0; i < n; i++) {
      if (currentWeight + arr[i].weight <= weight) {
        currentWeight += arr[i].weight;
        finalValue += arr[i].value;
      } else {
        int remaining = weight - currentWeight;
        finalValue += ((double) arr[i].value / (double) arr[i].weight) * (double) remaining;
        break;
      }
    }

    return finalValue;
  }

  public static void main(String[] args) {
    Item[] items = new Item[3];
    items[2] = new Item(60, 10);
    items[1] = new Item(100, 20);
    items[0] = new Item(120, 30);

    System.out.println(fractionalKnapsack(50, items, 3));
  }
}

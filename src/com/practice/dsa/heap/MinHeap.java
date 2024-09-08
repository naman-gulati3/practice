package com.practice.dsa.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap<T extends Comparable<T>> {

  private final List<T> list;

  public MinHeap() {
    list = new ArrayList<>();
  }

  private void swap(int idx1, int idx2) {
    T temp = list.get(idx1);
    list.set(idx1, list.get(idx2));
    list.set(idx2, temp);
  }

  private int getParent(int index) {
    return index / 2;
  }

  private int getLeftChild(int index) {
    return 2 * index;
  }

  private int getRightChild(int index) {
    return (2 * index) + 1;
  }

  private void downHeap(int index) {
    int min = index;
    int leftChild = getLeftChild(min);
    int rightChild = getRightChild(min);

    if (leftChild < list.size() && list.get(min).compareTo(list.get(leftChild)) > 0) {
      min = leftChild;
    }

    if (rightChild < list.size() && list.get(min).compareTo(list.get(rightChild)) > 0) {
      min = rightChild;
    }

    if (min != index) {
      swap(min, index);
      downHeap(min);
    }
  }

  private void upHeap(int index) {
    if (index == 0) {
      return;
    }

    int parentIdx = getParent(index);
    // if item at index is less than item at parent
    if (list.get(parentIdx).compareTo(list.get(index)) > 0) {
      swap(parentIdx, index);
      upHeap(parentIdx);
    }
  }


  public void insert(T element) {
    list.add(element);
    upHeap(list.size() - 1);
  }

  public T remove() throws IllegalAccessException {
    if (list.isEmpty()) {
      throw new IllegalAccessException("Heap is empty");
    }

    T toRemove = list.get(0);
    T last = list.remove(list.size() - 1);

    if (!list.isEmpty()) {
      list.set(0, last);
      downHeap(0);
    }
    return toRemove;
  }

  public T get() {
    return list.get(0);
  }

  public static void main(String[] args) throws IllegalAccessException {
    MinHeap<Integer> heap = new MinHeap<>();
    heap.insert(5);
    heap.insert(3);
    heap.insert(7);
    heap.insert(1);
    heap.insert(10);

    System.out.println(heap.get());
    heap.remove();
    System.out.println(heap.get());
    heap.remove();
    System.out.println(heap.get());
  }
}

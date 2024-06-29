package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;

public class RotateLinkedListByKSteps {

  // 5 -> 4 -> 3 -> 2 -> 1 -> null
  public static ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) {
      return head;
    }

    int len = 1;
    ListNode curr = head;
    while (curr.next != null) {
      len++;
      curr = curr.next;
    }

    // 1 -> 2 -> 3 -> 4 -> 5 -> 1 make circular list
    curr.next = head;
    // (5 - 2)%5 = 3
    k = (len - k) % len;
    if (k < 0) {
      k = len + k;
    }
    while (k > 0) {
      curr = curr.next;
      k--;
    }

    head = curr.next;
    curr.next = null;
    return head;
  }

  public static void main(String[] args) {
    // 0, 1, 2  -> original
    // 2, 0, 1
    // 1, 2, 0
    // 0, 1, 2
    // 2, 1, 0 -> 4 rotations
    ListNode rotated = rotateRight(
        new ListNode(0, new ListNode(1, new ListNode(2, null))), 4);
    while (rotated != null) {
      System.out.println(rotated.val);
      rotated = rotated.next;
    }
  }

  // 3, 4, 5, 6, 7

  // 7 - 3 + 1 = 5
  // 6 - 4 + 1 = 3
  // 5 - 5 + 1 = 1
}

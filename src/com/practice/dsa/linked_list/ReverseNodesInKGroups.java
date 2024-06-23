package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;

public class ReverseNodesInKGroups {

  public static void main(String[] args) {
    ListNode reversed = reverseKGroup(
        new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))),
        2);

    while (reversed != null) {
      System.out.println(reversed.val);
      reversed = reversed.next;
    }
  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k == 1) {
      return head;
    }

    ListNode dummy = new ListNode();
    dummy.next = head;
    ListNode curr = dummy;
    ListNode next = dummy;
    ListNode prev = dummy;

    int count = 0;
    while (curr.next != null) {
      count++;
      curr = curr.next;
    }

    // 1 -> 2 -> 3 -> 4 -> null
    //p  c    n
    while (count >= k) {
      curr = prev.next;
      next = curr.next;

      for (int i = 1; i < k; i++) {
        curr.next = next.next;
        next.next = prev.next;
        prev.next = next;
        next = curr.next;
      }
      count -= k;
      prev = curr;
    }

    return dummy.next;
  }
}

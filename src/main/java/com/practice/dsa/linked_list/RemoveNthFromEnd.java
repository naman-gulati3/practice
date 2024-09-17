package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;

public class RemoveNthFromEnd {

  public static void main(String[] args) {
    ListNode res =
        removeNthFromEnd(
            new ListNode(
                1,
                new ListNode(
                    2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6, null)))))),
            2);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }

  // n = 4

  // slow,fast -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> null
  //                                 slow          fast

  // dummy -> 1 -> 2 -> null
  //         slow       fast
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode();
    dummy.next = head;

    ListNode fast = dummy;
    ListNode slow = dummy;

    for (int i = 1; i <= n; i++) {
      fast = fast.next;
    }

    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    // 0 -> 1 -> null
    // slow
    slow.next = slow.next.next;
    return dummy.next;
  }
}

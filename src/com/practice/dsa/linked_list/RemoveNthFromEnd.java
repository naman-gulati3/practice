package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;

public class RemoveNthFromEnd {

  public static void main(String[] args) {
    ListNode res = removeNthFromEnd(new ListNode(1, null), 1);
    while (res != null) {
      System.out.println(res.val);
      res = res.next;
    }
  }
  // n = 4
  // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
  //                        fast
  //     slow

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
    //slow
    slow.next = slow.next.next;
    return dummy.next;
  }
}

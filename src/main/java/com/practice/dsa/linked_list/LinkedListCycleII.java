package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;

public class LinkedListCycleII {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(3);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(0);
    ListNode l4 = new ListNode(-4);

    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = l2;
    ListNode result = detectCycle(l1);
    System.out.println(result.val);
  }

  public static ListNode detectCycle(ListNode head) {
    if (head == null) {
      return null;
    }
    ListNode slow = head;
    ListNode fast = head;
    ListNode entry = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        while (entry != slow) {
          entry = entry.next;
          slow = slow.next;
        }
        return entry;
      }
    }
    return null;
  }
}

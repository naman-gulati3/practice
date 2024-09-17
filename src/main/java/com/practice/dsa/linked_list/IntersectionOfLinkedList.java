package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;

public class IntersectionOfLinkedList {

  public static void main(String[] args) {
    ListNode dup = new ListNode(4, new ListNode(5, null));
    ListNode result =
        getIntersectionNode(
            new ListNode(4, new ListNode(1, new ListNode(8, dup))),
            new ListNode(5, new ListNode(6, new ListNode(1, new ListNode(8, dup)))));

    // 4 -> 1 -> 8 -> 4 -> 5 -> null
    //                ^
    //                |
    // 5 -> 6 -> 1 -> 8
    System.out.println(result.val);
  }

  public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode curA = headA;
    ListNode curB = headB;

    int countA = 0;
    int countB = 0;
    while (curA != null) {
      countA++;
      curA = curA.next;
    }

    while (curB != null) {
      countB++;
      curB = curB.next;
    }

    ListNode newCurA = headA;
    ListNode newCurB = headB;

    int diff = Math.abs(countA - countB);
    if (countA > countB) {
      for (int i = 0; i < diff; i++) {
        newCurA = newCurA.next;
      }
    } else {
      for (int i = 0; i < diff; i++) {
        newCurB = newCurB.next;
      }
    }

    while (newCurA != null && newCurB != null) {
      if (newCurA == newCurB) {
        return newCurA;
      }
      newCurA = newCurA.next;
      newCurB = newCurB.next;
    }
    return null;
  }
}

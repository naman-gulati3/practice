package com.practice.dsa.linked_list;

public class MergeSortedLinkedList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode curr = dummy;

    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }
    // if l1 is exhausted point to l2 otherwise l1
    curr.next = l1 == null ? l2 : l1;
    return dummy.next;
  }

  public static ListNode mergeTwoListsInPlace(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    if (l1.val > l2.val) {
      ListNode temp = l1;
      l1 = l2;
      l2 = temp;
    }
    ListNode result = l1;
    while (l1 != null && l2 != null) {
      ListNode tmp = null;
      while (l1 != null && l1.val <= l2.val) {
        tmp = l1;
        l1 = l1.next;
      }
      tmp.next = l2;

      ListNode temp = l1;
      l1 = l2;
      l2 = temp;
    }

    return result;
  }

  public static ListNode mergeTwoListsPrac(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    if (l1.val > l2.val) {
      ListNode temp = l1;
      l1 = l2;
      l2 = temp;
    }

    // 2,3,4,5
    // 3,4,5
    ListNode res = l1;
    while (l1 != null && l2 != null) {
      ListNode tmp = null;
      while (l1 != null && l1.val <= l2.val) {
        tmp = l1;
        l1 = l1.next;
      }
      tmp.next = l2;

      ListNode temp = l1;
      l1 = l2;
      l2 = temp;
    }
    return res;
  }


  public static void main(String[] args) {
    // 1 -> 2 -> 3 -> 4 -> null
    // 2 -> 5 -> 8 -> 10 -> null

    // 1 -> 2 -> 2 -> 3 -> 4 -> 5 -> 8 -> 10 -> null
    ListNode merged = mergeTwoListsInPlace(
        new ListNode(2, null),
        new ListNode(1, null));
    while (merged != null) {
      System.out.println(merged.val);
      merged = merged.next;
    }
  }
}

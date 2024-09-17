package com.practice.dsa.linked_list;

public class ReverseLinkedList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
      this.val = val;
    }

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  public static ListNode reverseList(ListNode head) {
    //             null <- 1 <- 2 -> 3 -> 4 -> 5 -> null
    //                          prev next
    //                              curr

    ListNode prev = null;
    ListNode next = null;
    ListNode current = head;
    while (current != null) {
      next = current.next;
      current.next = prev;
      prev = current;
      current = next;
    }
    head = prev;
    return head;
  }

  public static void main(String[] args) {
    ListNode reversed =
        reverseList(
            new ListNode(
                1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null))))));

    while (reversed != null) {
      System.out.println(reversed.val);
      reversed = reversed.next;
    }
  }
}

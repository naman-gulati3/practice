package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;

public class PalindromeLinkedList {

  public static void main(String[] args) {
    // 1 -> 2 -> 2 -> 1 -> null

    ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1, null))));
    System.out.println(isPalindrome(head));
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }

  public static boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    //    ListNode slowCopy = slow;
    slow.next = reverseNode(slow.next);
    slow = slow.next;
    while (slow != null) {
      if (head.val != slow.val) {
        // reverse back to original List
        //        slowCopy.next = reverseNode(slowCopy.next);
        return false;
      }
      slow = slow.next;
      head = head.next;
    }

    // reverse back to original List
    //    slowCopy.next = reverseNode(slowCopy.next);
    return true;
  }

  private static ListNode reverseNode(ListNode node) {
    ListNode prev = null;
    ListNode next = null;
    while (node != null) {
      next = node.next;
      node.next = prev;
      prev = node;
      node = next;
    }
    return prev;
  }
}

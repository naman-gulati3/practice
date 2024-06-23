package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;

public class PalindromeLinkedList {

  public static void main(String[] args) {
    System.out.println(
        isPalindrome(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(1, null))))));
  }

  public static boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    slow.next = reverseNode(slow.next);
    slow = slow.next;
    while (slow != null) {
      if (head.val != slow.val) {
        return false;
      }
      slow = slow.next;
      head = head.next;
    }

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

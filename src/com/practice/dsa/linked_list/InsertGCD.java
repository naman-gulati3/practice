package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;

public class InsertGCD {

  public static ListNode insertGreatestCommonDivisors(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode node = head;
    ListNode next = null;
    while (node.next != null) {
      next = node.next;
      ListNode gcd = new ListNode(calculateGCD(node.val, node.next.val));
      node.next = gcd;
      gcd.next = next;
      node = next;
    }

    return head;
  }

  private static int calculateGCD(int num1, int num2) {
    int max = Math.max(num2, num1);
    int gcd = 1;

    for (int i = 1; i <= max; i++) {
      if (num1 % i == 0 && num2 % i == 0) {
        gcd = i;
      }
    }

    return gcd;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(18);
    head.next = new ListNode(6);

    head.next.next = new ListNode(10);
    head.next.next.next = new ListNode(3);

    head = insertGreatestCommonDivisors(head);

    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }
  }
}

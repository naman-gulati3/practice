package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;

public class AddTwoNumbers {

  public static void main(String[] args) {
    ListNode result = addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3, null))),
        new ListNode(5, new ListNode(6, new ListNode(4, null))));
    ListNode curr = result;
    while (curr != null) {
      System.out.println(curr.val);
      curr = curr.next;
    }
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode();
    ListNode temp = dummy;

    int carry = 0;

    while (l1 != null || l2 != null || carry == 1) {
      int sum = 0;

      if (l1 != null) {
        sum += l1.val;
        l1 = l1.next;
      }

      if (l2 != null) {
        sum += l2.val;
        l2 = l2.next;
      }

      sum += carry;
      carry = sum / 10;

      ListNode node = new ListNode(sum % 10);
      temp.next = node;
      temp = temp.next;
    }
    return dummy.next;
  }
}

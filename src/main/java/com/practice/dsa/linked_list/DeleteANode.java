package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;

public class DeleteANode {

  public static void main(String[] args) {
    ListNode node = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9, null))));
    deleteNode(node.next.next);
    while (node != null) {
      System.out.println(node.val);
      node = node.next;
    }
  }

  public static void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
  }
}

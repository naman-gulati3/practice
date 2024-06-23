package com.practice.dsa.linked_list;

import com.practice.dsa.linked_list.MergeSortedLinkedList.ListNode;
import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

  public static void main(String[] args) {
    ListNode l1 = new ListNode(3);
    ListNode l2 = new ListNode(2);
    ListNode l3 = new ListNode(0);
    ListNode l4 = new ListNode(-4);

    l1.next = l2;
    l2.next = l3;
    l3.next = l4;
    l4.next = null;

    System.out.println(hasCycle(l1));
  }

  public static boolean hasCycle(ListNode head) {
    Set<ListNode> visited = new HashSet<>();
    while (head != null) {
      if (visited.contains(head)) {
        return true;
      }
      visited.add(head);
      head = head.next;
    }
    return false;
  }
}

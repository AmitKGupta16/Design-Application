package com.develop.dsa.solution.linked.list.util;

import com.develop.dsa.solution.linked.list.ListNode;

public class NodeUtility {
    public static ListNode createNodeList(int[] array) {
       ListNode head = new ListNode(array[0]);
       ListNode temp = head;
       for (int i = 1; i < array.length; i++) {
           temp.next = new ListNode(array[i]);
           temp = temp.next;
       }
       return head;

    }
}

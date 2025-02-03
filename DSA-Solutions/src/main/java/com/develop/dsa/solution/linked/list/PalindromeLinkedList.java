package com.develop.dsa.solution.linked.list;

import java.util.HashSet;
import java.util.Set;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        Set<ListNode> set = new HashSet<>();
        ListNode node = head;
        int size = 0;
        while (node != null) {
            set.add(node);
            node = node.next;
            size++;
        }
        if (set.size() == size / 2 || set.size() == (size / 2 + 1)) return true;

        return false;
    }
}

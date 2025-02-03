package com.develop.dsa.solution.linked.list;

import lombok.Data;

@Data
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

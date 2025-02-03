package com.develop.dsa.solution.linked.list;

public class IntersectionOfTwoLinkedList {
    public static void main(String[] args) {

    }

    public static ListNode intersection(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        if(headA == headB) return headA;
        ListNode ptr1 = headA, ptr2 = headB;
        while(ptr1 != ptr2 ) {
            ptr1 = ptr1 == null ? headB : ptr1.next;
            ptr2 = ptr2 == null ? headA :ptr2.next;
        }

        return ptr1;
    }
}

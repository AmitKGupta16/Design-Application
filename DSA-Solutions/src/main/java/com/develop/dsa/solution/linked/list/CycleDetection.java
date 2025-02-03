package com.develop.dsa.solution.linked.list;

public class CycleDetection {
    public static void main(String[] args) {
        //Node head = NodeUtility.createNodeList(new int[] {1,2,3,4,2,5,6});
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(detectCycle(node1).val);
    }
    public static ListNode detectCycle(ListNode head) {
        if( head == null || head.next == null ) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow.val == fast.val) {
                return slow;
//                Node pointer = head;
//                while(pointer != slow) {
//                    pointer = pointer.next;
//                    slow = slow.next;
//                }
//                return pointer;
            }
        }
        return null;
    }

}

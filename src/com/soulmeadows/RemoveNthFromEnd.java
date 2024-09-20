package com.soulmeadows;

import com.soulmeadows.ListNode;

public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n == 1){
            return head.next;
        }
        var dummy = new ListNode();
        dummy.next = head;
        ListNode first = head;
        ListNode second = dummy;
        for(int i = 1; i <=n; ++i){
            first = first.next;
        }
        while(first != null){
            second = second.next;
            first = first.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void  main(String[] args){


        ListNode dummy =  new ListNode() ;
        ListNode node = dummy;
        int count = 1;
        while(node != null && count <= 5){
            node.next = new ListNode(count++);
            node = node.next;
        }
        var head = dummy.next;

        new RemoveNthFromEnd().removeNthFromEnd(head, 2);
    }
}

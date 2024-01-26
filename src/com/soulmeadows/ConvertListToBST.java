package com.soulmeadows;

//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/

 public class ConvertListToBST {
     //Definition for a binary tree node.
     class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
     //  Definition for singly-linked list.
     class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    private ListNode head;
    public int findSize(ListNode head){
        int size = 0;
        ListNode ptr = head;
        while(ptr != null) {
            ++size;
            ptr = ptr.next;
        }
        return size;
    }
    public TreeNode convertListToBST( int l, int r) {
        if(l > r){
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = convertListToBST(l, mid - 1);
        TreeNode node = new TreeNode(head.val);

        this.head = head.next;
        node.left = left;

        node.right = convertListToBST(mid + 1, r);
        return node;
    }
    public TreeNode sortedListToBST(ListNode head) {
        int size = this.findSize(head);
        this.head = head;
        return convertListToBST(0, size - 1);
    }
}
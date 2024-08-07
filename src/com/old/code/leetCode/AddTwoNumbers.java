package com.old.code.leetCode;

/**
 * Created by Shikhar on 14-03-2019.
 */
public class AddTwoNumbers {


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, currNode = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x+y+carry;
            carry = sum/10;
            currNode.next = new ListNode(sum%10);
            currNode = currNode.next;
            if(p!=null) p = p.next;
            if(q!=null) q = q.next;
        }
        if(carry > 0){
            currNode.next = new ListNode(carry);
        }
        return currNode;
    }


}

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        ListNode curr=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null)
        {
            curr=curr.next;
            fast=fast.next.next;
            if(curr==fast)
                return true;
        }
        return false;
    }
}
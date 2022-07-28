/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)
            return head;
        ListNode curr=head;
        ListNode prev=null;
        ListNode future=head.next;
        while(future!=null)
        {
            prev = curr;
            curr = future;
            future=future.next;
            curr.next = prev;
        }
        head.next=null;
        return curr;
    }
}
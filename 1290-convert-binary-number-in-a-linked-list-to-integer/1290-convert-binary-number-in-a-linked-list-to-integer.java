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
    public int getDecimalValue(ListNode head) {
        ListNode temp=head.next;
        int c=1,sum=0;
        while(temp!=null)
        {
            c*=2;
            temp=temp.next;
        }
        temp=head;
        while(c>0)
        {
            sum+=temp.val*c;
            c=c/2;
            temp=temp.next;
        }
        return sum;
    }
}
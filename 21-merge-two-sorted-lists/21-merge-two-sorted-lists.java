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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode t1=list1;
        ListNode t2=list2;
        ListNode head1=null;
        ListNode prev=null;
        while(t1!=null && t2!=null)
        {
            if(t1.val<t2.val)
            {
                ListNode temp=new ListNode(t1.val);
                if(head1==null)
                {
                    head1=temp; 
                    prev=head1;
                }
                else
                {
                    prev.next=temp;
                    prev=prev.next;
                }
                t1=t1.next;
            }
            else if(t2.val<t1.val)
            {
                ListNode temp=new ListNode(t2.val);
                if(head1==null)
                {
                    head1=temp; 
                    prev=head1;
                }
                else
                {
                    prev.next=temp;
                    prev=prev.next;
                }
                t2=t2.next;
            }
            else if(t2.val==t1.val)
            {
                ListNode temp=new ListNode(t2.val);
                ListNode temp2=new ListNode(t2.val);
                if(head1==null)
                {
                    head1=temp; 
                    prev=head1;
                    prev.next=temp2;
                    prev=prev.next;
                }
                else
                {
                    prev.next=temp;
                    prev=prev.next;
                    prev.next=temp2;
                    prev=prev.next;
                }
                t2=t2.next;
                t1=t1.next;
            }
        }
        if(t1!=null)
        {
            while(t1!=null)
            {
                ListNode temp=new ListNode(t1.val);
                if(head1==null)
                {
                    head1=temp; 
                    prev=head1;
                }
                else
                {
                    prev.next=temp;
                    prev=prev.next;
                }
                t1=t1.next;
            }
        }
        else if(t2!=null)
        {
            while(t2!=null)
            {
                ListNode temp=new ListNode(t2.val);
                if(head1==null)
                {
                    head1=temp; 
                    prev=head1;
                }
                else
                {
                    prev.next=temp;
                    prev=prev.next;
                }
                t2=t2.next;
            }
        }
        return head1;
    }
}
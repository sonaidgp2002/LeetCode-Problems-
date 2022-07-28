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
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stk=new Stack<>();
        ListNode t=head;
        while(t!=null)
        {
            stk.push(t.val);
            t=t.next;
        }
        t=head;
        while(t!=null)
        {
            if(t.val!=stk.pop())
                return false;
            t=t.next;
        }
        
        return true;
        /*
        ListNode f=head;
        ListNode s=head;
        ListNode prev=null;
        int c=0;
        while(s!=null)
        {
            c++;
            s=s.next;
        }
        if(c==1)
            return true;
        if(c==2 && head.val!=head.next.val)
            return false;
        s=head;
        while(f!=null && f.next!=null)
        {
            prev=s;
            s=s.next;
            f=f.next.next;
        }
        ListNode temp=s;
        if(c%2==0)
        {
            f=prev;
            while(s!=null)
            {
                if(f==temp)
                    f=head;
                if(f.val!=s.val)
                    return false;
                f=f.next;
                s=s.next;
            }
        }
        else
        {
             f=prev;
                s=s.next;
            while(s!=null)
            {
                if(f==temp)
                    f=head;
                if(f.val!=s.val)
                    return false;
                f=f.next;
                s=s.next;
            }
        }
        return true;*/
    }
}
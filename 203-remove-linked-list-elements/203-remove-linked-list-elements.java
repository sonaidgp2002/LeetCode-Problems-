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
    public ListNode removeElements(ListNode head, int val) {
        ListNode t=head;
        ListNode prev=null;
        ListNode head1=null;
        int c=0;
        while(t!=null)
        {
            if(t.val!=val)
            {
                c++;
                ListNode t1=new ListNode(t.val);
                if(c==1)
                {
                    head1=t1;
                    prev=t1;
                }
                else
                {
                    prev.next=t1;
                    prev=t1;
                }
            }
            t=t.next;
        }
        return head1;
        //Stack<Integer> stk=new Stack<>();
        //ArrayList<Integer> arr=new ArrayList<>();
        //Queue<Integer> stk=new PriorityQueue<>();
        /*while(t!=null)
        {
            if(t.val!=val)
            {
                i++;
                arr.add(t.val);
            }
            t=t.next;
        }
        t=head;
        for(int j=0;j<i;j++)
        {
            t.val=arr.get(j);
            if(t.next.next.next==null)
            {
                break;
            }
            t=t.next;
        }
        if(i==0)
            head=null;
        if(t!=null)
        t.next=null;
        /*
        while(t!=null)
        {
            if(t.val==val)
                continue;
            else
            {
                ListNode t2= new ListNode(t.val);
                head1=t2;
            }
            t=t.next;
        }*/
    }
}
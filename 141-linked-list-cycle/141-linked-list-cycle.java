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
        /*
        ListNode tail=head;
        while(tail.next!=null)
        {
            
            if()
            tail=tail.next;
        }*/
        
        ListNode temp=head;
        ArrayList<ListNode> arr=new ArrayList<>();
        ArrayList<Integer> arr1=new ArrayList<>();
        while(temp!=null)
        {
            if(arr.contains(temp))
                return true;
            else
                arr.add(temp);
            temp=temp.next;
        }
        return false;
        /*
        while(temp!=null)
        {
            if(arr1.contains(temp.val))
                return true;
            else
                arr1.add(temp.val);
            temp=temp.next;
        }
        return false;*/
    }
}
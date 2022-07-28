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
        ListNode temp=head;
        ArrayList<ListNode> arr=new ArrayList<>();
        while(temp!=null)
        {
            if(arr.contains(temp))
                return true;
            else
                arr.add(temp);
            temp=temp.next;
        }
        return false;
    }
}
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
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode i=head;
        ListNode j=head;
        while(j!=null && j.next!=null){
            i=i.next;
            j=j.next.next;
            if(i==j){
                break;
            }
        }
        if(i==j){
            ListNode left=head;
            ListNode right=i;
            while(left!=right){
                left=left.next;
                right=right.next;
            }
        return left;
        }
        else{
            return null;
        }
        
    }
}
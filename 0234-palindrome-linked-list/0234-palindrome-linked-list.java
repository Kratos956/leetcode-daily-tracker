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
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
       
       ListNode newnode=reverse(slow.next);
        ListNode one =head;
        ListNode second=newnode;
        while (second!=null) {
            if (one.val!=second.val) {
                // reverse(newnode);
                return false;
            }
            one=one.next;
            second=second.next;
        }
        return true;
       

    }
    public ListNode reverse(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr=head;
        ListNode prev=null;
        while(head!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stk=new Stack<>();
        ListNode temp=head;
        while(temp!=null){
            while(!stk.isEmpty() && temp.val>stk.peek().val){
                stk.pop();
            }
            stk.add(temp);
            temp=temp.next;
        }
        ListNode res=new ListNode();
        res.next=stk.pop();
        while(!stk.isEmpty()){
            ListNode x=stk.peek();
            x.next=res.next;
            res.next=x;
            stk.pop();
        }
        return res.next;
    }
}
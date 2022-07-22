/**
* Definition for singly-linked list.
* public class ListNode {
* int val;
* ListNode next;
* ListNode(int x) { val = x; }
* }
*/
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(-1);
        ListNode moreHead = new ListNode(-1);
        ListNode less = lessHead;
        ListNode more = moreHead;
        ListNode node = head;
        while (node !=null ){
            if (node.val < x){
                less.next = node;
                less = less.next;
            }
            else{
                more.next = node;
                more = more.next;
            }
            node = node.next;
        }//while node
        more.next = null;
        less.next = moreHead.next;
        return lessHead.next;
    }//partition
}
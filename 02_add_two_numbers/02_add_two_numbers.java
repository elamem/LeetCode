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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        
        ListNode temp = result;
        int reminder = 0;
        while(l1 != null || l2 != null) {
            int total = 0;
            if(l1 != null && l2 != null)
                total = l1.val + l2.val;
            else if(l1 != null)
                total = l1.val;
            else 
                total = l2.val;
            
            total += reminder;
            reminder = total / 10;
            total %= 10;
            
            temp.val += total;
             
            if((l1 != null && l1.next != null) || (l2 != null && l2.next != null))
                temp.next = new ListNode();
            else if(reminder != 0) 
                temp.next = new ListNode(reminder);
                
             if(l1 != null)
                l1 = l1.next;
             if(l2 != null)
                l2 = l2.next;
            temp = temp.next;
        }
        
        return result;
    }
}
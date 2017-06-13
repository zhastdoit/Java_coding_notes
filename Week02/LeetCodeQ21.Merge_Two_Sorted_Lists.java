/*
21. Merge Two Sorted Lists 
Difficulty: Easy
Contributor: LeetCode
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
Solution 1: Non-recursive solution
*/

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode result = ans;
        while(l1!=null||l2!=null){
            if(l1!=null&&l2!=null){
                if(l1.val<=l2.val){
                    ans.next = l1; //Prev Wrong idea: ans.val = l1.val;
                    ans=ans.next;
                    l1=l1.next;
                }
                else if(l1.val>l2.val) {
                    ans.next = l2;
                    ans=ans.next;
                    l2=l2.next;
                }
            } else if (l1 == null) {
                ans.next = l2;
                ans=ans.next;
                l2=l2.next;
            } else if (l2 == null) {
                ans.next = l1;
                ans=ans.next;
                l1=l1.next;
            }
        }
        return result.next;
    }
}

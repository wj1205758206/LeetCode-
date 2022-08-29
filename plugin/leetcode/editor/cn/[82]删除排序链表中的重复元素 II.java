
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur!=null && cur.next!=null){
            if(cur.val == cur.next.val){
                ListNode temp = cur.next;
                while(temp != null && temp.val == cur.val) temp = temp.next;
                pre.next = temp;
                cur = temp;
            }else{
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

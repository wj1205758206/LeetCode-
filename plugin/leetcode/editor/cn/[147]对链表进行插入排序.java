
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode cur, lastSorted;
        dummy.next = head;
        cur = head.next;
        lastSorted = head;
        while (cur != null){
            if (lastSorted.val <= cur.val){
                lastSorted = lastSorted.next;
            }else {
                ListNode pre = dummy;
                while (pre.next.val <= cur.val){
                    pre = pre.next;
                }
                lastSorted.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = lastSorted.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

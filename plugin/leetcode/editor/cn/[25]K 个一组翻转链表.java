
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
    public ListNode reverseKGroup(ListNode hea  d, int k) {
        if (head == null) return null;
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {

            if (b == null) {
                return head;
            }
            b = b.next;
        }

        ListNode newHead = reverseBetween(a, b);
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    public ListNode reverseBetween(ListNode a, ListNode b) {
        ListNode pre, cur, post;
        pre = null;
        cur = post = a;
        while (cur != b) {
            post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

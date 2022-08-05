
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverseN(head, right);
        } else {
            head.next = reverseBetween(head.next, left - 1, right - 1);
            return head;
        }
    }

    ListNode postNode = null;

    public ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            postNode = head.next;
            return head;
        }
        ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = postNode;
        return last;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

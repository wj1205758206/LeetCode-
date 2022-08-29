
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
class Solution {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int ALen = getLen(headA);
        int BLen = getLen(headB);
        ListNode shorter = headB;
        ListNode longer = headA;
        int count = ALen - BLen;
        if (count < 0) {
            shorter = headA;
            longer = headB;
            count = -count;
        }
        while (count > 0) {
            count--;
            longer = longer.next;
        }
        while (longer != null && shorter != null && longer != shorter) {
            shorter = shorter.next;
            longer = longer.next;
        }
        return longer;
    }

    public int getLen(ListNode head) {
        if (head == null) return 0;
        return 1 + getLen(head.next);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

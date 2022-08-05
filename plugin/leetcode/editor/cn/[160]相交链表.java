
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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        int ALen = getLen(headA);
        int BLen = getLen(headB);
        ListNode shorter = headA;
        ListNode longer = headB;
        int count = BLen - ALen;
        if (count < 0) {
            longer = headA;
            shorter = headB;
            count = -count;
        }
        while (count > 0) {
            longer = longer.next;
            count--;
        }
        while (shorter != null && longer != null && shorter != longer) {
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

package codingoffer;

/**
 * 链表中倒数第 K 个节点
 */
public class KthNodeFromEnd_22 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * 快慢指针
         *
         * @param head
         * @param k
         * @return
         */
        public ListNode getKthFromEnd(ListNode head, int k) {
            ListNode slow, fast;
            slow = fast = head;

            while (k != 0) {
                fast = fast.next;
                k--;
            }

            while (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

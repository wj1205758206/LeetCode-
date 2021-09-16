package codingoffer;

/**
 * 翻转链表
 */
public class ReverseLinkedList_24 {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null)
                return null;

            if (head.next == null)
                return head;

            ListNode newHead = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newHead;
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

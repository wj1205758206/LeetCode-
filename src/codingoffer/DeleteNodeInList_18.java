package codingoffer;

/**
 * 删除链表中的节点
 */
public class DeleteNodeInList_18 {
    public static void main(String[] args) {

    }

    class Solution {
        public ListNode deleteNode(ListNode head, int val) {
            ListNode pre, cur;
            pre = null;
            cur = head;

            if (head.val == val)
                return head.next;

            while (cur != null) {
                if (cur.val == val) {
                    pre.next = cur.next;
                    break;
                }
                pre = cur;
                cur = cur.next;
            }
            return head;
        }

        public ListNode deleteNode2(ListNode head, int val) {
            ListNode cur = head;
            boolean flag = false;
            if (head.val == val)
                return head.next;

            while (cur.next != null) {
                if (cur.val == val) {
                    cur.val = cur.next.val;
                    cur.next = cur.next.next;
                    flag = true;
                    break;
                }
                cur = cur.next;
            }
            if (cur.next == null && !flag) {
                cur = head;
                while (cur.next.next != null)
                    cur = cur.next;
                cur.next = null;
            }
            return head;
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

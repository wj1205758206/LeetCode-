package codingoffer;

import java.util.*;

/**
 * 从尾到头打印链表
 */
public class PrintListInReversedOrder_06 {
    public static void main(String[] args) {
        Solution solution = new PrintListInReversedOrder_06().new Solution();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(2);

        ListNode listNode = solution.reverseIteration(l1);
        System.out.println(listNode.next.val);

    }

    class Solution {
        /**
         * 正向遍历链表，结果集翻转
         *
         * @param head
         * @return
         */
        public int[] reversePrint(ListNode head) {
            Deque<Integer> list = new ArrayDeque<>();
            ListNode t = head;
            while (t != null) {
                list.addFirst(t.val);
                t = t.next;
            }


            int[] res = new int[list.size()];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                res[i] = list.pollFirst();
            }

            return res;
        }

        /**
         * 递归反转链表
         *
         * @param head
         * @return
         */
        public int[] reversePrint2(ListNode head) {
            if (head == null)
                return new int[]{};
            ListNode newHead = reverseAll(head);
            List<Integer> list = new ArrayList<>();
            ListNode t = newHead;
            while (t != null) {
                System.out.println(t.val);

                t = t.next;
            }
            int[] res = new int[list.size()];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                res[i] = list.get(i);
            }

            return res;
        }

        private ListNode reverseAll(ListNode head) {
            if (head.next == null)
                return head;

            ListNode last = reverseAll(head.next);

            head.next.next = head;
            head.next = null;

            return last;
        }

        /**
         * 迭代反转链表
         *
         * @param head
         * @return
         */
        public int[] reversePrint3(ListNode head) {

            if (head == null)
                return new int[]{};
            ListNode newHead = reverseIteration(head);
            List<Integer> list = new ArrayList<>();
            ListNode t = newHead;
            while (t != null) {
                list.add(t.val);
                t = t.next;
            }
            int[] res = new int[list.size()];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                res[i] = list.get(i);
            }

            return res;
        }

        private ListNode reverseIteration(ListNode head) {
            ListNode pre, cur, post;
            pre = null;
            cur = post = head;
            while (cur != null) {
                post = cur.next;
                cur.next = pre;
                pre = cur;
                cur = post;
            }
            return pre;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

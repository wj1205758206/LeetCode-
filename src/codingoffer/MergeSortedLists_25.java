package codingoffer;

/**
 * 合并两个排序的链表
 */
public class MergeSortedLists_25 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * 开辟一条新链表，需要辅助空间
         *
         * @param l1
         * @param l2
         * @return
         */
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode mergeHead = new ListNode(0);
            ListNode cur = mergeHead;
            ListNode p1 = l1;
            ListNode p2 = l2;

            while (p1 != null && p2 != null) {
                if (p2.val > p1.val) {
                    cur.next = new ListNode(p1.val);
                    cur = cur.next;
                    p1 = p1.next;
                } else {
                    cur.next = new ListNode(p2.val);
                    cur = cur.next;
                    p2 = p2.next;
                }
            }

            while (p1 != null) {
                cur.next = new ListNode(p1.val);
                cur = cur.next;
                p1 = p1.next;
            }

            while (p2 != null) {
                cur.next = new ListNode(p2.val);
                cur = cur.next;
                p2 = p2.next;
            }

            return mergeHead.next;
        }
    }

    /**
     * 递归
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode pMergeHead = null;
        if (l1.val < l2.val) {
            pMergeHead = l1;
            pMergeHead.next = mergeTwoLists2(l1.next, l2);
        } else {
            pMergeHead = l2;
            pMergeHead.next = mergeTwoLists2(l1, l2.next);
        }
        return pMergeHead;
    }

    /**
     * 创建一个头节点，迭代穿针引线
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode pHead = new ListNode(-1);
        ListNode pre = pHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        pre.next = l1 == null ? l2 : l1;

        return pHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

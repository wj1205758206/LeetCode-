package linkedList.easy;

/**
 * 判断回文链表
 */
public class PalindromeLinkedList_234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);


        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(head));
    }
    static class Solution {

        /**
         * 判断传入的链表是否是回文链表
         * 使用快慢双指针的方式，找到链表中点，翻转右部分链表，并与左部分链表一一比较
         * @param head  链表头节点
         * @return      返回是否是回文链表
         */
        public boolean isPalindrome(ListNode head) {
            ListNode slow, fast;
            slow = fast = head;
            /*慢指针步长为1，快指针步长为2
             * while循环结束，
             * 如果链表节点为奇数，slow会指向中点，fast指向尾节点
             * 如果链表节点为偶数，slow会指向中点偏右的节点，fast则指向尾节点的下一个，即null*/
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            /*如果fast不为null，也就是链表的节点个数为奇数，则slow再向前走一步
             * 这样链表尾中点为分割点，分成两部分，head指向了左部分链表的头节点，slow指向了右部分链表的头节点*/
            if (fast != null) {
                slow = slow.next;
            }

            /*左指针指向head，即左部分链表的头节点
             * 右指针指向右部分翻转后的头节点
             * 如果是回文链表，那么除去中点以外，左部分链表和右部分翻转后的链表应该完全相同*/
            ListNode left = head;
            ListNode right = reverse(slow);

            /*把左部分链表与右部分翻转后的链表进行一一比较*/
            while (right != null) {
                if (left.val != right.val) {
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
        }

        /**
         * 翻转传入的整个链表
         * @param head  传入链表的头节点
         * @return      返回翻转后的头节点
         */
        private ListNode reverse(ListNode head) {
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
}


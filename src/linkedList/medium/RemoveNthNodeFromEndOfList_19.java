package linkedList.medium;

/**
 * 删除倒数第n个节点
 */
public class RemoveNthNodeFromEndOfList_19 {
    public static void main(String[] args) {
        ListNode head = Utils.createLinkedList(5);
        Utils.print(head);
        Solution solution = new Solution();
        ListNode newHead = solution.removeNthFromEnd(head, 2);
        Utils.print(newHead);

    }

    static class Solution {
        /**
         * 使用快慢双指针
         * @param head
         * @param n
         * @return
         */
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode slow, fast;
            slow = fast = head;
            /*先让快指针前进n步，慢指针保持不动*/
            while (fast != null && n > 0) {
                fast = fast.next;
                n--;
            }

            /*如果快指针指向了null，说明删除的就是第一个节点，直接返回head的下一个节点即可*/
            if (fast == null)
                return head.next;

            /*快指针先前进n步以后，让快慢指针以相同的速度前进，快指针始终领先慢指针n步
            * 循环结束时，快指针指向了尾节点，而慢指针指向尾节点的前n个，那么slow.next就是要删除的节点*/
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            /*让slow.next指向下下个节点，跳过要删除的节点*/
            slow.next = slow.next.next;

            return head;
        }
    }
}

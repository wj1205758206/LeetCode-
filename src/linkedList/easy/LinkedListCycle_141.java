package linkedList.easy;

/**
 * 判断链表是否存在环
 */
public class LinkedListCycle_141 {
    public static void main(String[] args) {
        ListNode head = Utils.createLinkedList(6);
        ListNode lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = head.next.next;

        Solution solution = new Solution();
        System.out.println(solution.hasCycle(head));
    }

    static class Solution {
        /**
         * 使用快慢双指针，
         * 如果快指针最终指向null，说明链表不存在环
         * 如果快慢指针最终相遇，说明链表中存在环
         * @param head  链表头节点
         * @return  返回是否存在环
         */
        public boolean hasCycle(ListNode head) {

            ListNode slow, fast;
            slow = fast = head;

            /*慢指针步长为1，快指针步长为2*/
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                /*如果相遇，则存在环*/
                if (slow == fast)
                    return true;
            }
            return false;
        }
    }
}


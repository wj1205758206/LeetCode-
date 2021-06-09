package linkedList.easy;

/**
 * 删除排序链表中的重复元素
 */
public class RemoveDuplicatesFromSortedList_83 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        Utils.addTail(head,1);
        Utils.addTail(head,2);
        Utils.addTail(head,2);
        Utils.addTail(head,3);
        Utils.addTail(head,4);
        Utils.print(head);

        Solution solution = new Solution();
        ListNode newHead = solution.deleteDuplicates(head);
        Utils.print(newHead);

    }
    static class Solution {
        /**
         * 使用双指针方法，挨个遍历比较
         * @param head
         * @return
         */
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null)
                return null;
            ListNode left, right;
            left = right = head;
            /*right指针指向与left指向的节点不相同的第一个节点
            * left.next指向第一个不相同的节点，然后left=right，继续向后找*/
            while (right != null) {
                if (left.val == right.val) {
                    right = right.next;
                }else {
                    left.next = right;
                    left = right;
                }
            }
            /*断开后面重复的链表*/
            left.next = null;

            return head;
        }
    }
}

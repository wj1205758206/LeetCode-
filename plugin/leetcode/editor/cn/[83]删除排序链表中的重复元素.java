
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode left, right;
        left = right = head;
        //左右双指针遍历
        while (right != null) {
            //遇到重复的，right后移
            if (left.val == right.val) {
                right = right.next;
            } else {
                //找到了第一个不重复的节点，相当于right跳过了重复的节点
                //将left跳过重复节点，next指向right，同时left直接跳过来到right
                left.next = right;
                left = right;
            }
        }
        //有可能末尾几个都是重复的，断开后面重复的链表
        left.next = null;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        int n = 0;
        ListNode tail = null;
        //统计链表长度，并找到tail节点
        for (ListNode p = head; p != null; p = p.next) {
            n++;
            tail = p;
        }
        k %= n;
        ListNode p = head;
        //找到第n-k个节点
        for (int i = 0; i < n - k - 1; i++) {
            p = p.next;
        }
        tail.next = head; //后面的节点移动到前面
        head = p.next; //找到新的头节点，第n-k+1
        p.next = null; //将第n-k个节点变为tail节点，断开后面的
        return head; //返回新头节点
    }
}
//leetcode submit region end(Prohibit modification and deletion)

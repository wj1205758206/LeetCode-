
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2; // p1,p2两个扫描节点
        ListNode dummy = new ListNode(-1); // 伪节点
        ListNode p = dummy; //新链表的扫描节点，用来构造新链表

        int carry = 0;
        while (p1 != null || p2 != null || carry > 0) {
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }
            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }
            carry = val / 10; //进位
            val = val % 10; //相加取余
            p.next = new ListNode(val); //创建新链表的节点
            p = p.next; //后移
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

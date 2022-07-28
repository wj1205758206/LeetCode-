
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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        //定义奇偶指针
        ListNode odd = head, even = head.next;
        //定义偶数头节点，
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = even.next;
            even.next = odd.next;
            even = odd.next;
        }
        //需要将奇数尾节点连接上偶数头节点
        odd.next = evenHead;
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

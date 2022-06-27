
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        //找到链表的中点，划分成两部分
        ListNode middleNode = findMiddleNode(head);
        //右半部分的头结点
        ListNode rightHead = middleNode.next;
        //从中点断开，划分成左右两部分
        middleNode.next = null;

        //递归的不断划分左右两部分，直到划分成单独一个的node
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        //从底层单个node的两个链表开始合并，自底向上合并
        return mergrSortedList(left, right);
    }

    public ListNode findMiddleNode(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode slow, fast;
        slow = head;
        fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public ListNode mergrSortedList(ListNode l1, ListNode l2){
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode mergeHead = null;
        if (l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergrSortedList(l1.next, l2);
        }else {
            mergeHead = l2;
            mergeHead.next = mergrSortedList(l1, l2.next);
        }
        return mergeHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

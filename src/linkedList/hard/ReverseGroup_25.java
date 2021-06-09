package linkedList.hard;

public class ReverseGroup_25 {
    public static void main(String[] args) {
        ListNode head = Utils.createLinkedList(10);
        Utils.print(head);
        Solution solution = new Solution();
        ListNode newHead = solution.reverseKGroup(head, 2);
        Utils.print(newHead);

    }
    static class Solution {
        ListNode reverseKGroup(ListNode head, int k){
            if (head == null)
                return head;
            /*a，b记录翻转范围*/
            ListNode a,b;
            a = b = head;

            /*a是起始节点，b定位到k个之后的下一个节点，相当于翻转[a,b)区间内的节点，左开右闭*/
            for (int i = 0; i < k; i++){
                /*不足k个，剩余的不翻转，直接返回当前这一组的head节点*/
                if (b == null)
                    return head;
                b = b.next;
            }

            /*翻转[a,b)区间的节点，记录k个一组翻转后的新的头节点*/
            ListNode newHead = reverseBetween(a, b);

            /*原来a为k个一组的头节点，翻转后成为尾节点，所以需要续接上下一组的头节点*/
            a.next = reverseKGroup(b, k);

            /*返回k个一组翻转后的新的头节点*/
            return newHead;
        }
        /*翻转指定的两个节点之间的链表，[a,b)*/
        public static ListNode reverseBetween(ListNode a, ListNode b){
            ListNode pre, cur, post;
            pre = null;
            cur = post = a;
            while (cur != b){
                post = cur.next;
                cur.next = pre;
                pre = cur;
                cur = post;
            }
            return pre;
        }
    }
}

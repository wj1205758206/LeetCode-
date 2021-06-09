package linkedList.easy;

/**
 * 判断链表是否存在环，如果存在则返回环的起点
 */
public class LinkedListCycle_142 {
    public static void main(String[] args) {
        ListNode head = Utils.createLinkedList(6);
        ListNode lastNode = head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = head.next.next;

        Solution solution = new Solution();
        System.out.println(solution.detectCycle(head).val);

    }

    static class Solution {
        /*使用快慢双指针*/
        public ListNode detectCycle(ListNode head) {

            ListNode slow, fast;
            slow = fast = head;

            /*慢指针步长为1，快指针步长为2
            * 退出while循环有两种情况
            * 一种情况是存在环，快慢指针相遇
            * 一种情况是不存在环，快指针到达链表尾节点，或者null*/
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast)
                    break;
            }

            /*需要判断是哪一种情况退出的while循环，即判断是否存在环
            * 如果不存在环，则直接返回null*/
            if (fast == null || fast.next == null) {
                return null;
            }

            /*当快慢指针相遇时，让其中任一个指针指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置
            * 第一次相遇时，假设慢指针 slow 走了 k 步，那么快指针 fast 一定走了 2k 步
            * fast 一定比 slow 多走了 k 步，这多走的 k 步其实就是 fast 指针在环里转圈圈，所以 k 的值就是环长度的「整数倍」。
            * 设相遇点距环的起点的距离为 m，那么环的起点距头结点 head 的距离为 k - m，也就是说如果从 head 前进 k - m 步就能到达环起点
            * 如果从相遇点继续前进 k - m 步，也恰好到达环起点。不管fast在环里到底转了几圈，走 k 步可以到相遇点，那走 k - m 步一定就是走到环起点了
            * 所以，只要我们把快慢指针中的任一个重新指向 head，然后两个指针同速前进，k - m 步后就会相遇，相遇之处就是环的起点了*/
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }
    }
}

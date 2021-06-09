package linkedList.medium;


import java.util.LinkedList;

public class ReverseLinkedList_92 {
    public static void main(String[] args) {

        ListNode head = null;
        for (int i = 1; i <= 10; i++){
            ListNode node = new ListNode(i);
            if (head == null){
                head = node;
            }else {
                ListNode t = head;
                while (t.next != null){
                    t = t.next;
                }
                t.next = node;
            }
        }

        Solution solution = new Solution();

        ListNode reverseBetween = solution.reverseBetween(head, 2, 4);

        while (reverseBetween.next != null) {
            System.out.print(reverseBetween.val + " ");
            reverseBetween = reverseBetween.next;
        }
    }

    static class Solution{

        /*翻转指定范围内的节点*/
        public ListNode reverseBetween(ListNode head, int left, int right) {
        /*基准条件
        这里有点特殊，此处的基准条件又是一个递归，但这个递归也有基准条件，所以不会死循环
        如果从索引1开始翻转，相当于翻转链表的前n个节点，直接调用之前的函数即可
        */
            if (left == 1) {
                return reverseN(head, right);
            } else {
                /*翻转指定范围内节点，可以理解为把开始索引充当头结点，翻转剩下的end-1个节点
                 * head不断的前进到翻转的起点，head往前走一步，起点的索引位置相对于head就会减一
                 * head前进到起点位置时，触发基准条件
                 * */
                head.next = reverseBetween(head.next, left - 1, right - 1);
                return head;
            }

        }

        public ListNode postDriver = null;

        public ListNode reverseN(ListNode head, int n){
            /*基准条件
             * 当递归到只剩一个节点时，返回这个节点，并且还要记录这个节点的下一个节点，充当后驱节点*/
            if (n == 1){
                postDriver = head.next;
                return head;
            }
            /*每次递归翻转以当前节点的下一个节点充当头结点的链表，所以只翻转n-1个*/
            ListNode last = reverseN(head.next, n - 1);
            /*将链表箭头翻转*/
            head.next.next = head;
            /*翻转结束后，将当前节点的next指向后驱节点，相当于续接上剩余没有翻转的节点*/
            head.next = postDriver;
            return last;
        }
    }




}

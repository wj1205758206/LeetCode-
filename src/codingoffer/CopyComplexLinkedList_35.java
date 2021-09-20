package codingoffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 复杂链表的复制（哈希表 / 拼接与拆分）
 */
public class CopyComplexLinkedList_35 {
    public static void main(String[] args) {

    }

    class Solution {
        /**
         * 方法一：哈希表
         *
         * @param head
         * @return
         */
        public Node copyRandomList(Node head) {
            if (head == null)
                return null;
            Node t = head;

            //利用哈希表的查询特点，考虑构建 原链表节点 和 新链表对应节点 的键值对映射关系，
            Map<Node, Node> map = new HashMap<>();
            while (t != null) {
                map.put(t, new Node(t.val));
                t = t.next;
            }

            t = head;

            //再遍历构建新链表各节点的 next 和 random 引用指向。
            while (t != null) {
                map.get(t).next = map.get(t.next);
                map.get(t).random = map.get(t.random);
                t = t.next;
            }

            return map.get(head);
        }

        /**
         * 方法二：拼接 + 拆分
         *
         * @param head
         * @return
         */
        public Node copyRandomList2(Node head) {
            if (head == null)
                return null;

            Node t = head;

            //第一步：复制各节点，构建拼接链表:
            while (t != null) {
                Node newNode = new Node(t.val);
                newNode.next = t.next;
                t.next = newNode;
                t = t.next.next;
            }

            t = head;

            //构建新链表各节点的 random 指向
            while (t != null) {
                if (t.random != null) {
                    t.next.random = t.random.next;
                }
                t = t.next.next;
            }

            Node preHead = head;
            Node newHead = head.next;
            t = newHead;

            //拆分原 / 新链表
            while (t.next != null) {
                preHead.next = preHead.next.next;
                t.next = t.next.next;
                preHead = preHead.next;
                t = t.next;
            }

            preHead.next = null;
            return newHead;
        }
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}

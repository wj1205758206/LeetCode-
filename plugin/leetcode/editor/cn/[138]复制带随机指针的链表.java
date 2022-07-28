
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
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
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        //第一次遍历，相当于深拷贝了原来链表每一个节点，key是原链表节点，value是拷贝出来的新链表节点
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        //再来一次遍历
        //map.get(cur) 相当于 拷贝出来的新节点
        //根据原节点的next 和 random 关系，赋值到新节点
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

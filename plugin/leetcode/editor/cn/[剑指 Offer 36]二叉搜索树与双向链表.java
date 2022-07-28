
//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node head, tail;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        dfs(root);

        //首尾互相连
        tail.right = head;
        head.left = tail;

        return head;
    }

    public void dfs(Node cur) {
        if (cur == null) return;

        dfs(cur.left);

        //因为要排序好的双向链表，所以考虑BST的中序遍历
        if (head == null) { //首先让head tail都指向第一个节点
            head = cur;
            tail = head;
        }else {
            //新节点充当tail，tail和新节点之间需要建立双向关系
            tail.right = cur;
            cur.left = tail;
            tail = cur; //新的节点成为tail
        }

        dfs(cur.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

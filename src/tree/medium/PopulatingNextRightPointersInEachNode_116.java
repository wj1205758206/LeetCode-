package tree.medium;

/**
 * 填充二叉树节点的右侧指针
 */
public class PopulatingNextRightPointersInEachNode_116 {
    public static void main(String[] args) {

    }

    static class Solution {
        /*考虑到除了连接同父节点的两个左右孩子节点，还需要考虑不同父节点，即跨父节点在两个相邻节点的连接
        * 所以需要用一个辅助函数来连接任意相邻的两个节点
        * 单纯的二叉树递归遍历无法连接 不同父节点 的两个相邻节点*/
        public Node connect(Node root) {
            if (root == null)
                return null;
            connectTwoNode(root.left, root.right);
            return root;
        }

        /*连接相邻的两个节点，即使两个节点的父节点不同
        * 这是个辅助函数，用这个函数实现递归遍历*/
        public void connectTwoNode(Node node1, Node node2) {
            if (node1 == null || node2 == null)
                return;
            /*连接左右两个节点*/
            node1.next = node2;

            /*递归连接相同父节点的左右孩子*/
            connectTwoNode(node1.left,node1.right);
            connectTwoNode(node2.left,node2.right);

            /*递归连接不同父节点的两个相邻节点*/
            connectTwoNode(node1.right,node2.left);
        }

    }

    /**
     * 定义树的节点，除了有左右孩子指针，还有指向右侧节点的指针next
     */
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}

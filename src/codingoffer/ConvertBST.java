package codingoffer;

/**
 * BST转为双向循环链表
 */
public class ConvertBST {
    public static void main(String[] args) {

    }

    class Solution {
        Node tail, head;

        public Node treeToDoublyList(Node root) {
            if (root == null)
                return null;

            //中序遍历，连接双向指针
            dfs(root);

            tail.right = head;//尾节点指向头节点
            head.left = tail;//头节点指向尾节点

            return head;
        }

        private void dfs(Node cur) {
            if (cur == null) return;

            dfs(cur.left);

            //一开始头尾指针都是指向null的，遇到第一个节点就是头节点，此时头尾指针都指向第一个节点
            if (head == null) {
                head = cur;
                tail = head;
            } else {
                tail.right = cur; //尾节点后继指向下一个节点
                cur.left = tail; //下一个节点的前驱节点指向尾节点
                tail = cur; //更新尾节点
            }

            dfs(cur.right);
        }
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}

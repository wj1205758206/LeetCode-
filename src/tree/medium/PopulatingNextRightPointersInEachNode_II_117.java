package tree.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 填充每个节点的下一个右侧节点指针
 */
public class PopulatingNextRightPointersInEachNode_II_117 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(7);

        Solution solution = new PopulatingNextRightPointersInEachNode_II_117().new Solution();
        Node connect = solution.connect(root);
        System.out.println(connect.left.next.val);
    }

    class Solution {
        /*使用BFS广度优先搜索，遍历每一层的节点，将每一层的每个节点的next连接到右侧节点*/
        public Node connect(Node root) {
            if (root == null)
                return null;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int currentLevelSize = queue.size();

                /*for循环遍历当前层的每一个节点，连接next指针*/
                for (int i = 0; i < currentLevelSize; i++) {
                    Node node = queue.poll();
                    /*判断是否是最后一个节点，最后一个节点的next指向null*/
                    if (i != currentLevelSize - 1) {
                        node.next = queue.peek();
                    } else {
                        node.next = null;
                    }

                    if (node.left != null)
                        queue.offer(node.left);
                    if (node.right != null)
                        queue.offer(node.right);
                }

            }
            return root;
        }
    }

    // Definition for a Node.
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

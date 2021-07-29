package tree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树迭代器
 */
public class BSTIterator_173 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator bstIterator = new BSTIterator_173().new BSTIterator(root);
        System.out.println(bstIterator.hasNext());
        System.out.println(bstIterator.next());

    }

    /**
     * 方法一：递归中序遍历，将中序遍历结果保存到集合中，利用索引获取next值和判断是否下一个值
     */
    class BSTIterator {
        private int index;
        private List<Integer> list;

        public BSTIterator(TreeNode root) {
            index = 0;
            list = new ArrayList<>();
            inOrder(root);
        }

        private void inOrder(TreeNode root) {
            if (root == null)
                return;
            inOrder(root.left);
            list.add(root.val);
            inOrder(root.right);
        }

        public int next() {
            return list.get(index++);
        }

        public boolean hasNext() {
            return index < list.size();
        }
    }

    /**
     * 方法二：使用栈结构进行迭代
     */
    class BSTIterator2 {
        private TreeNode cur;
        private Stack<TreeNode> stack;

        public BSTIterator2(TreeNode root) {
            cur = root;
            stack = new Stack<>();
        }

        /*使用栈进行迭代实现中序遍历*/
        public int next() {
            /*不断的将当前节点的左孩子全部压入栈中*/
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            /*弹出栈顶节点，即最左下角的叶子节点，记录并返回该节点值*/
            cur = stack.pop();
            int val = cur.val;

            /*将当前游标指向当前节点的右孩子，在下一次的next时会先把右孩子为当前节点，先把它的所有左孩子全部压入栈中*/
            cur = cur.right;
            return val;
        }

        public boolean hasNext() {
            /*有可能cur指向叶子节点，但是栈不为空
             * 也有可能初始时，栈为空但是cur不为null
             * 两种情况都表示hasNext为true*/
            return cur != null || !stack.isEmpty();
        }
    }

}

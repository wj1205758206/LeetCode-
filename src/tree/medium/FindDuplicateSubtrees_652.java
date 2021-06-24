package tree.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 查找重复的子树，返回所有重复子树的根节点构成的列表
 */
public class FindDuplicateSubtrees_652 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        Solution solution = new Solution();
        List<TreeNode> duplicateSubtrees = solution.findDuplicateSubtrees(root);
        for (TreeNode treeNode : duplicateSubtrees) {
            System.out.println(treeNode.val + " ");
        }

    }

    /**
     * 要想找出二叉树中重复的子树，首先要确定两件事
     * 第一件：以当前节点为根节点的子树的结构是怎样的
     * 第二件：以其他节点为根节点的子树的结构是怎样的
     * 通过对比当前根节点的子树与其它根节点的子树的树状结构，来判断是否是重复的子树
     */
    static class Solution {
        Map<String, Integer> subTreeCount = new HashMap<>();
        LinkedList<TreeNode> result = new LinkedList<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            traverse(root);
            return result;

        }

        /**
         * 描述一颗二叉树的结构，可以采用将二叉树序列化的方法，即通过遍历(前/中/后皆可)将其转换为字符串的形式
         * 通过比较字符串，如果字符串是一样的，那么可以说这两棵树的结构也是一样的
         * @param root  传入一棵树的根节点，进行序列化，将树状结构转换为字符串的形式
         * @return  返回序列化后的字符串
         */
        public String traverse(TreeNode root) {
            /*基准条件
            * 这棵树已经遍历到底儿了，对于一个空节点，用一个特殊字符代表即可*/
            if (root == null)
                return "#";

            /*前序遍历序列化*/
            //String subTree = root.val + "," + traverse(root.left) + "," + traverse(root.right);

            /*中序遍历序列化*/
            //String left = traverse(root.left);
            //String subTree = left + "," + root.val + "," + traverse(root.right);

            /*后序遍历序列化*/
            String left = traverse(root.left);
            String right = traverse(root.right);
            String subTree = left + "," + right + "," + root.val;

            /*通过序列化解决了树状结构是怎样的问题，接下来还需要解决如何得知其它子树的树状结构是怎样的
            * 可以通过Map集合数据结构，将subTree序列化后的字符串作为Key保存，Value则为subTree出现的次数
            * */
            int count = subTreeCount.getOrDefault(subTree, 0);
            /*通过比较集合中是否存在相同的subTree，即Value=1这说明存在重复的子树，将这个根节点保存到列表中
            * 即使多次重复也只会加入到列表中一次*/
            if (count == 1) {
                result.add(root);
            }
            /*将这个子树对应出现的次数+1*/
            subTreeCount.put(subTree, count + 1);
            return subTree;
        }
    }
}

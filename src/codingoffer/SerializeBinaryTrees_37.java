package codingoffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的序列化和反序列化
 */
public class SerializeBinaryTrees_37 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Codec2 codec = new SerializeBinaryTrees_37().new Codec2();
        System.out.println(codec.serialize(root));
        String serialize = codec.serialize(root);
        TreeNode treeNode = codec.deserialize("");
        System.out.println(treeNode.val);
    }

    /**
     * DFS递归实现序列化和反序列化
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = preOrder(root, new StringBuilder());
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        private StringBuilder preOrder(TreeNode root, StringBuilder stringBuilder) {
            if (root == null) {
                stringBuilder.append("#,");
                return stringBuilder;
            }

            stringBuilder.append(root.val + ",");
            preOrder(root.left, stringBuilder);
            preOrder(root.right, stringBuilder);
            return stringBuilder;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty())
                return null;

            List<String> list = new ArrayList<>();
            for (String s : data.split(",")) {
                list.add(s);
            }

            return buildBST(list);
        }

        private TreeNode buildBST(List<String> list) {
            if (list.isEmpty()) return null;

            if (list.get(0).equals("#")) {
                list.remove(0);
                return null;
            }

            TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
            list.remove(0);
            root.left = buildBST(list);
            root.right = buildBST(list);

            return root;
        }
    }

    /**
     * BFS层序遍历实现序列化和反序列化
     */
    public class Codec2 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";

            StringBuilder sb = new StringBuilder();

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("#,");
                    continue;
                }
                sb.append(node.val + ",");
                queue.add(node.left);
                queue.add(node.right);
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.isEmpty()) return null;

            String[] split = data.split(",");

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.valueOf(split[0]));
            queue.add(root);

            for (int i = 1; i < split.length; i++) {
                TreeNode parent = queue.poll();
                if (!"#".equals(split[i])) {
                    TreeNode left = new TreeNode(Integer.valueOf(split[i]));
                    parent.left = left;
                    queue.add(left);
                }
                if (!"#".equals(split[++i])) {
                    TreeNode right = new TreeNode(Integer.valueOf(split[i]));
                    parent.right = right;
                    queue.add(right);
                }
            }
            return root;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

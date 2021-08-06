package tree.medium;

import java.util.*;

/**
 * 序列化和反序列化BST
 */
public class SerializeAndDeserializeBST_449 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //root.left = new TreeNode(1);
        root.right = new TreeNode(2);

        Codec codec = new SerializeAndDeserializeBST_449().new Codec();
        String s = codec.serialize2(root);
        System.out.println(s);
        System.out.println(codec.deserialize2(s).val);
    }

    public class Codec {
        /**
         * 方法一：
         * 将一棵树进行序列化的方式有很多，这个方法使用后序遍历序列化
         * 而反序列化也是通过先序遍历字符串，递归构造左右子树
         *
         * @param root
         * @return
         */
        public String serialize(TreeNode root) {
            StringBuilder sb = postOrder(root, new StringBuilder());
            if (sb.length() > 0)
                sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }

        private StringBuilder postOrder(TreeNode root, StringBuilder sb) {
            if (root == null)
                return sb;
            postOrder(root.left, sb);
            postOrder(root.right, sb);
            sb.append(root.val);
            sb.append(',');
            return sb;
        }

        public TreeNode deserialize(String data) {
            if (data.isEmpty())
                return null;
            List<Integer> list = new ArrayList<>();
            for (String s : data.split(",")) {
                list.add(Integer.valueOf(s));
            }
            return buildBST(Integer.MIN_VALUE, Integer.MAX_VALUE, list);
        }

        private TreeNode buildBST(int smaller, int bigger, List<Integer> list) {
            if (list.isEmpty())
                return null;
            int val = list.get(list.size() - 1);
            if (val < smaller || val > bigger)
                return null;

            list.remove(list.size() - 1);
            TreeNode root = new TreeNode(val);
            root.right = buildBST(val, bigger, list);
            root.left = buildBST(smaller, val, list);
            return root;
        }

        /**
         * 方法二：层序遍历序列化，层序遍历构造BST
         *
         * @param root
         * @return
         */
        public String serialize2(TreeNode root) {
            if (root == null)
                return "#";
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

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
            return sb.toString();
        }


        public TreeNode deserialize2(String data) {
            if (data == "#")
                return null;
            String[] values = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            queue.offer(root);

            for (int i = 1; i < values.length; i++) {
                TreeNode parent = queue.poll();
                if (!"#".equals(values[i])) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    queue.offer(left);
                }
                if (!"#".equals(values[++i])) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = right;
                    queue.offer(right);
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

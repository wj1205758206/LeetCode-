
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //通过前序遍历，将二叉树扁平化成字符串，null节点用#表示
        StringBuilder sb = preOrder(root, new StringBuilder());
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1); //删除最后一个，分隔符
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        List<String> list = new ArrayList<>();
        //节点之间，分割
        for (String s : data.split(",")) {
            list.add(s);
        }
        //拿到所有节点list之后，准备构造二叉树
        return build(list);
    }

    public StringBuilder preOrder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#").append(",");
            return sb; //遍历到了null，返回上一层
        }
        //前序遍历代码
        sb.append(root.val).append(",");

        //递归左右子树
        preOrder(root.left, sb);
        preOrder(root.right, sb);

        //全部遍历完，返回序列化后的sb
        return sb;
    }

    public TreeNode build(List<String> list) {
        if (list.isEmpty()) {
            return null;
        }
        //按照list从前到后 依次构造root节点
        //如果遇到#，说明是null节点，无需构造直接返回null即可
        if (list.get(0).equals("#")) {
            list.remove(0);
            return null;
        }

        //前序遍历代码 构造root节点
        TreeNode root = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);

        //递归遍历左右子树
        root.left = build(list);
        root.right = build(list);

        //构造完所有的节点之后，返回root节点
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
//leetcode submit region end(Prohibit modification and deletion)

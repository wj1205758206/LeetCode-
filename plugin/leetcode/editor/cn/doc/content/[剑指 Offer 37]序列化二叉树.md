<p>请实现两个函数，分别用来序列化和反序列化二叉树。</p>

<p>你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。</p>

<p><strong>提示：</strong>输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅&nbsp;<a href="https://support.leetcode-cn.com/hc/kb/article/1567641/">LeetCode 序列化二叉树的格式</a>。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。</p>

<p>&nbsp;</p>

<p><strong>示例：</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/09/15/serdeser.jpg" style="width: 442px; height: 324px;" />
<pre>
<strong>输入：</strong>root = [1,2,3,null,null,4,5]
<strong>输出：</strong>[1,2,3,null,null,4,5]
</pre>

<p>&nbsp;</p>

<p>注意：本题与主站 297 题相同：<a href="https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/">https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/</a></p>
<details><summary><strong>Related Topics</strong></summary>树 | 深度优先搜索 | 广度优先搜索 | 设计 | 字符串 | 二叉树</details><br>

<div>👍 327, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.7](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中；B 站可查看 [核心算法框架系列视频](https://space.bilibili.com/14089380/channel/series)。**



<p><strong><a href="https://labuladong.github.io/article?qno=剑指Offer37" target="_blank">⭐️labuladong 题解</a></strong></p>
<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [297. 二叉树的序列化与反序列化](/problems/serialize-and-deserialize-binary-tree) 相同。

PS：这道题在[《算法小抄》](https://mp.weixin.qq.com/s/tUSovvogbR9StkPWb75fUw) 的第 247 页。

序列化问题其实就是遍历问题，你能遍历，顺手把遍历的结果转化成字符串的形式，不就是序列化了么？

这里我就简单说说用前序遍历的思路，前序遍历的特点是根节点在开头，然后接着左子树的前序遍历结果，然后接着右子树的前序遍历结果：

![](https://labuladong.github.io/algo/images/二叉树序列化/1.jpeg)

所以如果按照前序遍历顺序进行序列化，反序列化的时候，就知道第一个元素是根节点的值，然后递归调用反序列化左右子树，接到根节点上即可，上述思路翻译成代码即可解决本题。

当然，这题也可以尝试使用二叉树的中序、后序、层序的遍历方式来做，具体可看详细题解。

**详细题解：[东哥带你刷二叉树（序列化篇）](https://labuladong.github.io/article/fname.html?fname=二叉树的序列化)**

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)，[数据结构](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318892385270808576)，递归**

## 解法代码

```java
public class Codec {
    String SEP = ",";
    String NULL = "#";

    /* 主函数，将二叉树序列化为字符串 */
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        /******前序遍历位置******/
        sb.append(root.val).append(SEP);
        /***********************/

        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    /* 主函数，将字符串反序列化为二叉树结构 */
    public TreeNode deserialize(String data) {
        // 将字符串转化成列表
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    /* 辅助函数，通过 nodes 列表构造二叉树 */
    TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) return null;

        /******前序遍历位置******/
        // 列表最左侧就是根节点
        String first = nodes.removeFirst();
        if (first.equals(NULL)) return null;
        TreeNode root = new TreeNode(Integer.parseInt(first));
        /***********************/

        root.left = deserialize(nodes);
        root.right = deserialize(nodes);

        return root;
    }
}
```

**类似题目**：
  - [449. 序列化和反序列化二叉搜索树 🟠](/problems/serialize-and-deserialize-bst)
  - [剑指 Offer 37. 序列化二叉树 🔴](/problems/xu-lie-hua-er-cha-shu-lcof/)
  - [剑指 Offer II 048. 序列化与反序列化二叉树 🔴](/problems/h54YBf)

</details>
</div>




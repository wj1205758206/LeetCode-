<p>输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。</p>

<p>&nbsp;</p>

<p>为了让您更好地理解问题，以下面的二叉搜索树为例：</p>

<p>&nbsp;</p>

<p><img src="https://assets.leetcode.com/uploads/2018/10/12/bstdlloriginalbst.png"></p>

<p>&nbsp;</p>

<p>我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。</p>

<p>下图展示了上面的二叉搜索树转化成的链表。&ldquo;head&rdquo; 表示指向链表中有最小元素的节点。</p>

<p>&nbsp;</p>

<p><img src="https://assets.leetcode.com/uploads/2018/10/12/bstdllreturndll.png"></p>

<p>&nbsp;</p>

<p>特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。</p>

<p>&nbsp;</p>

<p><strong>注意：</strong>本题与主站 426 题相同：<a href="https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/">https://leetcode-cn.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/</a></p>

<p><strong>注意：</strong>此题对比原题有改动。</p>
<details><summary><strong>Related Topics</strong></summary>栈 | 树 | 深度优先搜索 | 二叉搜索树 | 链表 | 二叉树 | 双向链表</details><br>

<div>👍 536, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.8](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [426. 将二叉搜索树转化为排序的双向链表](/problems/convert-binary-search-tree-to-sorted-doubly-linked-list) 相同。

前文 [手把手刷二叉树总结篇](https://labuladong.github.io/article/fname.html?fname=二叉树总结) 说过二叉树的递归分为「遍历」和「分解问题」两种思维模式，这道题需要用到「分解问题」的思维。

想把整棵 BST 变成环形链表，可以先把左右子树变成环形链表，然后把 `root.val` 接在中间，这样就形成了整棵 BST 的环形链表。

不过合并环形链表的过程中，需要注意空指针的处理，具体见代码。

**标签：[二叉树](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2121994699837177859)**

## 解法代码

```java
class Solution {
    // 定义：输入一棵 BST，返回该 BST 改造成的环形链表的头结点
    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        // 先把左右子树都变成环形链表
        Node leftHead = treeToDoublyList(root.left);
        Node rightHead = treeToDoublyList(root.right);
        Node leftTail, rightTail;

        // 根节点接到左右两个环形链表中间
        if (leftHead != null) {
            leftTail = leftHead.left;
            root.left = leftTail;
            leftTail.right = root;
        } else {
            leftTail = leftHead = root;
        }
        if (rightHead != null) {
            rightTail = rightHead.left;
            root.right = rightHead;
            rightHead.left = root;
        } else {
            rightTail = rightHead = root;
        }

        // 两个环形链表头尾相接形成大的环形链表
        leftHead.left = rightTail;
        rightTail.right = leftHead;

        return leftHead;
    }
}
```

**类似题目**：
  - [剑指 Offer 36. 二叉搜索树与双向链表 🟠](/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof)

</details>
</div>








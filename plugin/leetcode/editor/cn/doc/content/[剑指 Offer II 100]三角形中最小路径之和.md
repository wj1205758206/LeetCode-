<p>给定一个三角形 <code>triangle</code> ，找出自顶向下的最小路径和。</p>

<p>每一步只能移动到下一行中相邻的结点上。<strong>相邻的结点 </strong>在这里指的是 <strong>下标</strong> 与 <strong>上一层结点下标</strong> 相同或者等于 <strong>上一层结点下标 + 1</strong> 的两个结点。也就是说，如果正位于当前行的下标 <code>i</code> ，那么下一步可以移动到下一行的下标 <code>i</code> 或 <code>i + 1</code> 。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
<strong>输出：</strong>11
<strong>解释：</strong>如下面简图所示：
   <strong>2</strong>
  <strong>3</strong> 4
 6 <strong>5</strong> 7
4 <strong>1</strong> 8 3
自顶向下的最小路径和为&nbsp;11（即，2&nbsp;+&nbsp;3&nbsp;+&nbsp;5&nbsp;+&nbsp;1&nbsp;= 11）。
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>triangle = [[-10]]
<strong>输出：</strong>-10
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= triangle.length &lt;= 200</code></li>
	<li><code>triangle[0].length == 1</code></li>
	<li><code>triangle[i].length == triangle[i - 1].length + 1</code></li>
	<li><code>-10<sup>4</sup> &lt;= triangle[i][j] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong></p>

<ul>
	<li>你可以只使用 <code>O(n)</code>&nbsp;的额外空间（<code>n</code> 为三角形的总行数）来解决这个问题吗？</li>
</ul>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 120&nbsp;题相同：&nbsp;<a href="https://leetcode-cn.com/problems/triangle/">https://leetcode-cn.com/problems/triangle/</a></p>
<details><summary><strong>Related Topics</strong></summary>数组 | 动态规划</details><br>

<div>👍 20, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.7](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中；B 站可查看 [核心算法框架系列视频](https://space.bilibili.com/14089380/channel/series)。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [120. 三角形最小路径和](/problems/triangle) 相同。

第 `i` 行的第 `j` 个元素从哪里来？可以从第 `i - 1` 行第 `j` 或第 `j - 1` 个元素下落过来，这就是所谓的状态转移关系：

落到 `triangle[i][j]` 的最小路径和可以通过落到 `triangle[i-1][j]` 和 `triangle[i-1][j-1]` 的最小路径和推导出来。

所以我们造一个 `dp` 数组，`dp[i][j]` 表示从 `triangle[0][0]` 走到 `triangle[i][j]` 的最小路径和。

进一步，base case 就是 `dp[0][0] = triangle[0][0]`，我们要找的答案就是 `dp[n-1][..]` 中的最大值。

状态转移方程：

```java
dp[i][j] = min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j]
```

**标签：[动态规划](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=1318881141113536512)**

## 解法代码

```java
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // 定义：走到第 i 行第 j 个元素的最小路径和是 dp[i][j]
        int[][] dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            // 因为求最小值，所以全都初始化为极大值
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        // base case
        dp[0][0] = triangle.get(0).get(0);
        // 进行状态转移
        for (int i = 1; i < dp.length; i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                // 状态转移方程
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + row.get(j);
                } else {
                    dp[i][j] = dp[i - 1][j] + row.get(j);
                }
            }
        }
        // 找出落到最后一层的最小路径和
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < dp[n - 1].length; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }
        return res;
    }
}
```

**类似题目**：
  - [剑指 Offer II 100. 三角形中最小路径之和 🟠](/problems/IlPe0q)

</details>
</div>




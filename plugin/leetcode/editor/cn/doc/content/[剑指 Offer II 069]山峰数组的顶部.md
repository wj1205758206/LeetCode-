<p>符合下列属性的数组 <code>arr</code> 称为 <strong>山峰数组</strong>（<strong>山脉数组）</strong> ：</p>

<ul>
	<li><code>arr.length &gt;= 3</code></li>
	<li>存在 <code>i</code>（<code>0 &lt; i&nbsp;&lt; arr.length - 1</code>）使得：
	<ul>
		<li><code>arr[0] &lt; arr[1] &lt; ... arr[i-1] &lt; arr[i] </code></li>
		<li><code>arr[i] &gt; arr[i+1] &gt; ... &gt; arr[arr.length - 1]</code></li>
	</ul>
	</li>
</ul>

<p>给定由整数组成的山峰数组 <code>arr</code> ，返回任何满足 <code>arr[0] &lt; arr[1] &lt; ... arr[i - 1] &lt; arr[i] &gt; arr[i + 1] &gt; ... &gt; arr[arr.length - 1]</code> 的下标 <code>i</code>&nbsp;，即山峰顶部。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>arr = [0,1,0]
<strong>输出：</strong>1
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>arr = [1,3,5,4,2]
<strong>输出：2</strong>
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>arr = [0,10,5,2]
<strong>输出：</strong>1
</pre>

<p><strong>示例 4：</strong></p>

<pre>
<strong>输入：</strong>arr = [3,4,5,1]
<strong>输出：</strong>2
</pre>

<p><strong>示例 5：</strong></p>

<pre>
<strong>输入：</strong>arr = [24,69,100,99,79,78,67,36,26,19]
<strong>输出：</strong>2
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>3 &lt;= arr.length &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10<sup>6</sup></code></li>
	<li>题目数据保证 <code>arr</code> 是一个山脉数组</li>
</ul>

<p>&nbsp;</p>

<p><strong>进阶：</strong>很容易想到时间复杂度 <code>O(n)</code> 的解决方案，你可以设计一个 <code>O(log(n))</code> 的解决方案吗？</p>

<p>&nbsp;</p>

<p><meta charset="UTF-8" />注意：本题与主站 852&nbsp;题相同：<a href="https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/">https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/</a></p>
<details><summary><strong>Related Topics</strong></summary>数组 | 二分查找</details><br>

<div>👍 88, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.7](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中；B 站可查看 [核心算法框架系列视频](https://space.bilibili.com/14089380/channel/series)。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

这道题和 [852. 山脉数组的峰顶索引](/problems/peak-index-in-a-mountain-array) 相同。

[二分搜索框架详解](https://labuladong.github.io/article/fname.html?fname=二分查找详解) 的经典应用，不过这道题和 [162. 寻找峰值](/problems/find-peak-element) 差不多，直接把 162 题的解法复制过来即可通过。

**标签：[二分搜索](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)，[数组](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2120601117519675393)**

## 解法代码

```java
class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        // 取两端都闭的二分搜索
        int left = 0, right = nums.length - 1;
        // 因为题目必然有解，所以设置 left == right 为结束条件
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                // mid 本身就是峰值或其左侧有一个峰值
                right = mid;
            } else {
                // mid 右侧有一个峰值
                left = mid + 1;
            }
        }
        return left;
    }
}
```

**类似题目**：
  - [剑指 Offer II 069. 山峰数组的顶部 🟢](/problems/B1IidL)

</details>
</div>




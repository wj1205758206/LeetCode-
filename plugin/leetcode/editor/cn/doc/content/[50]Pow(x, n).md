<p>实现&nbsp;<a href="https://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(<em>x</em>, <em>n</em>)</a>&nbsp;，即计算 <code>x</code> 的整数&nbsp;<code>n</code> 次幂函数（即，<code>x<sup>n</sup></code><sup><span style="font-size:10.8333px"> </span></sup>）。</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre>
<strong>输入：</strong>x = 2.00000, n = 10
<strong>输出：</strong>1024.00000
</pre>

<p><strong>示例 2：</strong></p>

<pre>
<strong>输入：</strong>x = 2.10000, n = 3
<strong>输出：</strong>9.26100
</pre>

<p><strong>示例 3：</strong></p>

<pre>
<strong>输入：</strong>x = 2.00000, n = -2
<strong>输出：</strong>0.25000
<strong>解释：</strong>2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25
</pre>

<p>&nbsp;</p>

<p><strong>提示：</strong></p>

<ul>
	<li><code>-100.0 &lt; x &lt; 100.0</code></li>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
	<li><code>-10<sup>4</sup> &lt;= x<sup>n</sup> &lt;= 10<sup>4</sup></code></li>
</ul>
<details><summary><strong>Related Topics</strong></summary>递归 | 数学</details><br>

<div>👍 995, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.8](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中；[第十期刷题打卡挑战](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 最后一天报名。**

<details><summary><strong>labuladong 思路</strong></summary>

## 基本思路

幂运算是经典的数学运算技巧了，建议你看下前文 [如何高效进行模幂运算](https://labuladong.github.io/article/fname.html?fname=superPower) 就能很容易理解解法代码里的思想了。这道题唯一有点恶心的就是 `k` 的取值范围特别大，不能直接加符号，否则会造成整型溢出，具体解法看代码吧。

**标签：[数学](https://mp.weixin.qq.com/mp/appmsgalbum?__biz=MzAxODQxMDM0Mw==&action=getalbum&album_id=2122023604245659649)**

## 解法代码

```java
class Solution {
    public double myPow(double a, int k) {
        if (k == 0) return 1;

        if (k == Integer.MIN_VALUE) {
            // 把 k 是 INT_MIN 的情况单独拿出来处理
            // 避免 -k 整型溢出
            return myPow(1 / a, -(k + 1)) / a;
        }

        if (k < 0) {
            return myPow(1 / a, -k);
        }

        if (k % 2 == 1) {
            // k 是奇数
            return (a * myPow(a, k - 1));
        } else {
            // k 是偶数
            double sub = myPow(a, k / 2);
            return (sub * sub);
        }
    }
}
```

**类似题目**：
  - [剑指 Offer 16. 数值的整数次方 🟠](/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/)

</details>
</div>






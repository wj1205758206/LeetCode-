<p>用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 <code>appendTail</code> 和 <code>deleteHead</code> ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，<code>deleteHead</code>&nbsp;操作返回 -1 )</p>

<p>&nbsp;</p>

<p><strong>示例 1：</strong></p>

<pre><strong>输入：</strong>
[&quot;CQueue&quot;,&quot;appendTail&quot;,&quot;deleteHead&quot;,&quot;deleteHead&quot;]
[[],[3],[],[]]
<strong>输出：</strong>[null,null,3,-1]
</pre>

<p><strong>示例 2：</strong></p>

<pre><strong>输入：</strong>
[&quot;CQueue&quot;,&quot;deleteHead&quot;,&quot;appendTail&quot;,&quot;appendTail&quot;,&quot;deleteHead&quot;,&quot;deleteHead&quot;]
[[],[],[5],[2],[],[]]
<strong>输出：</strong>[null,-1,null,null,5,2]
</pre>

<p><strong>提示：</strong></p>

<ul>
	<li><code>1 &lt;= values &lt;= 10000</code></li>
	<li><code>最多会对&nbsp;appendTail、deleteHead 进行&nbsp;10000&nbsp;次调用</code></li>
</ul>
<details><summary><strong>Related Topics</strong></summary>栈 | 设计 | 队列</details><br>

<div>👍 563, 👎 0</div>

<div id="labuladong"><hr>

**通知：[数据结构精品课 V1.6](https://aep.h5.xeknow.com/s/1XJHEO) 持续更新中，[第八期打卡挑战（升级版）](https://mp.weixin.qq.com/s/eUG2OOzY3k_ZTz-CFvtv5Q) 7/11 截止报名，B 站已更新 [核心算法框架系列视频](https://space.bilibili.com/14089380/channel/series)。**

</div>




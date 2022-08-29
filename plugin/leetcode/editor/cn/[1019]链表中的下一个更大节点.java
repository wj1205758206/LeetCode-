
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) return new int[]{};
        List<Integer> list = new ArrayList<>();
        int size = 0;
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            size++;
            p = p.next;
        }
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            while (!stack.isEmpty() && list.get(i) >= stack.peek()) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(list.get(i));
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

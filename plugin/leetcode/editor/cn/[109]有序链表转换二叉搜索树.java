
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

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        return buidlTree(head, null);
    }

    public TreeNode buidlTree(ListNode left, ListNode right) {
        if (left == right) return null;
        ListNode mid = findMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buidlTree(left, mid);
        root.right = buidlTree(mid.next, right);
        return root;
    }

    public ListNode findMid(ListNode left, ListNode right) {
        ListNode slow, fast;
        slow = fast = left;
        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

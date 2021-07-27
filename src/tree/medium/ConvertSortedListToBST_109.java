package tree.medium;

/**
 * 有序链表转BST
 */
public class ConvertSortedListToBST_109 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        Solution solution = new ConvertSortedListToBST_109().new Solution();
        TreeNode root = solution.sortedListToBST(head);
        System.out.println(root.val);
    }

    class Solution {
        /**
         * 有序链表转BST，此题和108差不多，只不过108是有序列表，109是有序链表
         * 都是使用递归方法，中点作为root，然后左右孩子递归构造
         * 列表获取中点容易，直接索引即可，但是链表需要遍历才能找到中点
         * 需要构造一个辅助方法，传入两个参数，链表头head作为遍历的起点，链表尾巴null作为遍历的终点
         * 每一递归遍历，链表的长度是不断变化的，也就是起点和终点不断变化
         * 对于找链表中点，可以使用快慢指针的方法找到中点
         *
         * @param head
         * @return
         */
        public TreeNode sortedListToBST(ListNode head) {
            return buildTree(head, null);
        }

        private TreeNode buildTree(ListNode left, ListNode right) {
            /*基准条件*/
            if (left == right)
                return null;

            /*找到当前链表的中点构造出root*/
            ListNode mid = findMid(left, right);
            TreeNode root = new TreeNode(mid.val);

            /*递归构造左右孩子，链表不断被中点切分成左右两部分，充当左右子树*/
            root.left = buildTree(left, mid);
            root.right = buildTree(mid.next, right);

            return root;

        }

        private ListNode findMid(ListNode left, ListNode right) {
            ListNode slow = left;
            ListNode fast = left;

            while (fast != right && fast.next != right) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}

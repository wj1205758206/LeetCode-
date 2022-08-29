
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode postNode = node.next;
        while (postNode != null){
            node.val = postNode.val;
            node = node.next;
            postNode = postNode.next;
        }
        node.next = null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

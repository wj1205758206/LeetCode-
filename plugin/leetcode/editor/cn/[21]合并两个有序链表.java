
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode p = null;
        if (list1.val < list2.val){
            p = list1;
            p.next = mergeTwoLists(list1.next, list2);
        }else{
            p = list2;
            p.next = mergeTwoLists(list1, list2.next);
        }
        return p;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

package codingoffer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstCommonNodeInLinkedList_52 {
    public static void main(String[] args) {

    }

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            Map<ListNode, ListNode> map = new HashMap<>();
            ListNode t = headA;
            while (t != null) {
                map.put(t, t.next);
                t = t.next;
            }
            t = headB;
            while (t != null) {
                if (map.containsKey(t)) {
                    return t;
                }
                t = t.next;
            }
            return null;
        }

        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            int ALength = getLinkedListLength(headA);
            int BLength = getLinkedListLength(headB);
            int count = ALength - BLength;

            ListNode longLinkedList = headA;
            ListNode shortLinkedList = headB;

            if (ALength < BLength) {
                longLinkedList = headB;
                shortLinkedList = headA;
                count = -count;
            }

            while (count != 0) {
                count--;
                longLinkedList = longLinkedList.next;
            }

            while (longLinkedList != null && shortLinkedList != null && longLinkedList != shortLinkedList) {
                longLinkedList = longLinkedList.next;
                shortLinkedList = shortLinkedList.next;
            }

            return longLinkedList;
        }

        private int getLinkedListLength(ListNode head) {
            if (head == null) return 0;
            return 1 + getLinkedListLength(head.next);
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}

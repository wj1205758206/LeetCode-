package linkedList.medium;

public class Utils {
    /*创建num个节点的链表*/
    public static ListNode createLinkedList(int num){
        ListNode head = null;
        for (int i = 1; i <= num; i++){
            ListNode node = new ListNode(i);
            if (head == null){
                head = node;
            }else {
                ListNode t = head;
                while (t.next != null){
                    t = t.next;
                }
                t.next = node;
            }
        }
        return head;
    }


    /*打印所有的节点*/
    public static void print(ListNode head){
        ListNode temp = head;
        while (temp != null){
            if (temp.next == null)
                System.out.println(temp.val);
            else
                System.out.print(temp.val + " --> ");
            temp = temp.next;
        }
    }

}

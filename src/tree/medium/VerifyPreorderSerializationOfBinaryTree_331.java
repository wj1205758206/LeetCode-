package tree.medium;

import java.util.Stack;

/**
 * 验证二叉树的前序序列化
 */
public class VerifyPreorderSerializationOfBinaryTree_331 {
    public static void main(String[] args) {
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";

        Solution solution = new VerifyPreorderSerializationOfBinaryTree_331().new Solution();
        System.out.println(solution.isValidSerialization(preorder));
    }

    class Solution {
        /**
         * 方法一：使用栈记录每个节点剩余槽位的变化
         * 一个槽位可以被看作「当前二叉树中正在等待被节点填充」的那些位置，每个节点初始时都拥有两个空的槽位
         * 如果遇到了空节点，则要消耗一个槽位
         * 如果遇到了非空节点，则除了消耗一个槽位外，还要再补充两个槽位
         * 使用栈来维护槽位的变化。栈中的每个元素，代表了对应节点处剩余槽位的数量，而栈顶元素就对应着下一步可用的槽位数量。
         *
         * @param preorder
         * @return
         */
        public boolean isValidSerialization(String preorder) {
            int n = preorder.length();
            int i = 0;
            Stack<Integer> stack = new Stack<>();

            /*栈初始化时有一个空的槽位，用来放置root根节点*/
            stack.push(1);

            while (i < n) {
                /*在遍历过程中，如果栈为空了，也就是没有剩余的槽位可用了，则返回false*/
                if (stack.isEmpty())
                    return false;
                /*跳过逗号*/
                if (preorder.charAt(i) == ',') {
                    i++;
                } else if (preorder.charAt(i) == '#') {
                    /*当前节点是空节点时，将栈顶元素减1，如果当前节点减1后还有剩余槽位，则重新压入更新槽位余量*/
                    int top = stack.pop() - 1;
                    if (top > 0) {
                        stack.push(top);
                    }
                    i++;
                } else {
                    /*读入一个数字，由于逗号也占用一个索引，所以使用while循环每次索引停止在逗号位置*/
                    while (i < n && preorder.charAt(i) != ',') {
                        i++;
                    }
                    /*当读入的是非空节点是，需要将栈顶元素减1后，再扩充2个槽位*/
                    int top = stack.pop() - 1;
                    if (top > 0) {
                        stack.push(top);
                    }
                    stack.push(2);
                }
            }
            /*遍历结束后，如果栈为空，说明没有待填充的槽位，因此是一个合法序列，否则栈不为空，则序列不合法*/
            return stack.isEmpty();
        }

        /**
         * 方法二：整体计算槽位
         * 可以把方法一中的每一个节点的槽位，把栈整体看作槽位的集合，把栈看作一个整体，整体计算槽位的变化
         *
         * @param preorder
         * @return
         */
        public boolean isValidSerialization2(String preorder) {
            int n = preorder.length();
            int i = 0;
            int slots = 1;
            while (i < n) {
                if (slots == 0)
                    return false;
                if (preorder.charAt(i) == ',') {
                    i++;
                } else if (preorder.charAt(i) == '#') {
                    /*空节点只会消耗一个槽位*/
                    slots--;
                    i++;
                } else {
                    /*读入一个数字*/
                    while (i < n && preorder.charAt(i) != ',') {
                        i++;
                    }
                    /*非空节点会消耗一个，然后扩充2个槽位，所以 -1+2 相当于增加一个槽位*/
                    slots++;
                }
            }
            /*栈为空相当于槽位为0*/
            return slots == 0;
        }

        /**
         * 方法三：计算出度和入度
         * 二叉树本质也是一个图，图的一条边会提供一个出度和入度，所以二叉树所有的节点的入度之和等于出度之和，即整体来看 diff = 出度-入度 = 0
         * 每个空节点会提供0个出度和1个入度
         * 每个非空节点会提供2个出度和1个入度
         * 这里的出度和入度  与  槽位的概念差不多，度倾向于衡量当前节点，而槽位更倾向于衡量下一层节点
         *
         * @param preorder
         * @return
         */
        public boolean isValidSerialization3(String preorder) {
            /*这里把diff初始为1是因为，root根节点入度为0，出度为2
             * 加入一个非空节点时，都会对 diff 先减去 1（入度），再加上 2（出度）
             * 但是由于根节点没有父节点，所以其入度为 0，出度为 2
             * 为了保持统一，diff 初始化为 1，是为了在加入根节点的时候，diff 先减去 1（入度），再加上 2（出度），此时 diff 正好应该是2.
             * 所以二叉树只有一个root节点也满足规则*/
            int diff = 1;

            /*遍历所有数字*/
            for (String s : preorder.split(",")) {
                /*diff = 出度-入度
                 *无论是否是空节点，入度都会减1*/
                diff--;
                /*还没遍历完之前出度应该大于等于入度*/
                if (diff < 0) {
                    return false;
                }
                /*如果当前是非空节点，再补充上2个出度*/
                if (!s.equals("#")) {
                    diff += 2;
                }
            }
            /*最后遍历完整棵树diff应该为0*/
            return diff == 0;
        }
    }
}

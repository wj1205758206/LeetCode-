package codingoffer;

/**
 * 判断BST的后序遍历序列是否合法
 */
public class SequenceOfBST_33 {
    public static void main(String[] args) {
        Solution solution = new SequenceOfBST_33().new Solution();
        System.out.println(solution.verifyPostorder(new int[]{4, 6, 7, 5}));
    }

    class Solution {
        public boolean verifyPostorder(int[] postorder) {
            /*递归划分左右子树*/
            return verify(postorder, 0, postorder.length - 1);
        }

        private boolean verify(int[] postorder, int start, int end) {
            if (start >= end)
                return true;
            int right = start;

            //后序遍历的最后的一个是BST得根节点
            int rootVal = postorder[end];

            //从左到右遍历，找到第一个大于等于root节点的那个节点，这个节点就是右子树的第一个起始节点
            for (int i = start; i < end; i++) {
                if (postorder[i] < rootVal) {
                    right = i; //不断右移，找右子树第一个节点
                } else {
                    break;
                }
            }

            right++;
            //从右子树第一个节点开始遍历，如果右子树中有小于root节点的，说明非法
            for (int i = right; i < end; i++) {
                if (postorder[i] < rootVal)
                    return false;
            }

            //每次递归遍历都切分出来了左右子树在数组中的索引范围，递归判断左右子树
            return verify(postorder, start, right - 1) && verify(postorder, right, end - 1);
        }

    }
}

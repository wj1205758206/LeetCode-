package array.easy;

public class TwoSum_167 {
    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        Solution solution = new Solution();
        int[] indexs = solution.twoSum(numbers, target);
        System.out.println(indexs[0] + "," + indexs[1]);

    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] == target)
                    return new int[] {left + 1, right + 1};
                else if (numbers[left] + numbers[right] < target) {
                    left++;
                }else if (numbers[left] + numbers[right] > target) {
                    right--;
                }
            }
            return new int[]{-1, -1};
        }
    }
}

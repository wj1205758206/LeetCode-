
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int preimageSizeFZF(int k) {
        return (int) (rightBound(k) - leftBound(k) + 1);
    }

    public long leftBound(int k) {
        long left = 0, right = Long.MAX_VALUE;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (tailZero(mid) < k) {
                left = mid + 1;
            } else if (tailZero(mid) > k) {
                right = mid - 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public long rightBound(int k) {
        long left = 0, right = Long.MAX_VALUE;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (tailZero(mid) < k) {
                left = mid + 1;
            } else if (tailZero(mid) > k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public long tailZero(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d /= 5) {
            res += d / 5;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

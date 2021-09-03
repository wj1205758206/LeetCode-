package greedy.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 视频拼接
 */
public class VideoStitching_1024 {
    public static void main(String[] args) {
        Solution solution = new VideoStitching_1024().new Solution();

    }

    class Solution {
        /**
         * 使用贪心算法，我们应该尽量每次都选择区间最长的，也就是视频片段跨度最大的那一个，这样才能保证所需片段最少
         *
         * @param clips
         * @param time
         * @return
         */
        public int videoStitching(int[][] clips, int time) {
            /*先按照视频开头做升序，然后按照视频结尾做降序，这样尽可能选出跨度最大的片段*/
            Arrays.sort(clips, new Comparator<int[]>() {
                        @Override
                        public int compare(int[] o1, int[] o2) {
                            if (o1[0] == o2[0]) {
                                return o2[1] - o1[1];
                            }
                            return o1[0] - o2[0];
                        }
                    }
            );

            int result = 0;

            int curEnd = 0, nextEnd = 0;
            int start = 0;
            while (start < clips.length && clips[start][0] <= curEnd) {

                /*根据上一个片段，选出与之相交的，且结束时间最晚的，也就是片段跨度最大的下一个片段*/
                while (start < clips.length && clips[start][0] <= curEnd) {
                    nextEnd = Math.max(nextEnd, clips[start][1]);
                    start++;
                }

                result++;   //数量加1
                curEnd = nextEnd;   //更新已选出能够拼接出来的最大结尾时间
                if (curEnd >= time) //如果拼接的结尾已经达到time了，就无需继续选择拼接，直接返回即可
                    return result;
            }

            return -1;  //遍历完所有的片段，始终没有拼接到time长度，则返回-1
        }
    }
}

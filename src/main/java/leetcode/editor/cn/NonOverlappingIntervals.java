//给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。
//
// 注意:
//
//
// 可以认为区间的终点总是大于它的起点。
// 区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
//
//
// 示例 1:
//
//
//输入: [ [1,2], [2,3], [3,4], [1,3] ]
//
//输出: 1
//
//解释: 移除 [1,3] 后，剩下的区间没有重叠。
//
//
// 示例 2:
//
//
//输入: [ [1,2], [1,2], [1,2] ]
//
//输出: 2
//
//解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
//
//
// 示例 3:
//
//
//输入: [ [1,2], [2,3] ]
//
//输出: 0
//
//解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
//
// Related Topics 贪心 数组 动态规划 排序 👍 568 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        Solution solution = new NonOverlappingIntervals().new Solution();
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{1, 100}, {11, 22}, {1, 11}, {2, 12}}));
        System.out.println(solution.eraseOverlapIntervals(new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}}));
        /**
         * [[-73, -26], [-65, -11], [-63, 2], [-62, -49], [-52, 31], [-40, -26], [-31, 49], [30, 47], [58, 95], [66, 98], [82, 97], [95, 99]]
         */
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            //直接按照第一个变量进行升序排序
            Arrays.stream(intervals).collect(Collectors.toList()).sort(Comparator.comparing(ints -> ints[0]));
            Arrays.sort(intervals, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o1[0] - o2[0];
                }
            });
            /** 思考,什么样的情况下会出现区间的可移除的区间是可以有不同的选择的
             * [ [1,2], [2,3], [3,4], [1,3] ]
             * [ [1,2], [1,2], [1,3], [2,3], [3,4] ]
             * [[1,100],[11,22],[1,11],[2,12]] 排序后
             * [[1,11],[1,100],[2,12],[11,22]]
             * [[1,11],[1,100],[2,12],[11,22]]
             */
            int[] prev = intervals[0];
            int remoteCount = 0;
            for (int i = 1; i < intervals.length; i++) {
                int[] current = intervals[i];
                if (current[0] < prev[1]) {
                    remoteCount++;
                    //    看一下哪个裹住的区间更小就用哪个
                    if (current[1] - current[0] < prev[1] - prev[0]) {
                        prev = current;
                    }
                } else {
                    prev = current;
                }
            }
            return remoteCount;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

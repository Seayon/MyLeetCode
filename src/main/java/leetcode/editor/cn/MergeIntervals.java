//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
//
//
//
// 示例 1：
//
//
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//
//
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
//
//
//
// 提示：
//
//
// 1 <= intervals.length <= 10⁴
// intervals[i].length == 2
// 0 <= starti <= endi <= 10⁴
//
// Related Topics 数组 排序 👍 1236 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.*;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        int[][] merge = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println(Arrays.deepToString(merge));
        Assertions.assertArrayEquals(new int[][]{{1, 4}}, solution.merge(new int[][]{{1, 4}, {2, 3}}));
        Assertions.assertArrayEquals(new int[][]{{1, 4}}, solution.merge(new int[][]{{2, 4}, {1, 3}}));
        Assertions.assertArrayEquals(new int[][]{{0, 5}}, solution.merge(new int[][]{{1, 4}, {0, 2}, {3, 5}}));
        //    {0,2},{1,4},{3,5}
        //    {0,4},{3,5}
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<Integer[]> list = new LinkedList<>();
            for (int i = 0; i < intervals.length; i++) {
                list.add(new Integer[]{intervals[i][0], intervals[i][1]});
            }
            Collections.sort(list, Comparator.comparing(o -> o[0]));

            for (int i = 0; i < list.size() - 1; i++) {
                Integer[] prev = list.get(i);
                Integer[] next = list.get(i + 1);
                Integer[] result = new Integer[2];
                if (prev[1] >= next[0]) {
                    result[0] = prev[0];
                    result[1] = Math.max(prev[1], next[1]);
                    list.set(i, result);
                    list.remove(i + 1);
                    i--;
                }
            }
            int[][] r = new int[list.size()][2];
            int j = 0;
            for (Integer[] integers : list) {
                r[j] = new int[]{integers[0], integers[1]};
                j++;
            }
            return r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

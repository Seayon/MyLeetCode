//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
//
//
//
//
//
// 示例 1:
//
//
//输入: rowIndex = 3
//输出: [1,3,3,1]
//
//
// 示例 2:
//
//
//输入: rowIndex = 0
//输出: [1]
//
//
// 示例 3:
//
//
//输入: rowIndex = 1
//输出: [1,1]
//
//
//
//
// 提示:
//
//
// 0 <= rowIndex <= 33
//
//
//
//
// 进阶：
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
// Related Topics 数组 动态规划 👍 346 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        List<Integer> row = solution.getRow(1);
        row = solution.getRow(3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            Integer[] result = new Integer[rowIndex + 1];
            result[0] = 1;
            result[rowIndex] = 1;
            int i = 1;
            while (i <= rowIndex) {
                result[i] = 0;
                for (int j = i; j > 0; j--) {
                    result[j] = result[j - 1] + result[j];
                }
                i++;
            }
            return Arrays.stream(result).collect(Collectors.toList());
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

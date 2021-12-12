//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
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
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
//
//
// 示例 2:
//
//
//输入: numRows = 1
//输出: [[1]]
//
//
//
//
// 提示:
//
//
// 1 <= numRows <= 30
//
// Related Topics 数组 动态规划 👍 646 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangle().new Solution();
        Assertions.assertArrayEquals(new int[][]{{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}, {1, 4, 6, 4, 1}}, solution.generate(3).toArray());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < numRows; i++) {
                //初始化填充空的数组
                List<Integer> tmp = new ArrayList<>(i + 1);
                for (int j = 0; j < i + 1; j++) {
                    if (j == 0 || j == i) {
                        tmp.add(j, 1);
                        continue;
                    }
                    tmp.add(j, result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
                result.add(tmp);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

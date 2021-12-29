//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
//
//
// 每行的元素从左到右升序排列。
// 每列的元素从上到下升序排列。
//
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
//
//
// 示例 2：
//
//
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= n, m <= 300
// -10⁹ <= matrix[i][j] <= 10⁹
// 每行的所有元素从左到右升序排列
// 每列的所有元素从上到下升序排列
// -10⁹ <= target <= 10⁹
//
// Related Topics 数组 二分查找 分治 矩阵 👍 894 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class SearchA2dMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SearchA2dMatrixIi().new Solution();

        int[][] ints = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        Assertions.assertEquals(true, solution.searchMatrix(ints, 5));
        Assertions.assertEquals(true, solution.searchMatrix(ints, 15));
        Assertions.assertEquals(true, solution.searchMatrix(ints, 1));
        Assertions.assertEquals(true, solution.searchMatrix(ints, 4));
        Assertions.assertEquals(true, solution.searchMatrix(ints, 7));
        Assertions.assertEquals(false, solution.searchMatrix(ints, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // 定义初始的查找范围,即全部,从左上角到右下角所有的
            for (int i = 0; i < matrix.length; i++) {
                //    按行暴力遍历
                int startJ = 0;
                int endJ = matrix[i].length - 1;
                while (startJ <= endJ) {
                    int middleIndex = (endJ - startJ) / 2 + startJ;
                    int middle = matrix[i][middleIndex];
                    if (middle == target) {
                        return true;
                    }
                    if (middle > target) {
                        endJ = middleIndex - 1;
                    }
                    if (middle < target) {
                        startJ = middleIndex + 1;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

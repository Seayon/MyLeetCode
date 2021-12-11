//在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
//
//
// 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
//
// 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
//
// 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
//
//
//
// 示例 1：
//
//
//输入：mat = [[1,2],[3,4]], r = 1, c = 4
//输出：[[1,2,3,4]]
//
//
// 示例 2：
//
//
//输入：mat = [[1,2],[3,4]], r = 2, c = 4
//输出：[[1,2],[3,4]]
//
//
//
//
// 提示：
//
//
// m == mat.length
// n == mat[i].length
// 1 <= m, n <= 100
// -1000 <= mat[i][j] <= 1000
// 1 <= r, c <= 300
//
// Related Topics 数组 矩阵 模拟 👍 266 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        Solution solution = new ReshapeTheMatrix().new Solution();
        Assertions.assertArrayEquals(new int[][]{{1, 2, 3, 4}}, solution.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4));
        Assertions.assertArrayEquals(new int[][]{{1, 2}, {3, 4}}, solution.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 2, 4));
        Assertions.assertArrayEquals(new int[][]{{1}, {2}, {3}, {4}}, solution.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 4, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if (mat.length * mat[0].length != r * c) {
                return mat;
            }
            int[] tmp = new int[r * c];
            int t = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[i].length; j++) {
                    tmp[t++] = mat[i][j];
                }
            }
            t = 0;
            int[][] result = new int[r][c];
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] = tmp[t++];
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

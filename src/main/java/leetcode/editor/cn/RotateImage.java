//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
//
//
// 示例 2：
//
//
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//
// 示例 3：
//
//
//输入：matrix = [[1]]
//输出：[[1]]
//
//
// 示例 4：
//
//
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
//
//
//
//
// 提示：
//
//
// matrix.length == n
// matrix[i].length == n
// 1 <= n <= 20
// -1000 <= matrix[i][j] <= 1000
//
// Related Topics 数组 数学 矩阵 👍 1100 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        int[][] matrix = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void rotate(int[][] matrix) {
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = i; j < matrix[i].length - i - 1; j++) {
                    //暂存当前位置的数据
                    int tmp = matrix[i][j];
                    //当前位置用另一个位置的数字来填充
                    // i = 0,j = 1
                    // [0,1] 放的 1 用 [2,0] 的 13 替换
                    // 4- 2 -1 = 2 = i
                    int arrayLength = matrix.length;
                    matrix[i][j] = matrix[arrayLength - j - 1][i];
                    matrix[arrayLength - j - 1][i] = matrix[arrayLength - i - 1][arrayLength - j - 1];
                    matrix[arrayLength - i - 1][arrayLength - j - 1] = matrix[j][arrayLength - 1 - i];
                    matrix[j][arrayLength - 1 - i] = tmp;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

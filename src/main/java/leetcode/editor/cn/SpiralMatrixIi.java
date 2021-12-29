//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
// Related Topics 数组 矩阵 模拟 👍 556 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SpiralMatrixIi {
    public static void main(String[] args) {
        Solution solution = new SpiralMatrixIi().new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
        System.out.println(Arrays.deepToString(solution.generateMatrix(4)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            int k = 1;
            for (int i = 0; i < n / 2 + 1; i++) {
                //上侧
                // 横坐标:i, 纵坐标起始: i,结束: n -i;
                for (int j = i; j < n - i; j++) {
                    result[i][j] = k;
                    k++;
                }
                // 右侧
                // 横坐标起始: i+1,结束: n-i-1, 纵坐标: n-i-1
                for (int m = i + 1; m <= n - i - 1; m++) {
                    result[m][n - i - 1] = k;
                    k++;
                }
                // 下侧
                //横坐标 n-i -1,纵坐标起始: n-1 -i -1,结束: i
                for (int z = n - 1 - i - 1; z >= i; z--) {
                    result[n - i - 1][z] = k;
                    k++;
                }
                // 左侧
                // 横坐标 起始: n-i-1,结束: i 纵坐标: i
                for (int x = n - 1 - i - 1; x > i; x--) {
                    result[x][i] = k;
                    k++;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

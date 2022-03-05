//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ ）。
//
//
//
// 示例 1：
//
//
//输入：x = 2.00000, n = 10
//输出：1024.00000
//
//
// 示例 2：
//
//
//输入：x = 2.10000, n = 3
//输出：9.26100
//
//
// 示例 3：
//
//
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
//
//
//
//
// 提示：
//
//
// -100.0 < x < 100.0
// -231 <= n <= 231-1
// -104 <= xⁿ <= 104
//
// Related Topics 递归 数学 👍 878 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class PowxN {
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        Assertions.assertEquals(1, solution.myPow(22, 0));
        Assertions.assertEquals(1024, solution.myPow(2, 10));
        Assertions.assertEquals(0.25, solution.myPow(2, -2));
        Assertions.assertEquals(9.26100, solution.myPow(2.1, 3));
        Assertions.assertEquals(0.25, solution.myPow(2, -2));
        Assertions.assertEquals(1024, solution.myPow(2, 10));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double myPow(double x, int n) {
            if (n == 0) {
                return 1;
            }
            double b = x;
            for (int i = 0; i < Math.abs(n - 1); i++) {
                if (n > 0) {
                    x = x * b;
                } else {
                    x = x * (1d / -n);
                }
            }
            return x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

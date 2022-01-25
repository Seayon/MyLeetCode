//给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
//
// 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
//
//
//
// 示例 1：
//
//
//输入：x = 121
//输出：true
//
//
// 示例 2：
//
//
//输入：x = -121
//输出：false
//解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
//
//
// 示例 3：
//
//
//输入：x = 10
//输出：false
//解释：从右向左读, 为 01 。因此它不是一个回文数。
//
//
// 示例 4：
//
//
//输入：x = -101
//输出：false
//
//
//
//
// 提示：
//
//
// -2³¹ <= x <= 2³¹ - 1
//
//
//
//
// 进阶：你能不将整数转为字符串来解决这个问题吗？
// Related Topics 数学 👍 1779 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class PalindromeNumber {
    public static void main(String[] args) {
        Solution solution = new PalindromeNumber().new Solution();

        Assertions.assertEquals(true, solution.isPalindrome(121));
        Assertions.assertEquals(false, solution.isPalindrome(01210));
        Assertions.assertEquals(false, solution.isPalindrome(1210));
        Assertions.assertEquals(false, solution.isPalindrome(01210));
        Assertions.assertEquals(true, solution.isPalindrome(3412143));
        Assertions.assertEquals(true, solution.isPalindrome(341020143));
        Assertions.assertEquals(true, solution.isPalindrome(340020043));
        Assertions.assertEquals(true, solution.isPalindrome(340000043));
        Assertions.assertEquals(true, solution.isPalindrome(40022004));
        Assertions.assertEquals(true, solution.isPalindrome(4002004));
        Assertions.assertEquals(false, solution.isPalindrome(4002204));
        Assertions.assertEquals(false, solution.isPalindrome(34102143));
        Assertions.assertEquals(false, solution.isPalindrome(-121));
        Assertions.assertEquals(false, solution.isPalindrome(10));
        Assertions.assertEquals(true, solution.isPalindrome(1));
        Assertions.assertEquals(true, solution.isPalindrome(121));
        Assertions.assertEquals(true, solution.isPalindrome(121));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || x % 10 == 0 && x != 0) {
                return false;
            }
            int revertNumber = 0;
            while (x > revertNumber) {
                revertNumber = revertNumber * 10 + x % 10;
                x /= 10;
            }
            return x == revertNumber || revertNumber / 10 == x;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

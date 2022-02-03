//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 动态规划 回溯 👍 2338 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        Solution solution = new GenerateParentheses().new Solution();
        System.out.println(Arrays.deepToString(solution.generateParenthesis(1).toArray()));
        System.out.println(Arrays.deepToString(solution.generateParenthesis(2).toArray()));
        System.out.println(Arrays.deepToString(solution.generateParenthesis(3).toArray()));
        System.out.println(Arrays.deepToString(solution.generateParenthesis(4).toArray()));
        System.out.println(Arrays.deepToString(solution.generateParenthesis(5).toArray()));
        System.out.println(Arrays.deepToString(solution.generateParenthesis(6).toArray()));
        System.out.println(Arrays.deepToString(solution.generateParenthesis(7).toArray()));
        System.out.println(Arrays.deepToString(solution.generateParenthesis(8).toArray()));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {
            return generate(n);
        }

        ArrayList[] cache = new ArrayList[9];

        private List<String> generate(int n) {
            if (cache[n] != null) {
                return cache[n];
            }
            ArrayList<String> ans = new ArrayList<>();
            if (n == 0) {
                ans.add("");
                return ans;
            } else {
                for (int i = 0; i < n; i++) {
                    for (String left : generate(i)) {
                        for (String right : generate(n - 1 - i)) {
                            ans.add("(" + left + ")" + right);
                        }
                    }
                }
            }
            cache[n] = ans;
            return cache[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

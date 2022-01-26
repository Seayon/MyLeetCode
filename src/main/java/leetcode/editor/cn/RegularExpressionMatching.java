//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//
// '.' 匹配任意单个字符
// '*' 匹配零个或多个前面的那一个元素
//
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
//
// 示例 1：
//
//
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
//
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3：
//
//
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4：
//
//
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5：
//
//
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false
//
//
//
// 提示：
//
//
// 1 <= s.length <= 20
// 1 <= p.length <= 30
// s 只含小写英文字母。
// p 只含小写英文字母，以及字符 . 和 *。
// 保证每次出现字符 * 时，前面都匹配到有效的字符
//
// Related Topics 递归 字符串 动态规划 👍 2682 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        Solution solution = new RegularExpressionMatching().new Solution();
        Assertions.assertEquals(false, solution.isMatch("aa", "a"));
        Assertions.assertEquals(true, solution.isMatch("aa", "a*"));
        Assertions.assertEquals(true, solution.isMatch("ab", ".*"));
        Assertions.assertEquals(true, solution.isMatch("aab", "c*a*b"));
        Assertions.assertEquals(false, solution.isMatch("mississippi", "mis*is*p*."));
        Assertions.assertEquals(false, solution.isMatch("aaacb", "c*a*b"));
        Assertions.assertEquals(true, solution.isMatch("mab", "c*.a*b"));
        Assertions.assertEquals(true, solution.isMatch("cmab", "c*.a*b"));
        Assertions.assertEquals(true, solution.isMatch("cab", "c*.a*b"));// 这种 需要考虑占位
        Assertions.assertEquals(true, solution.isMatch("cmab", "c*.a*b"));
        Assertions.assertEquals(true, solution.isMatch("caab", "c*.a*b"));
        Assertions.assertEquals(true, solution.isMatch("ccccab", "c*a*b"));
        Assertions.assertEquals(true, solution.isMatch("cab", "c.*a*b"));//
        Assertions.assertEquals(true, solution.isMatch("cxjoijoaiab", "c*.*a*b"));//
        Assertions.assertEquals(true, solution.isMatch("cxjoijoaiab", "c*.*a*b"));//
        Assertions.assertEquals(true, solution.isMatch("xjoijoaiab", "c*.*a*b"));//
        Assertions.assertEquals(true, solution.isMatch("ab", "c*.*a*b"));//

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            //动态递归计算
            int pe = p.length() - 1;
            String pattern = "";
            for (int i = pe; i > 0; i--) {
                char c = (char) p.indexOf(i);
                if (c == '.') {
                    if (pattern.equals(String.valueOf('*'))) {
                        return true;
                    }
                    return isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - -1));
                }
                // 如果不是 * 也不是.,那就是字母,要求当前字符串的最后一个必须匹配
                // 并且 pattern 没有存储*
                if (c != '.' && c != '*' && pattern != "*") {
                    // 如果匹配就截取继续检查剩下的字符
                    if (s.indexOf(s.length() - 1) == c) {
                        return isMatch(s.substring(0, s.length() - 1), p.substring(0, p.length() - 1));
                    } else {
                        return false;
                    }
                }
                pattern = pattern + c;
                if (c == '*') {
                    continue;
                }


            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

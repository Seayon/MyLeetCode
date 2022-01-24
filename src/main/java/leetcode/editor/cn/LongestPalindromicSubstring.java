//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划 👍 4464 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        Solution solution = new LongestPalindromicSubstring().new Solution();
        Assertions.assertEquals("bab", solution.longestPalindrome("babad"));
        Assertions.assertEquals("bbbb", solution.longestPalindrome("bbbbd"));
        Assertions.assertEquals("bb", solution.longestPalindrome("cbbd"));
        Assertions.assertEquals("a", solution.longestPalindrome("a"));
        Assertions.assertEquals("a", solution.longestPalindrome("ac"));
        // "abccdbeeeeeeeee";
        Assertions.assertEquals("eeeeeeeee", solution.longestPalindrome("abccdbeeeeeeeee"));
        Assertions.assertEquals("ac", solution.longestPalindrome("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            String result = "";
            for (int i = 0; i < chars.length; i++) {
                int left = i - 1;
                int right = i + 1;
                while (right < chars.length && chars[right] == chars[i]) {
                    right++;
                    i = right - 1;
                }
                while (left > -1 && chars[left] == chars[i]) {
                    left--;
                }
                while (left > -1 && right < chars.length && chars[left] == chars[right]) {
                    left--;
                    right++;
                }
                String tmpResultChar = new String(Arrays.copyOfRange(chars, left + 1, right));
                if (tmpResultChar.length() > result.length()) {
                    result = tmpResultChar;
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

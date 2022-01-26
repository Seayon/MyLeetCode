//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
//
//
// 示例 1：
//
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//
// 示例 2：
//
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] 仅由小写英文字母组成
//
// Related Topics 字符串 👍 1987 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
        Assertions.assertEquals("fl", solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        Assertions.assertEquals("", solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        Assertions.assertEquals("dog", solution.longestCommonPrefix(new String[]{"dog", "dog", "dog"}));
        Assertions.assertEquals("", solution.longestCommonPrefix(new String[]{""}));
        Assertions.assertEquals("dog", solution.longestCommonPrefix(new String[]{"dog"}));
        Assertions.assertEquals("d", solution.longestCommonPrefix(new String[]{"d"}));
        Assertions.assertEquals("dx", solution.longestCommonPrefix(new String[]{"dx"}));
        Assertions.assertEquals("do", solution.longestCommonPrefix(new String[]{"dog", "dox", "dog"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            Arrays.sort(strs);
            String first = strs[0];
            if (strs.length < 2) {
                return first;
            }
            String second = strs[strs.length - 1];
            return findCommonPrefix(first, second);

        }

        private String findCommonPrefix(String s1, String s2) {
            if (s1 == null || s2 == null || s1.length() == 0 || s2.length() == 0) {
                return "";
            }
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();
            int i = 0, j = 0;
            while (i < c1.length && j < c2.length) {
                if (c1[i] != c2[j]) {
                    break;
                } else {
                    i++;
                    j++;
                }
            }
            return new String(Arrays.copyOfRange(c1, 0, i));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

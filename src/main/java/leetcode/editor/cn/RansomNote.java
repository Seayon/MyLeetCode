//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
// 如果可以，返回 true ；否则返回 false 。
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//
//
// 示例 1：
//
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//
//
// 示例 2：
//
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//
//
// 示例 3：
//
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= ransomNote.length, magazine.length <= 10⁵
// ransomNote 和 magazine 由小写英文字母组成
//
// Related Topics 哈希表 字符串 计数 👍 255 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        Solution solution = new RansomNote().new Solution();
        Assertions.assertEquals(false, solution.canConstruct("a", "b"));
        Assertions.assertEquals(false, solution.canConstruct("aa", "ab"));
        Assertions.assertEquals(true, solution.canConstruct("aa", "aab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            HashMap<Character, Integer> hashMap = new HashMap<>();
            char[] chars = magazine.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                hashMap.put(chars[i], hashMap.getOrDefault(chars[i], 0) + 1);
            }
            char[] charsR = ransomNote.toCharArray();
            for (char c : charsR) {
                if (!hashMap.containsKey(c) || hashMap.get(c) == 0) {
                    return false;
                }
                hashMap.put(c, hashMap.get(c) - 1);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

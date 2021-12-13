//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 队列 哈希表 字符串 计数 👍 480 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution solution = new FirstUniqueCharacterInAString().new Solution();

        Assertions.assertEquals(0, solution.firstUniqChar("leetcode"));
        Assertions.assertEquals(2, solution.firstUniqChar("loveleetcode"));
        Assertions.assertEquals(0, solution.firstUniqChar("l"));
        Assertions.assertEquals(-1, solution.firstUniqChar("ll"));
        Assertions.assertEquals(9, solution.firstUniqChar("zzxxxyyyyu"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int firstUniqChar(String s) {
            HashMap<Character, Integer> hashMap = new HashMap<>();

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
            }
            if (hashMap.size() > 0) {
                for (int i = 0; i < chars.length; i++) {
                    if (hashMap.get(chars[i]) == 1) {
                        return i;
                    }
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

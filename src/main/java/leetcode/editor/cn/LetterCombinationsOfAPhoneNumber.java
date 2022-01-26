//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 哈希表 字符串 回溯 👍 1693 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution solution = new LetterCombinationsOfAPhoneNumber().new Solution();
        String[] a = {"ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"};
        Arrays.sort(a);
        List<String> strings = solution.letterCombinations("23");
        Assertions.assertArrayEquals(a, strings.toArray(new String[strings.size()]));

        List<String> strings2 = solution.letterCombinations("2");
        String[] a2 = {"a","b","c"};
        Assertions.assertArrayEquals(a2, strings2.toArray(new String[strings2.size()]));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public final List<String> NUMBER_2 = new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }};

        public final List<String> NUMBER_3 = new ArrayList<String>() {{
            add("d");
            add("e");
            add("f");
        }};

        public final List<String> NUMBER_4 = new ArrayList<String>() {{
            add("g");
            add("h");
            add("i");
        }};

        public final List<String> NUMBER_5 = new ArrayList<String>() {{
            add("j");
            add("k");
            add("l");
        }};

        public final List<String> NUMBER_6 = new ArrayList<String>() {{
            add("m");
            add("n");
            add("o");
        }};

        public final List<String> NUMBER_7 = new ArrayList<String>() {{
            add("p");
            add("q");
            add("r");
            add("s");
        }};

        public final List<String> NUMBER_8 = new ArrayList<String>() {{
            add("t");
            add("u");
            add("v");
        }};

        public final List<String> NUMBER_9 = new ArrayList<String>() {{
            add("w");
            add("x");
            add("y");
            add("z");
        }};

        public List<String> getStrs(char number) {
            switch (number) {
                case '2':
                    return NUMBER_2;
                case '3':
                    return NUMBER_3;
                case '4':
                    return NUMBER_4;
                case '5':
                    return NUMBER_5;
                case '6':
                    return NUMBER_6;
                case '7':
                    return NUMBER_7;
                case '8':
                    return NUMBER_8;
                case '9':
                    return NUMBER_9;
                default:
                    return null;
            }
        }

        public List<String> letterCombinations(String digits) {
            if (digits == null || digits.length() == 0) {
                return new ArrayList<>();
            }
            char[] chars = digits.toCharArray();
            List<String> result = getStrs(chars[0]);
            for (int i = 1; i < chars.length; i++) {
                result = mul(result, getStrs(chars[i]));
            }
            return result;
        }

        public List<String> mul(List<String> s1, List<String> s2) {
            if (s1 == null || s1.size() == 0) {
                return s2;
            }
            if (s1 == null || s1.size() == 0) {
                return s1;
            }
            List<String> result = new ArrayList<>(s1.size() * s2.size());
            for (String str1 : s1) {
                for (String str2 : s2) {
                    result.add(str1 + str2);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
//
// 函数 myAtoi(string s) 的算法如下：
//
//
// 读入字符串并丢弃无用的前导空格
// 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
// 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
// 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤
//2 开始）。
// 如果整数数超过 32 位有符号整数范围 [−2³¹, 231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2³¹ 的整数应该被固
//定为 −2³¹ ，大于 231 − 1 的整数应该被固定为 231 − 1 。
// 返回整数作为最终结果。
//
//
// 注意：
//
//
// 本题中的空白字符只包括空格字符 ' ' 。
// 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
//
//
//
//
// 示例 1：
//
//
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："42"（读入 "42"）
//           ^
//解析得到整数 42 。
//由于 "42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 42 。
//
// 示例 2：
//
//
//输入：s = "   -42"
//输出：-42
//解释：
//第 1 步："   -42"（读入前导空格，但忽视掉）
//            ^
//第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
//             ^
//第 3 步："   -42"（读入 "42"）
//               ^
//解析得到整数 -42 。
//由于 "-42" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 -42 。
//
//
// 示例 3：
//
//
//输入：s = "4193 with words"
//输出：4193
//解释：
//第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
//             ^
//解析得到整数 4193 。
//由于 "4193" 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 4193 。
//
//
// 示例 4：
//
//
//输入：s = "words and 987"
//输出：0
//解释：
//第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//         ^
//第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
//         ^
//解析得到整数 0 ，因为没有读入任何数字。
//由于 0 在范围 [-2³¹, 2³¹ - 1] 内，最终结果为 0 。
//
// 示例 5：
//
//
//输入：s = "-91283472332"
//输出：-2147483648
//解释：
//第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
//         ^
//第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
//          ^
//第 3 步："-91283472332"（读入 "91283472332"）
//                     ^
//解析得到整数 -91283472332 。
//由于 -91283472332 小于范围 [-2³¹, 2³¹ - 1] 的下界，最终结果被截断为 -2³¹ = -2147483648 。
//
//
//
// 提示：
//
//
// 0 <= s.length <= 200
// s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
//
// Related Topics 字符串 👍 1327 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class StringToIntegerAtoi {
    public static void main(String[] args) {
        Solution solution = new StringToIntegerAtoi().new Solution();
        Assertions.assertEquals(0, solution.myAtoi("+ 413"));
        Assertions.assertEquals(2147483647, solution.myAtoi("21474836460"));
        Assertions.assertEquals(2147483646, solution.myAtoi("2147483646"));
        Assertions.assertEquals(0, solution.myAtoi(" +0 123"));
        Assertions.assertEquals(12345678, solution.myAtoi("0000000000012345678"));
        Assertions.assertEquals(12345678, solution.myAtoi("+0000000000012345678"));
        Assertions.assertEquals(-12345678, solution.myAtoi("-0000000000012345678"));
        Assertions.assertEquals(0, solution.myAtoi("-00000+00000012345678"));
        Assertions.assertEquals(0, solution.myAtoi("+00000+00000012345678"));
        Assertions.assertEquals(0, solution.myAtoi("+00000-00000012345678"));
        Assertions.assertEquals(0, solution.myAtoi("00000000000-12345678"));
        Assertions.assertEquals(0, solution.myAtoi("00000000000+12345678"));
        Assertions.assertEquals(0, solution.myAtoi("0000000000+012345678"));
        Assertions.assertEquals(0, solution.myAtoi("0000000000-012345678"));
        Assertions.assertEquals(123, solution.myAtoi("123"));
        Assertions.assertEquals(123, solution.myAtoi("0123"));
        Assertions.assertEquals(123, solution.myAtoi("+0123"));
        Assertions.assertEquals(-123, solution.myAtoi("-0123"));
        Assertions.assertEquals(42, solution.myAtoi("42"));
        Assertions.assertEquals(-42, solution.myAtoi("   -42"));
        Assertions.assertEquals(-42, solution.myAtoi("   -42  "));
        Assertions.assertEquals(4193, solution.myAtoi("4193 with words"));
        Assertions.assertEquals(0, solution.myAtoi("words and 987"));
        Assertions.assertEquals(-2147483648, solution.myAtoi("-91283472332"));
        Assertions.assertEquals(2147483647, solution.myAtoi("91283472332"));
        Assertions.assertEquals(0, solution.myAtoi(" +-123"));
        Assertions.assertEquals(0, solution.myAtoi(" -+123"));
        Assertions.assertEquals(0, solution.myAtoi(" --123"));
        Assertions.assertEquals(0, solution.myAtoi(" ++123"));
        Assertions.assertEquals(123, solution.myAtoi(" +123"));
        Assertions.assertEquals(0, solution.myAtoi(" ++123"));
        Assertions.assertEquals(12, solution.myAtoi(" +12-3"));
        Assertions.assertEquals(-12, solution.myAtoi(" -12-3"));
        Assertions.assertEquals(-12233, solution.myAtoi(" -12233+3"));
        Assertions.assertEquals(-122333, solution.myAtoi(" -122333+"));
        Assertions.assertEquals(122333, solution.myAtoi(" +122333+"));
        Assertions.assertEquals(122333, solution.myAtoi(" +122333-"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public final String MIN_INTEGER = "2147483648";

        public final String MAX_INTEGER = "2147483647";

        public final HashMap<Character, Integer> NUMBER_MAP = new HashMap<Character, Integer>() {{
            put('0', 0);
            put('1', 1);
            put('2', 2);
            put('3', 3);
            put('4', 4);
            put('5', 5);
            put('6', 6);
            put('7', 7);
            put('8', 8);
            put('9', 9);
        }};


        public int myAtoi(String s) {
            // 先读取到合法的数字字符串
            char[] chars = s.toCharArray();
            StringBuffer sb = new StringBuffer("");
            // 是否已经有数字记录(有了话后面就不能再出现非法字符了)
            boolean hasNum = false;
            //  是否已经出现过 0
            boolean hasNumZero = false;
            // 正负号是否已经确定,已经确定的话,后面不能再出现正负号了
            boolean hasPN = false;
            // 最终的正负号,默认为 false 正数
            boolean negative = false;
            for (int i = 0; i < chars.length; i++) {
                char current = chars[i];
                //第一步
                if (' ' == current) {
                    if (!hasNum && !hasNumZero && !hasPN) {
                        continue;
                    } else {
                        break;
                    }
                }
                //第二步
                if (current == '-' || current == '+') {
                    // 如果还有没数字,且正负号还没确定,就用这个
                    if (!hasNum && !hasNumZero && !hasPN) {
                        negative = current == '-' ? true : false;
                        hasPN = true;
                        continue;
                    } else {
                        //否则的话说明这个正负号出现在了不该出现的后面,不再往后看
                        break;
                    }
                }
                //经过上一步的确定正负号,即便上一步没有确认(可能没有出现+号),那么到下一步也假定为就是+号,已经有了正负号
                hasPN = true;
                //第三步
                if (!NUMBER_MAP.containsKey(current) && hasPN) {
                    break;
                }
                if (NUMBER_MAP.containsKey(current)) {
                    if (current != '0') {
                        sb.append(current);
                        hasNum = true;
                    }
                    if (current == '0' && hasNum) {
                        sb.append(current);
                    }
                    if (current == '0') {
                        hasNumZero = true;
                    }
                }
            }
            //比较字符串大小
            //-91283472332
            // -2147483648
            //如果是负数
            String finalResult = new String(sb);
            if (negative) {
                //去跟负数的最小值比较一下
                if (finalResult.length() > MIN_INTEGER.length() || (finalResult.length() == MIN_INTEGER.length() && finalResult.compareTo(MIN_INTEGER) > 0)) {
                    return Integer.MIN_VALUE;
                }
            } else {
                //去跟正数的最大值比较一下
                if (finalResult.length() > MAX_INTEGER.length() || (finalResult.length() == MAX_INTEGER.length()) && finalResult.compareTo(MAX_INTEGER) > 0) {
                    return Integer.MAX_VALUE;
                }
            }
            char[] resultChars = finalResult.toCharArray();
            int r = 0;
            for (int i = resultChars.length - 1, k = 1; i >= 0; i--, k *= 10) {
                r = r + k * NUMBER_MAP.get(resultChars[i]);
            }
            return negative ? -r : r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
//
//
// 示例 1：
//
//
//输入：s = "()"
//输出：true
//
//
// 示例 2：
//
//
//输入：s = "()[]{}"
//输出：true
//
//
// 示例 3：
//
//
//输入：s = "(]"
//输出：false
//
//
// 示例 4：
//
//
//输入：s = "([)]"
//输出：false
//
//
// 示例 5：
//
//
//输入：s = "{[]}"
//输出：true
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁴
// s 仅由括号 '()[]{}' 组成
//
// Related Topics 栈 字符串 👍 2826 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution = new ValidParentheses().new Solution();
        Assertions.assertEquals(false, solution.isValid("(("));
        Assertions.assertEquals(false, solution.isValid("}}"));
        Assertions.assertEquals(true, solution.isValid("()"));
        Assertions.assertEquals(false, solution.isValid("()}}"));
        Assertions.assertEquals(false, solution.isValid("()}}}}"));
        Assertions.assertEquals(false, solution.isValid("()}}}"));
        Assertions.assertEquals(true, solution.isValid("()[]{}"));
        Assertions.assertEquals(false, solution.isValid("()[]{"));
        Assertions.assertEquals(false, solution.isValid("(){"));
        Assertions.assertEquals(false, solution.isValid("("));
        Assertions.assertEquals(false, solution.isValid("{"));
        Assertions.assertEquals(false, solution.isValid("["));
        Assertions.assertEquals(false, solution.isValid("]"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isValid(String s) {
            char[] chars = s.toCharArray();
            // char[] right = new char[]{')', '}', ']'};
            HashMap<Character, Character> right = new HashMap<Character, Character>() {{
                put('}', '{');
                put(')', '(');
                put(']', '[');
            }};
            Stack<Character> stack = new Stack<>();
            for (char aChar : chars) {
                if (!right.containsKey(aChar)) {
                    stack.push(aChar);
                } else {
                    // 如果栈为空, 或者从栈拿出来的数据跟当前循环到的地方无法匹配成括号,就是失败的
                    if (stack.empty() || stack.peek() == null || !right.get(aChar).equals(stack.pop())) {
                        return false;
                    }
                }
            }
            return stack.empty();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

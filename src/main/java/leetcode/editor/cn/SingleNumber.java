//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明：
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
// 示例 1:
//
// 输入: [2,2,1]
//输出: 1
//
//
// 示例 2:
//
// 输入: [4,1,2,1,2]
//输出: 4
// Related Topics 位运算 数组 👍 2143 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new SingleNumber().new Solution();

        Assertions.assertEquals(1,solution.singleNumber(new int[]{2,2,1}));
        Assertions.assertEquals(4,solution.singleNumber(new int[]{4,1,2,1,2}));
        Assertions.assertEquals(4,solution.singleNumber(new int[]{4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int singleNumber(int[] nums) {
            HashSet<Integer> hashSet = new LinkedHashSet<>();
            for (int num : nums) {
                if (hashSet.contains(num)) {
                    hashSet.remove(num);
                } else {
                    hashSet.add(num);
                }
            }
            return hashSet.iterator().next();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

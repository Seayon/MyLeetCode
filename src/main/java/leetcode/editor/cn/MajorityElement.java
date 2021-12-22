//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1：
//
//
//输入：[3,2,3]
//输出：3
//
// 示例 2：
//
//
//输入：[2,2,1,1,1,2,2]
//输出：2
//
//
//
//
// 进阶：
//
//
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 1243 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        Assertions.assertEquals(3, solution.majorityElement(new int[]{3, 2, 3}));
        Assertions.assertEquals(2, solution.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    int value = map.get(num) + 1;
                    if (value > nums.length / 2) {
                        return num;
                    }
                    map.put(num, value);
                } else {
                    map.put(num, 1);
                }
            }
            return nums[0];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

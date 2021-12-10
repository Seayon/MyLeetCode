//给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现
//次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
//
//
// 示例 2:
//
//
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9]
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
//
//
//
//
// 进阶：
//
//
// 如果给定的数组已经排好序呢？你将如何优化你的算法？
// 如果 nums1 的大小比 nums2 小，哪种方法更优？
// 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
//
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 606 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysIi {
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArraysIi().new Solution();
        Assertions.assertArrayEquals(new int[]{9, 4}, solution.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
        Assertions.assertArrayEquals(new int[]{2,2}, solution.intersect(new int[]{1,2,2,1}, new int[]{2,2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] intersect(int[] nums1, int[] nums2) {
            // 定义一个动态的 List 来存储结果集
            List<Integer> integerList = new ArrayList<>();
            // 先把 nums1 保存到 map 中,记录没一个元素出现的次数
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums1.length; i++) {
                // 如果已经存过了,就把记录数加 1
                if (map.containsKey(nums1[i])) {
                    map.put(nums1[i], map.get(nums1[i]) + 1);
                    continue;
                }
                // 否则就记录出现一次
                map.put(nums1[i], 1);
            }
            //对 num2 进行遍历,查看是否在里面出现过
            for (int i : nums2) {
                // 如果包含,且 对应的 次数还不为 0,有的用,就加入到结果集中
                if (map.containsKey(i) && map.get(i) > 0) {
                    integerList.add(i);
                    //    将可用的记录数减 1
                    map.put(i, map.get(i) - 1);
                }
            }
            int result[] = new int[integerList.size()];
            for (int i = 0; i < integerList.size(); i++) {
                result[i] = integerList.get(i);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

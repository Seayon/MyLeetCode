//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
// 示例 3：
//
//
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
//
//
// 示例 4：
//
//
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
//
//
// 示例 5：
//
//
//输入：nums1 = [2], nums2 = []
//输出：2.00000
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -10⁶ <= nums1[i], nums2[i] <= 10⁶
//
// Related Topics 数组 二分查找 分治 👍 4910 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new MedianOfTwoSortedArrays().new Solution();
        Assertions.assertEquals(2d, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        Assertions.assertEquals(2.5d, solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        Assertions.assertEquals(0d, solution.findMedianSortedArrays(new int[]{0, 0}, new int[]{0}));
        Assertions.assertEquals(1, solution.findMedianSortedArrays(new int[]{}, new int[]{1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int[] tmp = new int[nums1.length + nums2.length];

            int i = 0, j = 0, k = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    tmp[k++] = nums1[i++];
                } else {
                    tmp[k++] = nums2[j++];
                }
            }
            while (i < nums1.length) {
                tmp[k++] = nums1[i++];
            }
            while (j < nums2.length) {
                tmp[k++] = nums2[j++];
            }
            if (tmp.length % 2 == 0) {
                return (double) (tmp[tmp.length / 2 - 1] + tmp[tmp.length / 2]) / 2;
            }
            return tmp[tmp.length / 2];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
//
// 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
//
// 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并
//的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
//解释：需要合并 [1,2,3] 和 [2,5,6] 。
//合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
//
//
// 示例 2：
//
//
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
//解释：需要合并 [1] 和 [] 。
//合并结果是 [1] 。
//
//
// 示例 3：
//
//
//输入：nums1 = [0], m = 0, nums2 = [1], n = 1
//输出：[1]
//解释：需要合并的数组是 [] 和 [1] 。
//合并结果是 [1] 。
//注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
//
//
//
//
// 提示：
//
//
// nums1.length == m + n
// nums2.length == n
// 0 <= m, n <= 200
// 1 <= m + n <= 200
// -10⁹ <= nums1[i], nums2[j] <= 10⁹
//
//
//
//
// 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
// Related Topics 数组 双指针 排序 👍 1210 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        //case 0
        int[] ints0 = {1, 2, 3, 0, 0, 0};
        solution.merge(ints0, 3, new int[]{2, 5, 6}, 3);
        Assertions.assertArrayEquals(new int[]{1, 2, 2, 3, 5, 6}, ints0);


        //case1.5
        int[] ints1_5 = new int[]{0, 1, 0};
        solution.merge(ints1_5, 2, new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{0, 1, 1}, ints1_5);

        //case1
        int[] ints1 = new int[]{0, 1};
        solution.merge(ints1, 2, new int[]{}, 0);
        Assertions.assertArrayEquals(new int[]{0, 1}, ints1);


        //case2
        int[] ints2 = new int[]{1};
        solution.merge(ints2, 1, new int[]{}, 0);
        Assertions.assertArrayEquals(new int[]{1}, ints2);

        //case3
        int[] ints3 = new int[]{0};
        solution.merge(ints3, 0, new int[]{1}, 1);
        Assertions.assertArrayEquals(new int[]{1}, ints3);

        //case4
        int[] ints4 = new int[]{4, 0, 0, 0, 0, 0};
        solution.merge(ints4, 1, new int[]{1, 2, 3, 5, 6}, 5);
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, ints4);


    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (m == 0) {
                for (int i = 0; i < nums2.length; i++) {
                    nums1[i] = nums2[i];
                }
                return;
            }
            if (n == 0) {
                return;
            }
            int result[] = new int[m + n];
            int i = 0, j = 0, r = 0;
            for (; i < m && j < n; r++) {
                if (nums1[i] < nums2[j]) {
                    result[r] = nums1[i];
                    i++;
                    continue;
                }
                if (nums1[i] > nums2[j]) {
                    result[r] = nums2[j];
                    j++;
                    continue;
                }
                if (nums1[i] == nums2[j]) {
                    result[r] = nums1[i];
                    result[++r] = nums2[j];
                    i++;
                    j++;
                    continue;
                }
            }
            if (i < m) {
                for (int k = i; k < m; k++, r++) {
                    result[r] = nums1[k];
                }
            }
            if (j < n) {
                for (int k = j; k < n; k++, r++) {
                    result[r] = nums2[k];
                }
            }
            for (int k = 0; k < result.length; k++) {
                nums1[k] = result[k];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

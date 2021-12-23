//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//
// 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
//
//
// 示例 2：
//
//
//输入：nums = [2,0,1]
//输出：[0,1,2]
//
//
// 示例 3：
//
//
//输入：nums = [0]
//输出：[0]
//
//
// 示例 4：
//
//
//输入：nums = [1]
//输出：[1]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 300
// nums[i] 为 0、1 或 2
//
//
//
//
// 进阶：
//
//
// 你可以不使用代码库中的排序函数来解决这道题吗？
// 你能想出一个仅使用常数空间的一趟扫描算法吗？
//
// Related Topics 数组 双指针 排序 👍 1113 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

/**
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 * <p>
 * 输入：nums = [1]
 * 输出：[1]
 */
public class SortColors {
    public static void main(String[] args) {
        Solution solution = new SortColors().new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        solution.sortColors(nums);
        Assertions.assertArrayEquals(new int[]{0, 0, 1, 1, 2, 2}, nums);

        int[] nums1 = {2, 0, 1};
        solution.sortColors(nums1);
        Assertions.assertArrayEquals(new int[]{0,1,2}, nums1);

        int[] nums2 = {0};
        solution.sortColors(nums2);
        Assertions.assertArrayEquals(new int[]{0}, nums2);

        int[] nums0 = {1};
        solution.sortColors(nums0);
        Assertions.assertArrayEquals(new int[]{1}, nums0);






    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void sortColors(int[] nums) {
            //第一次遍历,将数组所有的 0 都交换到头部
            int ptr0 = 0;
            int ptr1 = 0;
            for (int i = 0; i < nums.length; i++) {
                int current = nums[i];
                if (current == 0) {
                    //    检查 tmp0 往后换的过程中,是否存在 ptr1 在其后面,如果在的话,换 ptr1 的位置,让 ptr1 去填补本来 tmp0 要去的位置
                    if (ptr0 < ptr1) {
                        nums[i] = nums[ptr1];
                        nums[ptr1] = nums[ptr0];
                        nums[ptr0] = current;
                    } else {
                        nums[i] = nums[ptr0];
                        nums[ptr0] = current;
                    }
                    ptr1++;
                    ptr0++;
                }
                if (current == 1) {
                    nums[i] = nums[ptr1];
                    nums[ptr1] = current;
                    ptr1++;
                }

            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i,
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
//
// 说明：你不能倾斜容器。
//
//
//
// 示例 1：
//
//
//
//
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
//
// 示例 2：
//
//
//输入：height = [1,1]
//输出：1
//
//
// 示例 3：
//
//
//输入：height = [4,3,2,1,4]
//输出：16
//
//
// 示例 4：
//
//
//输入：height = [1,2,1]
//输出：2
//
//
//
//
// 提示：
//
//
// n == height.length
// 2 <= n <= 10⁵
// 0 <= height[i] <= 10⁴
//
// Related Topics 贪心 数组 双指针 👍 3144 👎 0


package leetcode.editor.cn;

import org.junit.jupiter.api.Assertions;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution solution = new ContainerWithMostWater().new Solution();
        Assertions.assertEquals(70, solution.maxArea(new int[]{0, 14, 6, 2, 10, 9, 4, 1, 10, 3}));
        Assertions.assertEquals(49, solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        Assertions.assertEquals(1, solution.maxArea(new int[]{1, 1}));
        Assertions.assertEquals(16, solution.maxArea(new int[]{4, 3, 2, 1, 4}));
        Assertions.assertEquals(2, solution.maxArea(new int[]{1, 2, 1}));
        Assertions.assertEquals(1, solution.maxArea(new int[]{1, 2}));
        Assertions.assertEquals(0, solution.maxArea(new int[]{0, 2}));
        Assertions.assertEquals(0, solution.maxArea(new int[]{0, 0}));
        Assertions.assertEquals(0, solution.maxArea(new int[]{1, 0}));
        Assertions.assertEquals(0, solution.maxArea(new int[]{2, 0}));
        Assertions.assertEquals(2, solution.maxArea(new int[]{2, 0, 1}));
        Assertions.assertEquals(3, solution.maxArea(new int[]{2, 0, 0, 1}));
        Assertions.assertEquals(6, solution.maxArea(new int[]{2, 0, 0, 3}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxArea(int[] height) {
            int max = 0;
            for (int i = 0; i < height.length; i++) {
                if (height[i] == 0) {
                    continue;
                }
                int j = max / height[i] + 1;
                while (j < height.length) {
                    int currentCapacity = Math.min(height[i], height[j]) * (j - i);
                    if (currentCapacity > max) {
                        max = currentCapacity;
                    }
                    int jt = max / height[i] + 1;
                    if (jt > j++) {
                        j = jt;
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

```java
/**
 * 这种解法,之前考虑到结果得放在 nums1 中,将 nums1 指向了 result 结果不行,看别的答案可以进行遍历
 * 将 result 的结果给 nums1,在此基础上又完善了这个算法的各种边界条件写了个
 */

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

//leetcode submit region end(Prohibit modification and deletion)

}

```

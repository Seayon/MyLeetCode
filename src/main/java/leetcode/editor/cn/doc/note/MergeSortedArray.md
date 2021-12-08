```java
/**
 * 这种解法实在不行
 */


package leetcode.editor.cn;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
        int[] ints = {1, 2, 3, 0, 0, 0};
        solution.merge(ints, 3, new int[]{2, 5, 6}, 3);
        System.out.println(Arrays.toString(ints));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
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
            if (i < j) {
                for (int k = i; k < m; k++, r++) {
                    result[r] = nums1[k];
                }
            }
            if (j < i) {
                for (int k = j; k < n; k++, r++) {
                    result[r] = nums2[k];
                }
            }
            nums1 = result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

```

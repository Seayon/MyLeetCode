package com.seayon.myleetcode.i;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.i
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/10/21 12:10 上午
 * @Version V1.0
 * @Description:
 */
@DisplayName("删除排序数组中的重复项")
public class RemoveDuplicates {

//    i = 1
//    0,1,1,2,4 = >0,1,2,2,4

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(4, solution.removeDuplicates(new int[]{0, 1, 1, 2, 4}));
        assertEquals(4, solution.removeDuplicates(new int[]{0, 1, 2, 4}));
        assertEquals(5, solution.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
        assertEquals(2, solution.removeDuplicates(new int[]{1, 1, 2}));
        assertEquals(0, solution.removeDuplicates(new int[]{}));
        assertEquals(4, solution.removeDuplicates(new int[]{0, 0, 0, 0, 0, 1, 2, 3}));
        assertEquals(4, solution.removeDuplicates(new int[]{0, 1, 2, 3, 3, 3, 3, 3}));
        assertEquals(4, solution.removeDuplicates(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 2, 3}));
        assertEquals(4, solution.removeDuplicates(new int[]{0, 0, 0, 0, 0, 1, 1, 1, 2, 3, 3, 3, 3, 3}));
        assertEquals(5, solution.removeDuplicates(new int[]{-1, 0, 0, 0, 0, 1, 2, 3}));
        assertEquals(5, solution.removeDuplicates(new int[]{-1, -1, 0, 0, 0, 0, 1, 2, 3}));
        assertEquals(6, solution.removeDuplicates(new int[]{-2, -1, -1, 0, 0, 0, 0, 1, 2, 3}));
        assertEquals(7, solution.removeDuplicates(new int[]{-3, -3, -3, -2, -1, -1, 0, 0, 0, 0, 1, 2, 3}));
//        {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
//        {0, 1, 1, 1, 1, 2, 2, 3, 3, 4}
//        {0, 1, 2, 1, 1, 2, 2, 3, 3, 4}
//        {0, 1, 2, 3, 1, 2, 2, 3, 3, 4}
//        {0, 1, 2, 3, 4, 2, 2, 3, 3, 4}
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int r = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[r] != nums[i]) {
                    r++;
                    nums[r] = nums[i];
                }
            }
            return r+1;
        }
        public int removeDuplicatesMy(int[] nums) {
            int startJ = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] >= nums[i + 1]) {
                    for (int j = Math.max(i + 1, startJ); j < nums.length; j++) {
                        startJ = j;
                        if (nums[j] > nums[i]) {
                            nums[i + 1] = nums[j];
                            break;
                        }
                        if (j == nums.length - 1) {
                            return i + 1;
                        }
                    }
                }
            }
            return nums.length;
        }
    }
}

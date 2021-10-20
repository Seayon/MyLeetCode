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
//        {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}
//        {0, 1, 1, 1, 1, 2, 2, 3, 3, 4}
//        {0, 1, 2, 1, 1, 2, 2, 3, 3, 4}
//        {0, 1, 2, 3, 1, 2, 2, 3, 3, 4}
//        {0, 1, 2, 3, 4, 2, 2, 3, 3, 4}
    }

    class Solution {
        public int removeDuplicates(int[] nums) {
            int duplicateIndex = nums.length;
            boolean skip = false;
            for (int i = 0; i < nums.length - 1; i++) {
                if (skip) break;
                if (nums[i + 1] > nums[i + 1]) {
//                    i++;
                    continue;
                } else {
                    duplicateIndex = i + 1;
                    for (int j = duplicateIndex + 1; j < nums.length; j++) {
                        if (nums[j] > nums[duplicateIndex - 1]) {
                            nums[duplicateIndex] = nums[j];
//                            i++;
                            if (j == nums.length - 1) {
                                skip = true;
                            }
                            break;
                        }
                    }
                }

            }
            return duplicateIndex + 1;
        }
    }
}

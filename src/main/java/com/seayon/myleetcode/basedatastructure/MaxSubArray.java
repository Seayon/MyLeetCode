package com.seayon.myleetcode.basedatastructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.basedatastructure
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/10/20 3:32 下午
 * @Version V1.0
 * @Description: // 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * // 输出：6
 * // 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * [1,-1,1,2,3] = [1,2,3]
 * [-3,-2,-1,1,2,3] = [1,2,3]
 * [-3,2,-1,4,5,-1] = [2,-1,4,5]
 * [-3,2,-1,-2,3,4,-1,-2] = [3,4]
 * [-3,2,-1,-2,3,4,-1,-2,5,-4,-1] = [3,4]
 * [-3,-2,-1] = [-1]
 * [-5,-4,-3,] = [-1]
 * [-5,-4,-3,7,1,-20,2,4,6,6,6,6,6] = [-1]
 */

@DisplayName("53. 最大子序和")
public class MaxSubArray {

    @Test
    public void test1() {
        Solution solution = new Solution();
        assertEquals(-1, solution.maxSubArray(new int[]{-2, -1}));
        assertEquals(6, solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(6, solution.maxSubArray(new int[]{1, -1, 1, 2, 3}));
        assertEquals(6, solution.maxSubArray(new int[]{-3, -2, -1, 1, 2, 3}));
        assertEquals(10, solution.maxSubArray(new int[]{-3, 2, -1, 4, 5, -1}));
        assertEquals(7, solution.maxSubArray(new int[]{-3, 2, -1, -2, 3, 4, -1, -2}));
        assertEquals(9, solution.maxSubArray(new int[]{-3, 2, -1, -2, 3, 4, -1, -2, 5, -4, -1}));
        assertEquals(1, solution.maxSubArray(new int[]{1}));
        assertEquals(0, solution.maxSubArray(new int[]{0}));
        assertEquals(-1, solution.maxSubArray(new int[]{-1}));
        assertEquals(-1000, solution.maxSubArray(new int[]{-1000}));
        assertEquals(1001, solution.maxSubArray(new int[]{1,2,3,-100,1000,1}));
    }

    class Solution {
        //动态规划
        public int maxSubArray(int[] nums) {
            int pre = 0, maxAns = nums[0];
            for (int x : nums) {
                pre = Math.max(pre + x, x);
                maxAns = Math.max(maxAns, pre);
            }
            return maxAns;
        }
        //贪心算法
        public int maxSubArrayWy(int[] nums) {
            //其实是找最大的和,不是找数组的范围
            int res = nums[0];
            int sum = 0;
            //找出第一个正数,如果没有找到其实是找了最大的非正数,因为如果没有正数,那么最大和肯定是某个最大的负数或者 0,只需要找到负数中的最大值即可
            //如果找到了正数,继续往下加,加好了,再加的过程中跟已经记录的最大值相比较,如果大于就记录下来,直到加的值不为正数,这时候重新确定和的起始值
            /** 网友 @神韵烟火
             * 对于含有正数的序列而言,最大子序列肯定是正数,所以头尾肯定都是正数.
             * 我们可以从第一个正数开始算起,每往后加一个数便更新一次和的最大值;
             * 当当前和成为负数时,则表明此前序列无法为后面提供最大子序列和,因此必须重新确定序列首项.
             */
            for (int num : nums) {
                if (sum > 0) {
                    sum += num;
                } else {
                    sum = num;
                }
                res = Math.max(res,sum);
            }
            return res;
        }



        public int maxSubArrayOld(int[] nums) {
            int end = nums.length;
            int result = nums[0];
            for (int i = nums.length - 1; i >= 0; i--) {
                //计算出来两者范围之间的值的和
                int sumInRange = 0;
                for (int j = 0; j <= i; j++) {
                    sumInRange += nums[j];
                }
                int afterK = sumInRange;
                //尝试开始从第一个值去掉,看值会不会变得更大,会的话就存储下这个最大值
                for (int k = 0; k < i; k++) {
                    //将计算出来范围值依次减掉首个值
                    afterK = afterK - nums[k];
                    if (afterK > sumInRange) {
                        sumInRange = afterK;
                    }
                }
                if (sumInRange > result) {
                    result = sumInRange;
                }
            }
            return result;
        }

        public int maxSubArray2(int[] nums) {

            int maxNumberIndex = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > nums[maxNumberIndex]) {
                    maxNumberIndex = i;
                }
            }


            int end = 0;
            int sumBeforeI = nums[end];
            int sumBeforeEnd = nums[end];
            for (int i = maxNumberIndex; i < nums.length; i++) {
                sumBeforeI = sumBeforeI + nums[i];
                if (sumBeforeI > sumBeforeEnd) {
                    sumBeforeEnd = sumBeforeI;
                    end = i;
                }
            }
            int finalEnd = sumBeforeEnd;
            int sumAfterI = sumBeforeEnd;
            for (int i = 0; i < maxNumberIndex - 1; i++) {
                sumAfterI = sumAfterI - nums[i];
                if (sumAfterI > sumBeforeEnd) {
                    sumBeforeEnd = sumAfterI;
                }
            }
            return sumBeforeEnd - nums[maxNumberIndex] + finalEnd;
        }

        public int[] maxSubArrayArray(int[] nums) {
            int start = 0;
            int end = 0;
            int sum = nums[start] + nums[end];
            int sumBeforeEnd = 0;
            int sumBeforeI = 0;
            for (int i = 1; i < nums.length; i++) {
                sumBeforeI += nums[i - 1];
                //前 i 个值(不包含第 i 个)的总和,i必须小于 end 的值
                if (i - 1 <= end) {
                    sumBeforeEnd = sumBeforeEnd + nums[i - 1];
                }
                //如果结尾位置的数字带来收益可以使前 end 个值的总和变大,就把 end 往后移动
                if (nums[i] + sumBeforeEnd > sumBeforeI) {
                    end = i;
                    sumBeforeEnd = sumBeforeI;
                }
            }
            //从 nums[start] 到 nums[end] 标志结束的所有数的和,包含前后边界
            int sumBetweenStartAndEnd = nums[end];
            //从 End 结束位置往回找最大的起始位置
            for (int j = end - 1; j >= 0; j--) {
                if (nums[j] + sumBetweenStartAndEnd > sumBetweenStartAndEnd) {
                    start = j;
                }
            }
            return Arrays.copyOfRange(nums, start, end);
        }
    }
}

package com.seayon.myleetcode.sort;

import java.util.Arrays;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/20 10:33 下午
 * @Version V1.0
 * @Description: 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数。
 */
public class CountingSort implements MySort {
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int max = array[0];
        // get max and min number
        for (int i : array) {
            if (i > max) {
                max = i;
            }
        }

        int[] tmp = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            tmp[array[i]]++;
        }

        int[] result = new int[array.length];
        int j = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (tmp[i] != 0) {
                result[j++] = i;
                tmp[i]--;
            }
        }

        return result;
    }
}

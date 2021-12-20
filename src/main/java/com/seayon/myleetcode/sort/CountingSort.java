package com.seayon.myleetcode.sort;

import java.util.Arrays;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/20 10:33 下午
 * @Version V1.0
 * @Description:
 */
public class CountingSort implements MySort {
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        int max = array[0];
        // get max number
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }

        int[] tmp = new int[max + 1];
        for (int i = 0; i < array.length; i++) {
            tmp[array[i]]++;
        }

        int[] result = new int[array.length];
        for (int i = 0, j = 0; i < result.length; ) {
            if (tmp[j] > 0) {
                result[i] = j;
                tmp[j]--;
                i++;
            } else {
                j++;
            }
        }

        return result;
    }
}

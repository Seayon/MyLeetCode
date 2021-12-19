package com.seayon.myleetcode.sort;

import java.util.Arrays;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/19 4:58 下午
 * @Version V1.0
 * @Description:
 */
public class MergeSort implements MySort {
    @Override
    public int[] sort(int[] array) {
        if (array.length < 2) {
            return array;
        }
        int middle = array.length / 2;
        int[] a = Arrays.copyOfRange(array, 0, middle);
        int[] b = Arrays.copyOfRange(array, middle, array.length);
        return merge(sort(a), sort(b));
    }

    public int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0;
        // 其实这个就是合并两个有序数组
        while (a.length > 0 && b.length > 0) {
            if (a[0] > b[0]) {
                result[i++] = b[0];
                b = Arrays.copyOfRange(b, 1, b.length);
            } else {
                result[i++] = a[0];
                a = Arrays.copyOfRange(a, 1, a.length);
            }
        }
        while (a.length > 0) {
            result[i++] = a[0];
            a = Arrays.copyOfRange(a, 1, a.length);
        }
        while (b.length > 0) {
            result[i++] = b[0];
            b = Arrays.copyOfRange(b, 1, b.length);
        }
        return result;
    }
}

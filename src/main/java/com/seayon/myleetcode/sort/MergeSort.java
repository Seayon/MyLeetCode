package com.seayon.myleetcode.sort;

import java.util.Arrays;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/19 4:58 下午
 * @Version V1.0
 * @Description: 归并排序
 */
public class MergeSort implements MySort {
    @Override
    public int[] sort(int[] array) {
        //递归基,拆分到 2 个不再拆分
        if (array.length < 2) {
            return array;
        }
        int[] a = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] b = Arrays.copyOfRange(array, array.length / 2, array.length);
        int[] merge = merge(sort(a), sort(b));
        return merge;
    }

    public int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, r = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[r++] = a[i++];
            } else {
                result[r++] = b[j++];
            }
        }
        while (i < a.length) {
            result[r++] = a[i++];
        }
        while (j < b.length) {
            result[r++] = b[j++];
        }
        return result;
    }

}

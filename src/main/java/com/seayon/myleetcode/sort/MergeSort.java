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
        //递归基,拆分到 2 个不再拆分
        if (array.length < 2) {
            return array;
        }
        int[] a = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] b = Arrays.copyOfRange(array, array.length / 2, array.length);
        return merge(sort(a), sort(b));
    }

    public int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int resultIndex = 0;
        int ai = 0, bi = 0;
        while (ai < a.length && bi < b.length) {
            if (a[ai] < b[bi]) {
                result[resultIndex++] = a[ai++];
            } else {
                result[resultIndex++] = b[bi++];
            }
        }
        //将剩余的拼进去
        while (ai < a.length) {
            result[resultIndex++] = a[ai++];
        }
        while (bi < b.length) {
            result[resultIndex++] = b[bi++];
        }
        return result;
    }

}

package com.seayon.myleetcode.sort;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyleft 2013-3102
 * @Author: SaeyonZhao
 * @Date: 2021/12/20 5:48 下午
 * @Version V1.0
 * @Description:
 */

public class QuickSort implements MySort {
    @Override
    public int[] sort(int[] array) {
        if (array == null) {
            return null;
        }
        return quickSort(array, 0, array.length - 1);
    }

    public int[] quickSort(int[] array, int start, int end) {
        if (end > start) {
            int p = array[start];
            int lo = start;
            int hi = end;
            while (lo != hi) {
                while (hi > lo && array[hi] >= p) {
                    hi--;
                }
                array[lo] = array[hi];
                while (lo < hi && array[lo] <= p) {
                    lo++;
                }
                array[hi] = array[lo];
            }
            array[lo] = p;
            quickSort(array, start, lo);
            quickSort(array, lo + 1, end);
        }
        return array;
    }
}

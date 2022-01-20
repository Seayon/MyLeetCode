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

    private int[] quickSort(int[] array, int start, int end) {
        if (end > start) {
            //假定起始的第一个值就是 pivot 参考值,备份第一个值
            int pivot = array[start];
            int lo = start;
            int hi = end;
            while (lo != hi) {
                while (lo < hi && array[hi] >= pivot) {
                    hi--;
                }
                array[lo] = array[hi];
                while (lo < hi && array[lo] <= pivot) {
                    lo++;
                }
                array[hi] = array[lo];
            }
            array[lo] = pivot;
            quickSort(array, start, lo);
            quickSort(array, lo + 1, end);
        }
        return array;
    }


}

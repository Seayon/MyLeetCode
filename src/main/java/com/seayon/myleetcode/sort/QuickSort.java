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
        int pivot = array[0];
        for (int j = 0, i = array.length; j < i; j++, i--) {
            if (array[i] < pivot) {
                swap(array, i, j);
                pivot = array[i];
            }
            if (array[j] > pivot) {
                swap(array, j, i);
            }
        }
        return new int[0];
    }
}

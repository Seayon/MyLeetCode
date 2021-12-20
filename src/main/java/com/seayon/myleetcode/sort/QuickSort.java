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

    private int[] quickSort(int[] array, int leftStart, int rightEnd) {
        if (leftStart < rightEnd) {
            int pivot = array[leftStart];
            int i = leftStart;
            int j = rightEnd;
            while (i < j) {
                while (i < j && array[j] >= pivot) {
                    j--;
                }
                if (i < j) {
                    swap(array, i, j);
                    i++;
                }
                while (i < j && array[i] <= pivot) {
                    i++;
                }
                if (i < j) {
                    swap(array, i, j);
                    j--;
                }
            }
            quickSort(array, leftStart, i - 1);
            quickSort(array, i + 1, rightEnd);
        }
        return array;
    }

}

package com.seayon.myleetcode.sort;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/18 11:44 下午
 * @Version V1.0
 * @Description: 选择排序
 */
public class SelectSort implements MySort {

    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[minIndex] > array[j]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
        }
        return array;
    }
}

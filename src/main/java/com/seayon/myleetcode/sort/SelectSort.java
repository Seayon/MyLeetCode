package com.seayon.myleetcode.sort;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/18 11:44 下午
 * @Version V1.0
 * @Description:
 */
public class SelectSort implements MySort {

    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        for (int j = array.length - 1; j > 0; j--) {
            // 假定第一个位置的数最大
            int maxIndex = 0;
            for (int i = 0; i < j + 1; i++) {
                if (array[i] > array[maxIndex]) {
                    maxIndex = i;
                }
            }
            int tmp = array[j];
            array[j] = array[maxIndex];
            array[maxIndex] = tmp;
        }
        return array;
    }
}

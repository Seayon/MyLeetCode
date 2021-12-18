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
        for (int j = 0; j < array.length - 1; j++) {
            int minIndex = j;
            for (int i = j + 1; i < array.length; i++) {
                if (array[i] < array[minIndex]) {
                    minIndex = i;
                }
            }
            int tmp = array[j];
            array[j] = array[minIndex];
            array[minIndex] = tmp;
        }
        return array;
    }

}

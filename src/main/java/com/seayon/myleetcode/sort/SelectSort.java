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
        for (int i = 0; i < array.length; i++) {
            // 每次遍历,从剩下的序列中找到最小元素,放在前面序列的末尾
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

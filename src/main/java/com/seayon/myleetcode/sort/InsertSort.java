package com.seayon.myleetcode.sort;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/19 12:54 上午
 * @Version V1.0
 * @Description:
 */
public class InsertSort implements MySort {
    @Override
    public int[] sort(int[] array) {

        // 从下标为 1 开始进行操作,因为下标为 0 的不需要进行操作
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;

            while (j > 0 && current < array[j - 1]) {
                // 就将这个位置的值往后移动
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;

        }
        return array;
    }
}

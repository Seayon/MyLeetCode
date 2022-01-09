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
        //插入排序,起始位置为 1,因为第一个可以认为已经排序好
        for (int i = 1; i < array.length; i++) {
            //如果当前的这个值,比前一个值要小,说明当前这个值要拿出来,去往前面的序列中插入
            if (array[i] < array[i - 1]) {
                //暂存当前这个值
                int current = array[i];
                //    从当前位置,一直往前看,不小于当前值的,都依次往后移动
                int j = i;
                while (j > 0 && current < array[j - 1]) {
                    array[j] = array[j - 1];
                    j--;
                }
                array[j] = current;
            }
        }
        return array;
    }
}

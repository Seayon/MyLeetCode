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
            int j = i;
            //暂存 j 位置的值为当前值
            int current = array[j];
            //一直往前找,如果当前 j 位置的值小于 j-1 位置的值,就往后依次挪动,然后 j-- 继续看下一个值
            while (j > 0 && current < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            //最后停下来的 j 的位置,放置之前暂存的值
            array[j] = current;
        }
        return array;
    }
}

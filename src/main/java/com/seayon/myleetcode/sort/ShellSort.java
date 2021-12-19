package com.seayon.myleetcode.sort;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/19 3:57 下午
 * @Version V1.0
 * @Description:
 */
public class ShellSort implements MySort {
    @Override
    public int[] sort(int[] array) {
        // 刚开始的步长,组分成 数组数量除以 2 个组,比如总共 100 个数,分成 50 组
        for (int step = array.length / 2; step >= 1; step /= 2) {
            //    对每个 组里面的数据进行插入排序操作
            for (int i = step; i < array.length; i++) {
                int current = array[i];
                int j = i - step;
                while (j >= 0 && current < array[j]) {
                    array[j + step] = array[j];
                    j -= step;
                }
                array[j + step] = current;
            }
        }
        return array;
    }
}

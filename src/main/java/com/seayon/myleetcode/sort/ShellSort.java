package com.seayon.myleetcode.sort;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/19 3:57 下午
 * @Version V1.0
 * @Description: 希尔排序/Shell 排序
 */
public class ShellSort implements MySort {
    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }
        //分组,然后进行插入排序
        //设定步长,初始组数直接设置为数组长度的一半儿,组数也是步长,每一组之间的间隔
        int step = array.length / 2;
        while (step > 0) {
            for (int i = step; i < array.length; i++) {
                int j = i;
                int current = array[j];
                while (j > step - 1 && current < array[j - step]) {
                    array[j] = array[j - step];
                    j -= step;
                }
                array[j] = current;
            }
            step /= 2;
        }
        return array;
    }
}

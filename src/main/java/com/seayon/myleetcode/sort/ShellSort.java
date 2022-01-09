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
        int step = array.length / 2; // 9 /2 = 4, 10 /2 = 5
        while (step >= 1) {
            // 对每一组进行插入排序操作,这里一定是 i++,代表一次对每个组进行插入排序
            for (int i = step; i < array.length; i++) {
                int current = array[i];
                int j = i - step;
                while (j >= 0 && current < array[j]) {
                    array[j + step] = array[j];
                    j -= step;
                }
                array[j + step] = current;
            }
            //步长减半,最后一步,step = 1 的时候, 1/2 等于 0,所以上面不会再进行下一轮
            step /= 2;
        }
        return array;
    }
}

package com.seayon.myleetcode.sort;

import java.util.Arrays;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/18 11:07 下午
 * @Version V1.0
 * @Description:
 */
public interface MySort {

    default void before(int[] array) {
        System.out.println("     排序前: " + Arrays.toString(array));
    }

    default void after(int[] array) {
        System.out.println("     排序后: " + Arrays.toString(array));
    }

    default void expect(int[] array) {
        Arrays.sort(array);
        System.out.println("期望排序结果: " + Arrays.toString(array));
    }

    default int[] mySort(int[] array) {
        int[] bak = Arrays.copyOf(array, array.length);
        System.out.println("");
        Arrays.copyOf(array, array.length);
        before(array);
        array = sort(array);
        after(array);
        expect(bak);
        System.out.println("");
        return array;
    }

    public int[] sort(int[] array);

    default void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

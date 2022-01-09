package com.seayon.myleetcode.sort;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/18 11:05 下午
 * @Version V1.0
 * @Description: 冒泡排序
 */
public class Bubble implements MySort {

    @Override
    public int[] sort(int[] ints) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < ints.length - 1; i++) {
                int current = ints[i];
                if (current > ints[i + 1]) {
                    int tmp = ints[i + 1];
                    ints[i] = tmp;
                    ints[i + 1] = current;
                    sorted = false;
                }
            }
        }
        return ints;
    }

}

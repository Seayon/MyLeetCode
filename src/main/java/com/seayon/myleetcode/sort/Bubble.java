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
            // 每次进入都假定已经排好序了
            sorted = true;
            for (int i = 0; i < ints.length - 1; i++) {
                if (ints[i] > ints[i + 1]) {
                    int current = ints[i];
                    ints[i] = ints[i + 1];
                    ints[i + 1] = current;
                    // 发现一次交换就设置为没有排好序,需要再来
                    sorted = false;
                }
            }
        }
        return ints;
    }

}

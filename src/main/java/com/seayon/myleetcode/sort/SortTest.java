package com.seayon.myleetcode.sort;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2021
 * @Author: SaeyonZhao
 * @Date: 2021/12/18 11:13 下午
 * @Version V1.0
 * @Description:
 */
@Log
public class SortTest {
    @Test
    @DisplayName("冒泡排序测试")
    public void test() {
        testSort(new Bubble());
        Assertions.assertEquals(1, 1, "这个值应该相等");
    }

    @Test
    @DisplayName("选择排序")
    public void testselectionSort() {
        testSort(new SelectSort());

    }


    @Test
    @DisplayName("插入排序")
    public void testInsertSort() {
        testSort(new InsertSort());
    }

    @Test
    @DisplayName("希尔排序")
    public void testShellSort() {
        testSort(new ShellSort());
    }


    public void testSort(MySort mySort) {
        System.out.println("开始执行: " + System.currentTimeMillis());


        check(mySort.sort(new int[]{5, 6, 3, 3, 1, 2, 3, 0, 0, 0, 1, 3, 700}));
        check(mySort.sort(new int[]{0, 1}));
        check(mySort.sort(new int[]{0, 2}));
        check(mySort.sort(new int[]{0, 0}));
        check(mySort.sort(new int[]{0}));
        check(mySort.sort(new int[]{}));
        check(mySort.sort(new int[]{2, 1}));
        check(mySort.sort(new int[]{2, 1, 2}));
        check(mySort.sort(new int[]{2, 1, 1, 2}));
        check(mySort.sort(new int[]{98, 2, 1, 1, 2}));

        Random random = new Random();
        int[] integers = new int[10000];
        for (int i = 0; i < 1000; i++) {
            integers[i] = random.nextInt(1000);
        }
        check(mySort.sort(integers));
        System.out.println("结束执行: " + System.currentTimeMillis());
    }

    @DisplayName("检查有序")
    public void check(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
                System.out.println(Arrays.toString(ints) + ",");
                throw new AssertionFailedError("不是升序的");
            }
        }
    }

}

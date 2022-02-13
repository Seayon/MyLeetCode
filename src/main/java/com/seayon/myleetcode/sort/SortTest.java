package com.seayon.myleetcode.sort;

import com.sun.org.apache.bcel.internal.generic.Select;
import lombok.extern.java.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.opentest4j.AssertionFailedError;

import java.util.Arrays;
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
        testSort(new BubbleSort());
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

    @Test
    @DisplayName("归并排序")
    public void testMergeSort() {
        testSort(new MergeSort());
    }

    @Test
    @DisplayName("快速排序")
    public void testQuickSOrt() {
        testSort(new QuickSort());
    }

    @Test
    @DisplayName("计数排序")
    public void testCountingSort() {
        testSort(new CountingSort());
    }

    @Test
    @DisplayName("堆排序")
    public void testHeapSort() {
        testSort(new HeapSort());
    }

    public void testSort(MySort mySort) {
        long startTime = System.currentTimeMillis();
        System.out.println("开始执行: " + startTime);


        check(mySort.mySort(new int[]{5, 6, 3, 3, 1, 2, 3, 0, 0, 0, 1, 3, 700}));
        check(mySort.mySort(new int[]{0, 1}));
        check(mySort.mySort(new int[]{0, 2}));
        check(mySort.mySort(new int[]{0, 0}));
        check(mySort.mySort(new int[]{0}));
        check(mySort.mySort(new int[]{}));
        check(mySort.mySort(new int[]{2, 1}));
        check(mySort.mySort(new int[]{2, 1, 2}));
        check(mySort.mySort(new int[]{2, 1, 1, 2}));
        check(mySort.mySort(new int[]{98, 2, 1, 1, 2}));
        check(mySort.mySort(new int[]{2, 1, 2, 3, 4, 5}));
        check(mySort.mySort(new int[]{1, 3, 5, 7, 9}));
        check(mySort.mySort(new int[]{1, 3, 4, 5, 7, 2}));
        check(mySort.mySort(new int[]{1, 3, 4, 8, 7, 2}));
        // check(mySort.sort(new int[]{-12, -3, -4, 2, 1, 1, 2}));

        Random random = new Random();
        int count = 10000;
        int[] integers = new int[count];
        for (int i = 0; i < count; i++) {
            integers[i] = random.nextInt(count);
        }
        check(mySort.mySort(integers));
        long endTime = System.currentTimeMillis();
        System.out.println("结束执行: " + endTime);
        System.out.println("总计用时: " + (endTime - startTime) + "ms");
    }

    @DisplayName("检查有序")
    public void check(int[] ints) {
        if (ints == null || ints.length == 0) {
            return;
        }
        for (int i = 0; i < ints.length - 1; i++) {
            if (ints[i] > ints[i + 1]) {
                System.out.println(Arrays.toString(ints));
                throw new AssertionFailedError("不是升序的");
            }
        }
    }

}

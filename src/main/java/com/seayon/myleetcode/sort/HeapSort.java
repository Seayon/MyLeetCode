package com.seayon.myleetcode.sort;

import java.util.PriorityQueue;

/**
 * @BelongProjecet MyLeetCode
 * @BelongPackage com.seayon.myleetcode.sort
 * @Copyright 2000-2022
 * @Author: SaeyonZhao
 * @Date: 2022/2/13 9:55 下午
 * @Version V1.0
 * @Description: 堆排序
 */
public class HeapSort implements MySort{
    @Override
    public int[] sort(int[] array) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i : array) {
            priorityQueue.offer(i);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = priorityQueue.poll();
        }
        return array;
    }
}

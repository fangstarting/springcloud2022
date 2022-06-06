package com.test;

import lombok.var;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program springcloud2022
 * @description
 * @Author FFang
 * @Create 2022-06-06 23:53
 */
public class QuickSort {
    /**
     * 快速排序
     *
     * @param arr 待排序数组
     * @param left 待排序最小下标
     * @param right 待排序最大下标
     */
    public static void myQuickSort(int[] arr, int left, int right) {
        int start = left, end = right;
        if (left < right) {
            int temp = arr[left]; // 定义基准数，默认为数组的第一个元素
            while (left < right) { // 循环执行的条件
                // 因为默认的基准数是在最左边，所以首先从右边开始比较进入while循环的判断条件
                // 如果当前arr[right]比基准数大，则直接将右指针左移一位，当然还要保证left<right
                while (left < right && arr[right] > temp) {
                    right--;
                }
                // 跳出循环说明当前的arr[right]比基准数要小，那么直接将当前数移动到基准数所在的位置，并且左指针向右移一位（left++）
                // 这时当前数（arr[right]）所在的位置空出，需要从左边找一个比基准数大的数来填充。
                if (left < right) {
                    arr[left++] = arr[right];
                }
                // 下面的步骤是为了在左边找到比基准数大的数填充到right的位置。
                // 因为现在需要填充的位置在右边，所以左边的指针移动，如果arr[left]小于或者等于基准数，则直接将左指针右移一位
                while (left < right && arr[left] <= temp) {
                    left++;
                }
                // 跳出上一个循环说明当前的arr[left]的值大于基准数，需要将该值填充到右边空出的位置，然后当前位置空出。
                if (left < right) {
                    arr[right--] = arr[left];
                }
            }
            // 当循环结束说明左指针和右指针已经相遇。并且相遇的位置是一个空出的位置，
            // 这时候将基准数填入该位置，并返回该位置的下标，为分区做准备。
            arr[left] = temp;
            myQuickSort(arr, start, left - 1);
            myQuickSort(arr, left + 1, end);
        }
    }
    @Test
    public void t1(){
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 300 + 20);
            System.out.print(arr[i] + ",");
        }
//		int[] arr = { 8, 5, 4, 12, 3, 6, 1, 2, 54, 1, 74, 5, 4, 54, 854, 1, 5, 31, 1, 45, 42, 1, 54, 31, 6, 64, 6 };
        System.out.println("\n*************");
        QuickSort.myQuickSort(arr, 0, arr.length - 1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            System.out.print(j + ",");
            if (map.containsKey(j)) {
                map.put(j, map.get(j) + 1);
            } else {
                map.put(j, 1);
            }
        }
        System.out.println("\n*************");
        for (var i : map.entrySet()) {
            if (i.getValue() > 1) {
                System.err.print(i.toString() + ",");
            } else {
                System.out.print(i.toString() + ",");
            }
        }
    }
}

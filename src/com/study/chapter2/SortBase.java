package com.study.chapter2;

import java.util.Arrays;

public class SortBase {
    /**
     * 比较a是否更小
     * @param a
     * @param b
     * @return
     */
    public static boolean  less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    /**
     * 交换两个数的位置
     * @param array
     * @param i
     * @param j
     */
    public static void exchange(Comparable[] array, int i, int j){
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * 展示数组
     * @param array
     */
    public static void showArray(Comparable[] array, String des){
        System.out.println(des+Arrays.toString(array));
    }

    /**
     * 检查数组是否排序成功
     * @param array
     * @return
     */
    public static boolean isSort(Comparable[] array){
        for (int i = 1; i < array.length; i++) {
            if(less(array[i],array[i-1])){
                return false;
            }
        }
        return true;
    }
}

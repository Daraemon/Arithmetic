package com.study.chapter2;

/**
 * 插入排序
 * 算法书上有两种插入排序
 */
public class InsertionSort extends SortBase {
    /**
     * 插入排序1（算法书上是插入排序，网上很多说的冒泡排序）
     * @param a
     */
    public static void sort1(Comparable[] a){
        int length = a.length;
        for (int i = 1; i < length; i++) {
            for (int j = i; j > 0 && less(a[j],a[j-1]); j--) {
                exchange(a,j,j-1);
            }
        }
    }

    /**
     * 插入排序2
     * @param a
     */
    public static void sort2(Comparable[] a){
        int length = a.length;
        for (int i = 1; i < length; i++) {
            Comparable temp = a[i];
            int j;
            for (j = i; j > 0 && less(temp,a[j-1]); j--) {
                a[j] = a[j-1];
            }
            a[j] = temp;
        }
    }
}

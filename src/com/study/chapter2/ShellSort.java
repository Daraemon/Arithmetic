package com.study.chapter2;

/**
 * 希尔排序
 * 定一个初始步长h，步长间隔为h的元素比较，如a[0]、a[0+h],若a[0+h]更小则交换
 */
public class ShellSort extends SortBase {
    public static void sort(Comparable[] a){
        int length = a.length;
        int h = 1;
        while(h < length/3) h = 1 + 3*h;
        while(h >= 1 ){
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(a[j],a[j-h]) ; j -= h) {
                    exchange(a, j,j-h);
                }
            }
            h = h/3;
        }
    }
}

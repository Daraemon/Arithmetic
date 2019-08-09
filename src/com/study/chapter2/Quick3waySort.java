package com.study.chapter2;

/**
 * 三项切分排序
 * 优化了快速排序（重复元素不再交换）
 */
public class Quick3waySort extends SortBase {
    public static void sort(Comparable[] a){
        sort(a,0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi){
        if( lo >= hi) return;
        int lt = lo, i = lo + 1, gt = hi;
        Comparable v = a[lo];   //切分元素
        while(i <= gt){
            int result = a[i].compareTo(v);
            if(result > 0){
                exchange(a,i,gt--);
            }else if(result < 0){
                exchange(a, lt++, i++);
            }else{
                i++;
            }
        }
        sort(a,lo,lt-1);
        sort(a,gt+1,hi);
    }

}

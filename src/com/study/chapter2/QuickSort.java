package com.study.chapter2;

/**
 * 快速排序
 * 主要是切分，选择一个数，比他大的放右边，比他小的放左边
 */
public class QuickSort extends SortBase {
    public static void sort(Comparable[] a){
        int lo = 0;
        int hi = a.length - 1;
        sort(a, lo, hi);
    }
    private static void sort(Comparable[] a, int lo, int hi){
        if(lo >= hi) return;
        int j = partition(a, lo, hi);
        sort(a,lo,j-1);
        sort(a,j+1,hi);
    }

    /**
     * 切分方法
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    private static int partition(Comparable[] a, int lo, int hi){
        Comparable v = a[lo];   //切分的元素
        int i = lo;
        int j = hi+1;
        while(true){
            while(less(a[++i],v)) if(i >= hi) break;    //从左往右扫描选出比v大的元素
            while(less(v,a[--j])) if(j <= lo) break;    //从右往左扫描选出比v小的元素
            if(i >= j) break;
            exchange(a, i, j);  //两个元素交换位置
        }
        exchange(a, lo ,j);     //把切分元素v放入正确的位置
        return j;
    }
}

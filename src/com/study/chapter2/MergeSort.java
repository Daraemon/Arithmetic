package com.study.chapter2;

/**
 * 归并排序
 */
public class MergeSort extends SortBase {

    private static Comparable[] tempArray;   //归并所需要的临时数组

    public static void sort(Comparable[] a){
        tempArray = new Comparable[a.length];
        sort(a,0,a.length-1);
    }

    /**
     * 运用递归一直分到只有一个元素为止
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a, int lo, int hi){
        if(hi <= lo) return;
        int mid = lo + (hi- lo)/2;
        sort(a,lo,mid);
        sort(a,mid+1,hi);
        merge(a,lo,mid,hi);

    }
    /**
     * 把上下两部分以排序好的数组重新排序并合并到一起
     * @param a
     * @param lo
     * @param mid
     * @param hi
     */
    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            tempArray[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = tempArray[j++];
            }else if(j > hi){
                a[k] = tempArray[i++];
            }else if(less(tempArray[i],tempArray[j])){
                a[k] = tempArray[i++];
            }else{
                a[k] = tempArray[j++];
            }
        }
    }
}

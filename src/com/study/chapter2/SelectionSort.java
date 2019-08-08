package com.study.chapter2;

import com.study.utils.Utils;

/**
 * 选择排序
 * 从index为0的元素开始并假设为最小的元素，依次与后面的元素比较；
 * 只要比之前定为最小的元素小，就把当前元素替换为最小元素
 */
public class SelectionSort extends SortBase {
    public void sort(Comparable[] a){
        int length = a.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i+1; j < length; j++) {
                if(less(a[j],a[min])){
                    min = j;
                }
                exchange(a,i,min);
            }
        }
    }
}

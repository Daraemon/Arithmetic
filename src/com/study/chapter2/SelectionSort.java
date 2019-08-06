package com.study.chapter2;

import com.study.utils.Utils;

/**
 * 选择排序
 */
public class SelectionSort extends SortBase {
    public static void sort(Comparable[] a){
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

    public static void main(String[] args) {
        String[] array = Utils.getRandomString(20);
        showArray(array,"排序前的数组：");
        sort(array);
        showArray(array,"排序后的数组：");
    }
}

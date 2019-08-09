package com.study.chapter2;

import com.study.utils.Utils;

/**
 * 排序测试
 */
public class SortTest {
    public static void main(String[] args) {
        String[] array = Utils.getRandomString(20);

//        SelectionSort st = new SelectionSort(); //选择排序
//        InsertionSort st = new InsertionSort(); //插入排序
//        ShellSort st = new ShellSort();         //希尔排序
//        MergeSort st = new MergeSort();         //归并排序
//        QuickSort st = new QuickSort();         //快速排序
        Quick3waySort st = new Quick3waySort(); //三项切分排序

//        st.sort1(array); //插入排序1
        st.showArray(array,"排序前的数组：");
        st.sort(array); //选择排序、希尔排序
//        st.sort1(array); //插入排序1
//        st.sort2(array); //插入排序2
        st.showArray(array,"排序后的数组：");
    }
}

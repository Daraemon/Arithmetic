package com.study.chapter1;

import com.study.utils.Utils;

import java.util.Arrays;
import java.util.Random;

/**
 * 整型的二分法查找
 * 调用rank方法前需要排序
 */
public class BinarySearch {
    /**
     * 二分法查找
     * @param numbers
     * @param number
     * @return
     */
    public static int rank(int[] numbers, int number){
        int start = 0;
        int end = numbers.length;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(number < numbers[mid]){
                end = mid - 1;
            } else if(number > numbers[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
//
//    /**
//     * 获取一个不重复的随机数组
//     * @param size 数组的大小
//     * @param range 随机数的范围 如传100则是0～99
//     * @return
//     */
//    public static int[] getRandomNumbers(int size, int range){
//        Random r = new Random();
//        int numbers[] = new int[size];
//        boolean[] bool = new boolean[range];
//        for (int i = 0; i < size; i++) {
//            do{
//                numbers[i] = r.nextInt(range);
//            }while (bool[numbers[i]]);
//            bool[numbers[i]] = true;
//        }
//        return numbers;
//    }

    /**
     * 展示数组
     * @param array 需要展示的数组
     * @param des 数组的描述
     */
    public static void showArray(int[] array, String des){
        System.out.println(des + Arrays.toString(array));
    }

    //二分法测试
    public static void main(String[] args) {
        //随机生成20个100以内的数
        int[] numbers = Utils.getRandomNumbers(20,100);
        //展示随机生成的数组
        showArray(numbers,"随机生成的20个100以内的数组：");
        //数组排序
        Arrays.sort(numbers);
        showArray(numbers,"排序后的数组：");
        //需要查找的数字
//        int findNumber = 22;
        int findNumber = numbers[5];
        int index = rank(numbers,findNumber);
        if(index == -1){
            System.out.println("在数组中没有找到该整数："+findNumber);
        }else{
            System.out.println("找到该整数"+findNumber+"，所在的下标是："+index);
        }
    }
}

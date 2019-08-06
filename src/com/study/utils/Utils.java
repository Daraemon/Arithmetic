package com.study.utils;

import java.util.Random;

public class Utils {
    /**
     * 获取一个不重复的随机数组
     * @param size 数组的大小
     * @param range 随机数的范围 如传100则是0～99
     * @return
     */
    public static int[] getRandomNumbers(int size, int range){
        Random r = new Random();
        int numbers[] = new int[size];
        boolean[] bool = new boolean[range];
        for (int i = 0; i < size; i++) {
            do{
                numbers[i] = r.nextInt(range);
            }while (bool[numbers[i]]);
            bool[numbers[i]] = true;
        }
        return numbers;
    }

    /**
     * 随机获取单一字符的字符串数组
     * @param size
     * @return
     */
    public static String[] getRandomString(int size){
        String str = "abcdefghijklmnopqrstuvwxyz";
        String[] array = new String[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = String.valueOf(str.charAt(r.nextInt(26)));
        }
        return array;
    }
}

package com.study.chapter1;

import java.util.Iterator;

/**
 * 动态数组实现背包
 * @param <Item>
 */
public class ArrayBag<Item> implements Iterable<Item>{
    private int N = 0;
    private Item[] a = (Item[]) new Object[1];
    //背包大小
    public int size(){
        return N;
    }
    //背包是否是空
    public boolean isEmpty(){
        return N == 0;
    }

    //添加数据
    public void add(Item item){
        //数组长度不够，创建新的两倍大小的数组
        if(N == a.length) {
            resize(2*N);
        }
        a[N++] = item;
    }

    //重新创建一个更大的数组
    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayBagIterator();
    }

    /**
     * 支持后进先出的迭代
     */
    private class ArrayBagIterator implements Iterator<Item>{
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }
    }

    public static void main(String[] args) {
        //背包测试
        ArrayBag<String> bag = new ArrayBag<String>();
        for (int i = 0; i < 10; i++) {
            bag.add("bag"+i);
        }
        String bagOut = "";
        Iterator<String> iter = bag.iterator();
        while (iter.hasNext()){
            bagOut = bagOut + " " + iter.next();
        }
        System.out.println("背包中的所有元素："+bagOut);
        System.out.println("背包大小："+bag.size());
    }
}

package com.study.chapter1;

import java.util.Iterator;

/**
 * 动态数组实现栈
 * @param <Item>
 */
public class ArrayStack<Item> implements Iterable<Item> {
    private int N = 0;
    private Item[] a = (Item[]) new Object[1];

    public boolean isEmpty(){
     return N == 0;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        if(N == a.length) {
            resize(2*N);
        }
        a[N++] = item;
    }

    public Item pop(){
        Item item = a[--N];
        a[N] = null;
        if(N > 0 && N == a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayStackIterator();
    }

    /**
     * 支持后进先出的迭代
     */
    private class ArrayStackIterator implements Iterator<Item>{
        private int i = N;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        //栈测试
        ArrayStack<String> stack = new ArrayStack<String>();
        for (int i = 0; i < 10; i++) {
            stack.push("stack"+i);
        }
        String stackOut = "";
        Iterator<String> iter = stack.iterator();
        while (iter.hasNext()){
            stackOut = stackOut + " " + iter.next();
        }
        System.out.println("栈中的所有元素："+stackOut);
        System.out.println("栈大小："+stack.size());



        for (int i = 0; i < 6; i++) {
            stack.pop();
        }
        stackOut = "";
        Iterator<String> iter1 = stack.iterator();
        while (iter1.hasNext()){
            stackOut = stackOut + " " + iter1.next();
        }
        System.out.println("删除后栈中的所有元素："+stackOut);
        System.out.println("栈大小："+stack.size());
    }
}

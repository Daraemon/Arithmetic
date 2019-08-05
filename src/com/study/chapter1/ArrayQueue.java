package com.study.chapter1;

import java.util.Iterator;

/**
 * 动态数组实现队列
 * @param <Item>
 */
public class ArrayQueue<Item> implements Iterable<Item> {
    private int head = 0;   //头
    private int trial = 0;  //尾

    private Item[] a = (Item[]) new Object[1];

    public int size(){
        return trial - head;
    }

    public boolean isEmpty(){
        return trial - head == 0;
    }

    public void enqueue(Item item){
        if(trial == a.length){
            resize(2*trial);
        }
        a[trial++] = item;
    }

    /**
     * 删除头元素（若空元素=数组长度的3/4，则改变数组大小）
     * @return 返回该头元素
     */
    public Item dequeue(){
        Item item = a[head];
        a[head] = null;
        head++;
        if(trial > 0 && (trial - head) == a.length/4){
            resize(a.length/2);
        }
        return item;
    }

    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        int index = 0;
        for (int i = 0; i < trial; i++) {
            if(a[i] != null){
                temp[index] = a[i];
                index++;
            }
        }
        a = temp;
        trial = trial - head;
        head = 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayQueueIterator();
    }

    /**
     * 支持先进先出的迭代
     */
    private class ArrayQueueIterator implements Iterator<Item>{
        private int i = head;

        @Override
        public boolean hasNext() {
            return i < trial;
        }

        @Override
        public Item next() {
            return a[i++];
        }

        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        //队列测试
        ArrayQueue<String> queue = new ArrayQueue<String>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue("queue"+i);
        }
        String queueOut = "";
        Iterator<String> iter = queue.iterator();
        while (iter.hasNext()){
            queueOut = queueOut + " " + iter.next();
        }
        System.out.println("队列中的所有元素："+queueOut);
        System.out.println("队列大小："+queue.size());



        for (int i = 0; i < 6; i++) {
            queue.dequeue();
        }
        queueOut = "";
        Iterator<String> iter1 = queue.iterator();
        while (iter1.hasNext()){
            queueOut = queueOut + " " + iter1.next();
        }
        System.out.println("删除后队列中的所有元素："+queueOut);
        System.out.println("队列大小："+queue.size());
    }

}

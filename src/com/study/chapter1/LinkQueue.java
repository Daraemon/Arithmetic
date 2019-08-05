package com.study.chapter1;

import java.util.Iterator;

/**
 * 链表实现队列
 * @param <Item>
 */
public class LinkQueue<Item> implements Iterable<Item> {
    private Node first; //头
    private Node last;  //尾
    private int N;

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        } else {
            oldLast.next = last;
        }
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty()){
            last = null;
        }
        N--;
        return item;
    }

    private class Node{
        Item item;
        Node next;
    }
    @Override
    public Iterator<Item> iterator() {
        return new LinkQueueIterator();
    }

    private class LinkQueueIterator implements Iterator<Item>{
        private Node current = first;
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args) {
        //队列测试
        LinkQueue<String> linkQueue = new LinkQueue<String>();
        for (int i = 0; i < 10; i++) {
            linkQueue.enqueue("linkQueue"+i);
        }
        String out = "";
        Iterator<String> iter = linkQueue.iterator();
        while (iter.hasNext()){
            out = out + " " + iter.next();
        }
        System.out.println("链表队列中的所有元素："+out);
        System.out.println("链表队列大小："+linkQueue.size());



        for (int i = 0; i < 5; i++) {
            linkQueue.dequeue();
        }
        out = "";
        Iterator<String> iter1 = linkQueue.iterator();
        while (iter1.hasNext()){
            out = out + " " + iter1.next();
        }
        System.out.println("删除后链表队列中的所有元素："+out);
        System.out.println("链表队列大小："+linkQueue.size());
    }
}

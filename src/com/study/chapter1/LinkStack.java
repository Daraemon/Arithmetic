package com.study.chapter1;

import java.util.Iterator;

/**
 * 链表实现栈
 * @param <Item>
 */
public class LinkStack<Item> implements Iterable<Item> {
    private Node first;
    private int N;

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    public Item pop(){
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    private class Node{
        Item item;
        Node next;
    }
    @Override
    public Iterator<Item> iterator() {
        return new LinkStackIterator();
    }

    private class LinkStackIterator implements Iterator<Item>{
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
        //链表栈测试
        LinkStack<String> stack = new LinkStack<String>();
        for (int i = 0; i < 10; i++) {
            stack.push("linkStack"+i);
        }
        String stackOut = "";
        Iterator<String> iter = stack.iterator();
        while (iter.hasNext()){
            stackOut = stackOut + " " + iter.next();
        }
        System.out.println("链表栈中的所有元素："+stackOut);
        System.out.println("链表栈大小："+stack.size());



        for (int i = 0; i < 7; i++) {
            stack.pop();
        }
        stackOut = "";
        Iterator<String> iter1 = stack.iterator();
        while (iter1.hasNext()){
            stackOut = stackOut + " " + iter1.next();
        }
        System.out.println("删除后链表栈中的所有元素："+stackOut);
        System.out.println("链表栈大小："+stack.size());
    }
}

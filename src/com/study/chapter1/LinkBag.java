package com.study.chapter1;

import java.util.Iterator;

/**
 * 链表实现背包
 * @param <Item>
 */
public class LinkBag<Item> implements Iterable<Item> {
    private Node first;
    private int N;
    private class Node{
        Item item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size(){
        return N;
    }

    public void add(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkBagIterator();
    }

    private class LinkBagIterator implements Iterator<Item>{
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

        @Override
        public void remove() {

        }
    }

    //链表背包测试
    public static void main(String[] args) {
        LinkBag<String> linkBag = new LinkBag<String>();
        for (int i = 0; i < 10; i++) {
            linkBag.add("linkbag"+i);
        }
        Iterator<String> iter = linkBag.iterator();
        String out = "";
        while(iter.hasNext()){
            out = out + " " + iter.next();
        }
        System.out.println("背包中的所有元素："+out);
        System.out.println("背包大小："+linkBag.size());
    }
}

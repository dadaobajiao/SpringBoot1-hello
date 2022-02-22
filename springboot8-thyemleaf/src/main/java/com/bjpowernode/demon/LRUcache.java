package com.bjpowernode.demon;



import java.util.HashMap;
import java.util.Map;

public class LRUcache {
    //1，创建节点，map负责查找，里面存储的是一个个node节点
    class Node<k,v>{
        k key;
        v value;
        Node<k,v> pre;
        Node<k,v> next;
        public Node(){
            this.pre=this.next=null;
        }
        public Node(k key,v value){
            this.key=key;
            this.value=value;
            this.pre=this.next=null;
        }
    }
    //2.创建双向链表结构
    class DoubleLinkedList<k,v>{
        Node<k,v> head;//头节点
        Node<k,v> tail;//尾节点
        public DoubleLinkedList(){
            head=new Node<>();
            tail=new Node<>();
            head.next=tail;
            tail.next=head;//创建一个轮廓，双向链表
        }
        //2，添加到头节点
        public void addHead(Node<k,v> node){
            node.next=head.next;
            node.pre=head;
            head.next.pre=node;
            head.next=node;
        }
        //3，删除节点
        public void removeNode(Node<k,v> node){
            node.next.pre=node.pre;
            node.pre.next=node.next;
            node.next=null;
            node.pre=null;
        }
        //4，获取最后一个节点
        public Node<k,v> getLast(){
            return tail.pre;
        }
    }

    private int cacheSize;
    Map<Integer,Node<Integer,Integer>> map;
    DoubleLinkedList<Integer,Integer> doubleLinkedList;
    //构造方法
    public LRUcache(int cacheSize){
      this.cacheSize=cacheSize;
      map=new HashMap<>();
      doubleLinkedList=new DoubleLinkedList<>();
    }

    //取节点
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;//说明这个队列里面没有要查找的值
        }else{
            //找到了，说明用过，就把他删了，重新添加到队头
            Node<Integer,Integer> node=map.get(key);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
            return node.value;
        }
    }
    //存储节点
    public void put(int key,int value){
        //先判断是否存在
        if(map.containsKey(key)){
            Node<Integer,Integer> node=map.get(key);
            node.value=value;//取出旧值，然后更新
            map.put(key,node);

            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        }else{
            if(map.size()==cacheSize){
                //说明满了
                Node<Integer,Integer> node=doubleLinkedList.getLast();
                map.remove(node.key);
                doubleLinkedList.removeNode(node);
            }
            //走到这，才是添加新节点
            Node<Integer,Integer> newNode=new Node<>();
            map.put(key,newNode);
            doubleLinkedList.addHead(newNode);
        }
    }

    public static void main(String[] args) {

    }
}

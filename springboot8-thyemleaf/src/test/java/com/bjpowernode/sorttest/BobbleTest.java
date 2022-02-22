package com.bjpowernode.sorttest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BobbleTest {


    //冒泡排序
    @Test
    public void Buddl(){
        int[] arr={3,9,-1,10,-2};
        int temp=0;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j+1]<arr[j]){
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

    //冒泡排序优化
    @Test
    public void Buddl1(){
        int[] arr={3,9,-1,10,20};
        int temp=0;
        boolean flag=false;
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j+1]<arr[j]){
                    flag=true;
                    temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
            if(!flag){
                break;//说明flag是false，没有变化，那就说明没有执行交换
            }else {
                flag=false;//重置，以便于下次判断
            }
            System.out.println(Arrays.toString(arr));
        }
    }




}

package com.bjpowernode.sorttest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SelectTest {
    @Test
    public void selectSort(){
        int[] arr={-1,2,5,1,3};
        for(int i=0;i<arr.length-1;i++){
            //定义最小的下标，和最小的值，我们默认最小的值为第一个元素
            int min=arr[i];
            int minIndex=i;
            for(int j=i+1;j<arr.length-1;j++){
                if(min>arr[j]){
                    minIndex=j;
                    min=arr[j];
                }
            }
            //当min的值变了，那就说明要变化
            if(min!=arr[i]){
                arr[minIndex]=arr[i];
                arr[i]=min;
            }
            System.out.println(Arrays.toString(arr));
        }

    }

}

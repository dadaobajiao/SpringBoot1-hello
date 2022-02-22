package com.bjpowernode.sorttest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

//希尔排序，就是改进版的插入排序
public class ShellTest {
    //交换法，数量多了反而好不如直接插入
    @Test
    public void shell(){
        int count=0;
        int temp=0;
        int arr[]={9,1,3,4,6,5,2,8,7,0};
        for(int grp=arr.length/2;grp>0;grp/=2){
            for(int i=grp;i<arr.length;i++){
                for(int j=i-grp;j>=0;j-=grp){
                    if(arr[j]>arr[j+grp]){
                        temp=arr[j];
                        arr[j]=arr[j+grp];
                        arr[j+grp]=temp;
                    }
                }
            }
            System.out.println("第"+(count++)+"次："+ Arrays.toString(arr));
        }
    }

    @Test
    public void shell1(){
        int arr[]={9,1,3,4,6,5,2,8,7,0};
        //
        for(int grp=arr.length/2;grp>0;grp/=2){
            for(int i=grp;i<arr.length;i++){
            //定义插入点，和存储插入数据
            int index=i;
            int indexValue=arr[index];
            if(arr[index]<arr[index-grp]) {
                while (index - grp >= 0 && indexValue < arr[index - grp]) {
                    arr[index] = arr[index - grp];
                    index -= grp;
                }
                arr[index] = indexValue;
            }
            }
            System.out.println(Arrays.toString(arr));
        }
    }

}

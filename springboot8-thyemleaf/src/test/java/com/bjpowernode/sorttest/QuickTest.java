package com.bjpowernode.sorttest;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickTest {
    public static void main(String[] args) {
        int[] arr={5,3,7,2,9,8,1,4};
        sort(arr,0,arr.length-1);
        Arrays.sort(arr);
    }

    public static  void sort(int[] arr,int l,int r){
        //使用单边排序的递归
        if(l>=r){
            return;
        }
        int p=so(arr,l,r);
        sort(arr,l,p-1);
        sort(arr,p+1,r);
    }
    static  int temp=0;
    public static int so(int[] arr,int l,int r){
        int pv=arr[r];//基点元素，区间类的元素都和这个比较
        int i=l;
        for(int j=l;j<r;j++){
            if(arr[j]<pv){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
            }
        }
        temp=arr[i];
        arr[i]=arr[r];
        arr[r]=temp;

        System.out.println(Arrays.toString(arr));
        return i;
       
    }

}

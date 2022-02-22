package com.bjpowernode.sorttest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class InsertTest {
    @Test
    public void insertSort(){
        int[] arr={-1,4,1,2,9,3};

        for(int i=1;i<arr.length;i++){
            int insertValue=arr[i];
            int insertIndex=i-1;
            //下标大于0，或者，还没找到正确的插入点
            while(insertIndex>=0&&insertValue<arr[insertIndex]){
                //向后覆盖
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
        }
            //除了while循环，说明找到了插入点
            arr[insertIndex+1]=insertValue;
            System.out.println(Arrays.toString(arr));
        }
    }
}

package test3;

import java.util.Arrays;
/*
即 {1，2，3，4，5}—>{5，4，3，2，1}
方法：设定两个下标, 分别指向第一个元素和最后一个元素. 交换两个位置的元素，然后让前一个下标自增，后一个下标自减，循环继续。

*/
public class Arr {
    public static void main(String[] args) {
        char[] arr = { 'a','b','c','d','e'};
        int left = 0;
        int right =arr.length - 1;
        for(int i = 0; i< arr.length ; i++) ;
            while (left < right){
             char temp = arr[left];
             arr[left] = arr[right];
             arr[right] = temp ;
             left++;
             right--;
         }
        System.out.println(Arrays.toString(arr));
    }
}

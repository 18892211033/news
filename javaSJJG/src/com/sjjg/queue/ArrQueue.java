package com.sjjg.queue;

import java.util.Scanner;

public class ArrQueue{
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';  //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列里取数据");
            System.out.println("h(head):查看队列头数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数字添加到队列");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头数据是%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    System.out.println("非法输入");
            }
        }
        System.out.println("********************程序结束******************");
    }
}
//使用数组模拟编写一个ArrayQueue类
class ArrayQueue{
    private int maxSize;
    private int front;  //队列头
    private int rear;      //队列尾
    private int[] arr;     //存放数据的数组
    //创建队列构造器
    public ArrayQueue(int arrmaxSize){
        maxSize = arrmaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    //判断队列是否为满
    public boolean isFull(){
        return rear == maxSize-1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return front==rear;
    }
    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满，不能添加数据");
            return;
        }
        rear++;
        arr[rear] = n;
    }
    //取数据从队列
    public int getQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能添加数据");
        }
        front++;    //front后移
        return arr[front];
    }
    //显示所有数据
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }
    //显示头数据，但不取出
    public int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列为空，不能添加数据");
        }
        return arr[front+1];
    }

}
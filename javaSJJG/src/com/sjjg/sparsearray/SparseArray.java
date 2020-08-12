package com.sjjg.sparsearray;

public class SparseArray {
    public static void main(String[] args) {
        //定义一个数组
        int[][] arr1 = new int[11][11];
        arr1[0][1] = 1;
        arr1[1][2] = 2;


        //格式化打印出数组中的数据，形成一个11*11的表
        for (int [] row :arr1) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        //循环arr1得出arr1中的有效值的个数
        int sum = 0;
        for (int i = 0 ; i<arr1.length ; i++){      //算出有多少有效数据
            for (int j = 0 ; j <arr1.length ; j++ ){
                if (arr1[i][j] != 0){
                    sum++;
                }
            }
        }
//        System.out.println(sum);

        //定义一个稀疏数组sum+1是行数，3是列数
        // 因为稀疏数组第一行要记录   arr1数组行数   列数   有效值个数  占位1行 所以sum+1
        int [][] sparseArry = new int[sum + 1][3] ;
//        System.out.println(sparseArry);  //打印的是数组的地址
        sparseArry [0][0] = 11;
        sparseArry [0][1] = 11;
        sparseArry [0][2] = sum;


        //定义一个计数器，算出有多少有效数据
        int count = 0;
        for (int i = 0 ; i<arr1.length ; i++){        //循环行
            for (int j = 0 ; j <arr1.length ; j++ ){    //循环列
                if (arr1[i][j] != 0){        //将有效值填充到稀疏数组中
                    count++;
                    sparseArry[count][0] = i;
                    sparseArry[count][1] = j;
                    sparseArry[count][2] = arr1[i][j];
                }
            }
        }
        System.out.println();
        System.out.println("--------------得到稀疏数组-------------------------");
        for (int i = 0 ; i < sparseArry.length ; i++){
            System.out.printf("%d\t%d\t%d\t\n",sparseArry[i][0],sparseArry[i][1],sparseArry[i][2]);
        }


        //定义一个新数组用来将稀疏数组填充到二维数组
        int [][] arr2 = new int[sparseArry[0][0]][sparseArry[0][1]];
        for (int i = 1; i < sparseArry.length ; i++){
            arr2[sparseArry[i][0]][sparseArry[i][1]] = sparseArry[i][2];
        }
        //打印
        for (int [] row :arr2) {
            for (int data:row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}

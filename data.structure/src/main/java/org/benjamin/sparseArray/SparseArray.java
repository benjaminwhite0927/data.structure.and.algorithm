package org.benjamin.sparseArray;

public class SparseArray {
    public int[][] arrayToSparseArray(int[][] array) {
        // 获取Array的Row和Column
        int row = array.length;
        int column = array[0].length;

        // 1. 先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (array[i][j] !=0) {
                    sum++;
                }
            }
        }

        // 2. 创建对应的稀疏数组
        int[][] sparseArray = new int[sum+1][3];
        // 给稀疏数组赋值
        sparseArray[0][0] = row;
        sparseArray[0][1] = column;
        sparseArray[0][2] = sum;

        // 遍历二维数组，将非0的值存放到 sparseArr中
        int count = 0; //count 用于记录是第几个非0数据
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (array[i][j] != 0) {
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = array[i][j];
                }
            }
        }

        return sparseArray;
    }

    /**
     * 1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
     * 2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
     */
    public int[][] sparseArrayToArray(int[][] sparseArray) {
        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int array[][] = new int[sparseArray[0][0]][sparseArray[0][1]];
        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
        for(int i = 1; i < sparseArray.length; i++) {
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        return array;
    }
}

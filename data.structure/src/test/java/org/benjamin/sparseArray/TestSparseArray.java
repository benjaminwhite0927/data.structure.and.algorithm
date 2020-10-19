package org.benjamin.sparseArray;

import org.junit.Test;

import static org.benjamin.utils.PrintUtils.printArray;

public class TestSparseArray {
    @Test
    public void testSparseArray() {
        SparseArray sparseArray = new SparseArray();
        // 创建一个原始的二维数组 11 * 11
        // 0: 表示没有棋子， 1 表示 黑子 2 表蓝子
        int array[][] = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;
        array[4][5] = 2;

        // 输出原始的二维数组
        System.out.println("原始的二维数组~~");
        printArray(array);

        // 输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        int sb[][] = sparseArray.arrayToSparseArray(array);
        printArray(sb);

        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");
        printArray(sparseArray.sparseArrayToArray(sb));
    }
}

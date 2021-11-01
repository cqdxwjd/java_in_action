package tiku.niuke.huawei;

import java.util.*;

/**
 * Sudoku(数独)
 * <p>
 * 描述
 * <p>
 * 问题描述：数独（Sudoku）是一款大众喜爱的数字逻辑游戏。玩家需要根据9X9盘面上的已知数字，推算出所有剩余空格的数字，并且满足每一行、每一列、每一个3X3粗线宫内的数字均含1-9，并且不重复。
 * 例如：
 * 输入
 * 0 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 0 4 5 2 7 6 8 3 1
 * 输出
 * 5 9 2 4 8 1 7 6 3
 * 4 1 3 7 6 2 9 8 5
 * 8 6 7 3 5 9 4 1 2
 * 6 2 4 1 9 5 3 7 8
 * 7 5 9 8 4 3 1 2 6
 * 1 3 8 6 2 7 5 9 4
 * 2 7 1 5 3 8 6 4 9
 * 3 8 6 9 1 4 2 5 7
 * 9 4 5 2 7 6 8 3 1
 * 数据范围：输入一个 9*9 的矩阵
 * 输入描述：
 * <p>
 * 包含已知数字的9X9盘面数组[空缺位以数字0表示]
 * 输出描述：
 * <p>
 * 完整的9X9盘面数组
 *
 * @author wangjingdong
 * @date 2021/10/28 18:32
 * @Copyright © 云粒智慧 2018
 */
public class HJ44Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = in.nextInt();
            }
        }
        solveSudoku(sudoku);
        //输出二维矩阵
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println(sudoku[i][8]);//换行，每一行的最后一个数字
        }
    }

    public static boolean solveSudoku(int[][] sudoku) {
        //一个for循环遍历棋盘的行，一个for循环遍历棋盘的列，
        for (int i = 0; i < 9; i++) { // 遍历行
            for (int j = 0; j < 9; j++) { // 遍历列
                if (sudoku[i][j] != 0) { // 跳过原始数字
                    continue;
                }
                for (int k = 1; k <= 9; k++) { // (i, j) 这个位置放k是否合适
                    if (isValidSudoku(i, j, k, sudoku)) {
                        sudoku[i][j] = k;//将k放在（i，j）
                        if (solveSudoku(sudoku)) { // 如果找到合适一组立刻返回
                            return true;
                        }
                        sudoku[i][j] = 0;//回溯
                    }
                }
                // 9个数都试完了，都不行，那么就返回false
                return false;
            }
        }
        // 遍历完没有返回false，说明找到了合适棋盘位置了
        return true;
    }

    /**
     * 判断棋盘是否合法有如下三个维度:
     * 同行是否重复
     * 同列是否重复
     * 9宫格里是否重复
     */
    public static boolean isValidSudoku(int row, int col, int val, int[][] sudoku) {
        // 同行是否重复
        for (int i = 0; i < 9; i++) {
            if (sudoku[row][i] == val) {
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++) {
            if (sudoku[j][col] == val) {
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (sudoku[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}

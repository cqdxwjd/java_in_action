package tiku.niuke.huawei;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

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
public class HJ44Main {
    // 表示矩阵中一个元素的行索引和列索引
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[][] sudoku = new int[9][9];
            // 将待确定值的元素加入到队列中
            LinkedBlockingQueue<Point> queue = new LinkedBlockingQueue<>();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sudoku[i][j] = sc.nextInt();
                    if (sudoku[i][j] == 0) {
                        queue.offer(new Point(i, j));
                    }
                }
            }
            while (!queue.isEmpty()) {
                HashSet<Integer> nums = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
                Point point = queue.poll();
                if (point == null) {
                    break;
                }
                Set<Integer> allNums = getNums(sudoku, point);
                // 求差集，如果结果nums集合只剩下1个值，那么就是矩阵中当前元素应该填入的值，否则继续循环。
                nums.removeAll(allNums);
                int x = point.getX();
                int y = point.getY();
                Iterator<Integer> iterator = nums.iterator();
                if (nums.size() == 1) {
                    sudoku[x][y] = iterator.next();
                } else {
                    // 有无限循环
                    queue.offer(point);
                }
            }
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (j == 8) {
                        System.out.print(sudoku[i][j]);
                    } else {
                        System.out.print(sudoku[i][j] + " ");
                    }
                }
                System.out.println();
            }
        }
        sc.close();
    }

    // 得到矩阵中某个元素相邻的所有数字
    private static Set<Integer> getNums(int[][] sudoku, Point point) {
        HashSet<Integer> set = new HashSet<>();
        int x = point.getX();
        int y = point.getY();
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] != 0) {
                set.add(sudoku[x][i]);
            }
            if (sudoku[i][y] != 0) {
                set.add(sudoku[i][y]);
            }
        }
        for (int i = x / 3 * 3; i < x / 3 * 3 + 3; i++) {
            for (int j = y / 3 * 3; j < y / 3 * 3 + 3; j++) {
                if (sudoku[i][j] != 0) {
                    set.add(sudoku[i][j]);
                }
            }
        }
        return set;
    }
}

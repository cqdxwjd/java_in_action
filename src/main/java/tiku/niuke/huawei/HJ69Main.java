package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 矩阵乘法
 * @author wangjingdong
 * @date 2021/11/4 10:54
 * @Copyright © 云粒智慧 2018
 */
public class HJ69Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            int[][] arrA = new int[x][y];
            int[][] arrB = new int[y][z];
            int[][] arrC = new int[x][z];
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < y; j++) {
                    arrA[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < y; i++) {
                for (int j = 0; j < z; j++) {
                    arrB[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z; j++) {
                    arrC[i][j] = 0;
                    for (int k = 0; k < y; k++) {
                        arrC[i][j] += arrA[i][k] * arrB[k][j];
                    }
                }
            }
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < z - 1; j++) {
                    System.out.print(arrC[i][j] + " ");
                }
                System.out.println(arrC[i][z - 1]);
            }
        }
        sc.close();
    }
}

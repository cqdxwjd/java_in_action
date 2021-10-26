package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 蛇形矩阵
 * <p>
 * 描述
 * <p>
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * 例如，当输入5时，应该输出的三角形为：
 * 1 3 6 10 15
 * 2 5 9 14
 * 4 8 13
 * 7 12
 * 11
 * <p>
 * 请注意本题含有多组样例输入。
 * <p>
 * 输入描述：
 * <p>
 * 输入正整数N（N不大于100）
 * 输出描述：
 * <p>
 * 输出一个N行的蛇形矩阵。
 * 示例1
 * <p>
 * 输入：
 * 4
 * 输出：
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 *
 * @author wangjingdong
 * @date 2021/10/26 14:23
 * @Copyright © 云粒智慧 2018
 */
public class HJ35Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    System.out.print((j + 1) * (j + 2) / 2 - i);
                    System.out.print(" ");
                }
                System.out.println();
            }
        }
        sc.close();
    }
}

package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 放苹果
 * <p>
 * 描述
 * <p>
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 * <p>
 * 数据范围: 0<=m<=10,1<=n<=10.
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * 输入描述：
 * <p>
 * 输入两个int整数
 * 输出描述：
 * <p>
 * 输出结果，int型
 * 示例1
 * <p>
 * 输入：
 * 7 3
 * 输出：
 * 8
 *
 * @author wangjingdong
 * @date 2021/11/2 10:57
 * @Copyright © 云粒智慧 2018
 */
public class HJ61Main {
    public static int getNum(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
        } else {
            return getNum(m, n - 1) + getNum(m - n, n);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(getNum(m, n));
        }
        sc.close();
    }
}

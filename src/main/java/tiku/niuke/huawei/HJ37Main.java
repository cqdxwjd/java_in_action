package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 统计每个月兔子的总数
 * <p>
 * 描述
 * <p>
 * 有一只兔子，从出生后第3个月起每个月都生一只兔子，小兔子长到第三个月后每个月又生一只兔子，假如兔子都不死，问第n个月的兔子总数为多少？
 * <p>
 * 本题有多组数据。
 * 输入描述：
 * <p>
 * 多行输入，一行输入一个int型整数表示第n个月
 * 输出描述：
 * <p>
 * 每一行输出对应的兔子总数
 * 示例1
 * <p>
 * 输入：
 * 1
 * 2
 * 3
 * 4
 * 5
 * 9
 * 输出：
 * 1
 * 1
 * 2
 * 3
 * 5
 * 34
 *
 * @author wangjingdong
 * @date 2021/10/26 18:00
 * @Copyright © 云粒智慧 2018
 */
public class HJ37Main {
    public static int getNum(int month) {
        if (month == 1) {
            return 1;
        }
        if (month == 2) {
            return 1;
        }
        return getNum(month - 1) + getNum(month - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int month = sc.nextInt();
            System.out.println(getNum(month));
        }
        sc.close();
    }
}

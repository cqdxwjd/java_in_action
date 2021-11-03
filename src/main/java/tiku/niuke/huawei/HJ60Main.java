package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 查找组成一个偶数最接近的两个素数
 * <p>
 * 描述
 * <p>
 * 任意一个偶数（大于2）都可以由2个素数组成，组成偶数的2个素数有很多种情况，本题目要求输出组成指定偶数的两个素数差值最小的素数对。
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * 数据范围：输入的数据满足 2<=n<=1000
 * 输入描述：
 * <p>
 * 输入一个偶数
 * 输出描述：
 * <p>
 * 输出两个素数
 * 示例1
 * <p>
 * 输入：
 * 20
 * 输出：
 * 7
 * 13
 * 示例2
 * <p>
 * 输入：
 * 2
 * 输出：
 * 1
 * 1
 *
 * @author wangjingdong
 * @date 2021/11/2 10:35
 * @Copyright © 云粒智慧 2018
 */
public class HJ60Main {
    public static boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            for (int i = n / 2; i > 0; i--) {
                if (i % 2 != 0) {
                    if (isPrime(i) && isPrime(n - i)) {
                        System.out.println(i);
                        System.out.println(n - i);
                        break;
                    }
                }
            }
        }
        sc.close();
    }
}

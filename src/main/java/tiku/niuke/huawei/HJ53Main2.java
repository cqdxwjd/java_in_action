package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/11/1 16:44
 * @Copyright © 云粒智慧 2018
 */
public class HJ53Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 1 || n == 2) {
                System.out.println(-1);
            } else {
                if (n % 2 != 0) {
                    System.out.println(2);
                } else {// 第2个数为奇数
                    int m = n / 2;
                    if (m % 2 == 0) {// 第3个数为偶数
                        System.out.println(3);
                    } else {
                        System.out.println(4);
                    }
                }
            }
        }
        sc.close();
    }
}

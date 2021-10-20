package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/19 16:14
 * @Copyright © 云粒智慧 2018
 */
public class HJ15Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = Integer.toBinaryString(n);
        byte[] bytes = s.getBytes();
        int count = 0;
        for (byte b : bytes) {
            if (b == 49) {
                count++;
            }
        }
        System.out.println(count);
    }
}

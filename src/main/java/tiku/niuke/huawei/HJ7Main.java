package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/12 14:45
 * @Copyright © 云粒智慧 2018
 */
public class HJ7Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double v = sc.nextDouble();
        System.out.println(Math.round(v));
        sc.close();
    }
}

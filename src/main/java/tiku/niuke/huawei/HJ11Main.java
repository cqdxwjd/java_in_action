package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/19 15:30
 * @Copyright © 云粒智慧 2018
 */
public class HJ11Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("");
        for (int i = split.length - 1; i >= 0; i--) {
            System.out.print(split[i]);
        }
    }
}

package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/11 11:22
 * @Copyright © 云粒智慧 2018
 */
public class HJ2Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine().toLowerCase();
        char c = sc.nextLine().toLowerCase().charAt(0);
        int count = 0;
        for (char c1 : line.toCharArray()) {
            if (c1 == c) {
                count++;
            }
        }
        System.out.println(count);
    }
}

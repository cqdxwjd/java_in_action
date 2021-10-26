package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/19 15:35
 * @Copyright © 云粒智慧 2018
 */
public class HJ13Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(split[i]);
            } else {
                sb.append(split[i]).append(" ");
            }
        }
        System.out.println(sb);
        sc.close();
    }
}

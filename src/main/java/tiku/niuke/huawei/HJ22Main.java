package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/21 18:30
 * @Copyright © 云粒智慧 2018
 */
public class HJ22Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int i = n / 2;
            System.out.println(i);
        }
        sc.close();
    }
}

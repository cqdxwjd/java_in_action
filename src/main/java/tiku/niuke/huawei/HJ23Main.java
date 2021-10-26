package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/22 10:31
 * @Copyright © 云粒智慧 2018
 */
public class HJ23Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.next();
            int min = 20;
            int[] num = new int[128];
            byte[] bytes = line.getBytes();
            for (byte b : bytes) {
                num[b]++;
            }
            for (int j : num) {
                if (j != 0 && j < min) {
                    min = j;
                }
            }
            for (byte b : bytes) {
                if (num[b] != min) {
                    System.out.print((char) b);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}

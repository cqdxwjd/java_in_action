package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/11 11:55
 * @Copyright © 云粒智慧 2018
 */
public class HJ4Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            while (line.length() > 8) {
                System.out.println(line.substring(0, 8));
                line = line.substring(8);
            }
            int n = 8 - line.length();
            StringBuilder finalLine = new StringBuilder(line);
            for (int i = 0; i < n; i++) {
                finalLine.append("0");
            }
            System.out.println(finalLine);
        }
        sc.close();
    }
}

package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/21 17:54
 * @Copyright © 云粒智慧 2018
 */
public class HJ21Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.next();
            StringBuilder sb = new StringBuilder();
            for (byte b : line.getBytes()) {
                if (b >= 97 && b <= 99) {
                    sb.append("2");
                } else if (b >= 100 && b <= 102) {
                    sb.append("3");
                } else if (b >= 103 && b <= 105) {
                    sb.append("4");
                } else if (b >= 106 && b <= 108) {
                    sb.append("5");
                } else if (b >= 109 && b <= 111) {
                    sb.append("6");
                } else if (b >= 112 && b <= 115) {
                    sb.append("7");
                } else if (b >= 116 && b <= 118) {
                    sb.append("8");
                } else if (b >= 119 && b <= 122) {
                    sb.append("9");
                } else if (b >= 65 && b < 90) {
                    b += 33;
                    sb.append((char) b);
                } else if (b == 90) {
                    sb.append("a");
                } else {
                    sb.append((char) b);
                }
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}

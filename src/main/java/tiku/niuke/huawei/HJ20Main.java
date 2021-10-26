package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/21 15:48
 * @Copyright © 云粒智慧 2018
 */
public class HJ20Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String line = sc.next();
            if (line.length() < 9) {
                System.out.println("NG");
                continue;
            }

            int low = 0, upper = 0, digit = 0, symbol = 0;
            byte[] bytes = line.getBytes();
            for (byte b : bytes) {
                if (b >= 48 && b <= 57) {
                    digit = 1;
                } else if (b >= 65 && b <= 90) {
                    upper = 1;
                } else if (b >= 97 && b <= 122) {
                    low = 1;
                } else {
                    symbol = 1;
                }
            }
            if (low + upper + digit + symbol < 3) {
                System.out.println("NG");
                continue;
            }

            String result = "OK";
            for (int i = 0; i < line.length() - 2; i++) {
                String substring = line.substring(i, i + 3);
                if (i != line.lastIndexOf(substring)) {
                    result = "NG";
                    break;
                }
            }
            System.out.println(result);
        }
        sc.close();
    }
}

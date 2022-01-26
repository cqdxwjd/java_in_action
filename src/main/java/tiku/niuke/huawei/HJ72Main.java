package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2022/1/26 10:09
 * @Copyright © 云粒智慧 2018
 */
public class HJ72Main {
    final static int MONEY = 100;
    final static int CHICKEN = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            for (int i = 0; i < MONEY / 5; i++) {
                for (int j = 0; j < (MONEY - i * 5) / 3; j++) {
                    if ((MONEY - i * 5 - j * 3) * 3 + i + j == CHICKEN) {
                        System.out.println(i + " " + j + " " + (MONEY - i - j));
                    }
                }
            }
        }
        scanner.close();
    }
}

package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2022/1/26 17:08
 * @Copyright © 云粒智慧 2018
 */
public class HJ76Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            StringBuilder sb = new StringBuilder();
            int a1 = m * m - (m - 1);
            for (int i = 0; i < m; i++) {
                if (i == m - 1) {
                    sb.append(a1 + 2 * i);
                } else {
                    sb.append(a1 + 2 * i).append("+");
                }
            }
            System.out.println(sb);
        }
        scanner.close();
    }
}

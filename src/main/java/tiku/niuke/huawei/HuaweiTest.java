package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/24 12:46
 * @Copyright © 云粒智慧 2018
 */
public class HuaweiTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = 0;
            while ((n - 1) / 26 >= 1) {
                m = n % 26;
                n = (n - 1) / 26;
                if (m != 0) {
                    sb.append((char) (m + 96));
                } else {
                    sb.append((char) (m + 122));
                }
            }
            sb.append((char) (n + 96));
            System.out.println(sb.reverse());
        }
        sc.close();
    }
}

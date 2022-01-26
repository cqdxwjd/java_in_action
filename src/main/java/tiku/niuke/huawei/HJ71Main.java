package tiku.niuke.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 字符串通配符
 *
 * @author wangjingdong
 * @date 2021/11/5 09:17
 * @Copyright © 云粒智慧 2018
 */
public class HJ71Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String regex = sc.nextLine().toLowerCase();
            String line = sc.nextLine().toLowerCase();
            regex = regex.replaceAll("\\*+", "\\*");
            regex = regex.replaceAll("\\?", "[0-9A-Za-z]{1}");
            regex = regex.replaceAll("\\*", "[0-9A-Za-z]{0,}");
            regex = regex.replaceAll("\\.", "\\\\.");
            boolean result = line.matches(regex);
            System.out.println(result);
        }
        sc.close();
    }
}

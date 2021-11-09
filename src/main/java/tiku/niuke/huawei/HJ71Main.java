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
    public static boolean match(String regex, String line) {
        int rLength = regex.length();
        int lLength = line.length();
        String[] split = regex.split("[?|*]");
        System.out.println(Arrays.toString(split));
        for (String s : split) {
            if (!line.contains(s)) {
                return false;
            } else {
                if (rLength != lLength) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String regex = sc.nextLine().toLowerCase();
            String line = sc.nextLine().toLowerCase();
            boolean result = match(regex, line);
            System.out.println(result);
        }
        sc.close();
    }
}

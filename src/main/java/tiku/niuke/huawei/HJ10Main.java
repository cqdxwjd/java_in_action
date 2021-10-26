package tiku.niuke.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/19 12:21
 * @Copyright © 云粒智慧 2018
 */
public class HJ10Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split("");
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = split.length - 1; i >= 0; i--) {
            int digit = split[i].charAt(0);
            if (!set.contains(digit) && digit <= 127) {
                set.add(digit);
                count++;
            }
        }
        System.out.println(count);
        sc.close();
    }
}

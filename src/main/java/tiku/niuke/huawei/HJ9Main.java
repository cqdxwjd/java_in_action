package tiku.niuke.huawei;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/19 11:27
 * @Copyright © 云粒智慧 2018
 */
public class HJ9Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        String[] split = String.valueOf(n).split("");
        HashSet<Integer> set = new HashSet<>();
        for (int i = split.length - 1; i >= 0; i--) {
            Integer key = Integer.valueOf(split[i]);
            if (!set.contains(key)) {
                set.add(key);
                sb.append(split[i]);
            }
        }
        System.out.println(sb);
    }
}

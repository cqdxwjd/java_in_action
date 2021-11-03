package tiku.niuke.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 找出字符串中第一个只出现一次的字符
 * <p>
 * 描述
 * <p>
 * 找出字符串中第一个只出现一次的字符
 * <p>
 * <p>
 * 数据范围：输入的字符串长度满足 1<=n<=1000
 * <p>
 * 输入描述：
 * <p>
 * 输入几个非空字符串
 * 输出描述：
 * <p>
 * 输出第一个只出现一次的字符，如果不存在输出-1
 * 示例1
 * <p>
 * 输入：
 * asdfasdfo
 * aabb
 * 输出：
 * o
 * -1
 *
 * @author wangjingdong
 * @date 2021/11/2 10:16
 * @Copyright © 云粒智慧 2018
 */
public class HJ59Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] counts = new int[26];
            Arrays.fill(counts, 0);
            String line = sc.next();
            for (int i = 0; i < line.length(); i++) {
                int i1 = line.charAt(i) - 97;
                counts[i1]++;
            }
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] > 1) {
                    set.add((char) (i + 97));
                }
            }
            for (int i = 0; i < line.length(); i++) {
                if (!set.contains(line.charAt(i))) {
                    System.out.println(line.charAt(i));
                    break;
                }
                if (i == line.length() - 1) {
                    System.out.println(-1);
                }
            }
        }
        sc.close();
    }
}

package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 计算字符串的距离
 * <p>
 * 描述
 * <p>
 * Levenshtein 距离，又称编辑距离，指的是两个字符串之间，由一个转换成另一个所需的最少编辑操作次数。许可的编辑操作包括将一个字符替换成另一个字符，插入一个字符，删除一个字符。
 * 编辑距离的算法是首先由俄国科学家 Levenshtein 提出的，故又叫 Levenshtein Distance 。
 * Ex：
 * 字符串A: abcdefg
 * 字符串B: abcdef
 * 通过增加或是删掉字符 ”g” 的方式达到目的。这两种方案都需要一次操作。把这个操作所需要的次数定义为两个字符串的距离。
 * 要求：
 * 给定任意两个字符串，写出一个算法计算它们的编辑距离。
 * <p>
 * 数据范围：给定的字符串长度满足 1<=len(str)<=500
 * <p>
 * 本题含有多组输入数据。
 * <p>
 * <p>
 * 输入描述：
 * <p>
 * 每组用例一共2行，为输入的两个字符串
 * 输出描述：
 * <p>
 * 每组用例输出一行，代表字符串的距离
 * 示例1
 * <p>
 * 输入：
 * abcdefg
 * abcdef
 * abcde
 * abcdf
 * abcde
 * bcdef
 * 输出：
 * 1
 * 1
 * 2
 *
 * @author wangjingdong
 * @date 2021/11/1 14:33
 * @Copyright © 云粒智慧 2018
 */
public class HJ52Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String first = sc.next();
            String second = sc.next();
            int m = first.length();
            int n = second.length();
            int[][] lev = new int[m + 1][n + 1];
            int cost = 0;
            StringBuilder sb1 = new StringBuilder(first);
            StringBuilder sb2 = new StringBuilder(second);
            sb1.insert(0, 1);
            sb2.insert(0, 1);
            first = sb1.toString();
            second = sb2.toString();
            for (int i = 0; i < m + 1; i++) {
                lev[i][0] = i;
            }
            for (int j = 0; j < n + 1; j++) {
                lev[0][j] = j;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (first.charAt(i) == second.charAt(j)) {
                        cost = 0;
                    } else {
                        cost = 1;
                    }
                    lev[i][j] = Math.min(lev[i - 1][j - 1] + cost, Math.min(lev[i - 1][j] + 1, lev[i][j - 1] + 1));
                }
            }
            System.out.println(lev[m][n]);
        }
        sc.close();
    }
}

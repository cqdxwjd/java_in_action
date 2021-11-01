package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 截取字符串
 * <p>
 * 描述
 * <p>
 * 输入一个字符串和一个整数 k ，截取字符串的前k个字符并输出
 * <p>
 * 本题输入含有多组数据
 * <p>
 * 数据范围：字符串长度满足  ，
 * 输入描述：
 * <p>
 * 1.输入待截取的字符串
 * 2.输入一个正整数k，代表截取的长度
 * 输出描述：
 * <p>
 * 截取后的字符串
 * 示例1
 * <p>
 * 输入：
 * abABCcDEF
 * 6
 * 输出：
 * abABCc
 * 示例2
 * <p>
 * 输入：
 * ffIKEHauv
 * 1
 * bdxPKBhih
 * 6
 * 输出：
 * f
 * bdxPKB
 *
 * @author wangjingdong
 * @date 2021/10/31 13:38
 * @Copyright © 云粒智慧 2018
 */
public class HJ46Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.next();
            int length = sc.nextInt();
            System.out.println(line.substring(0, length));
        }
        sc.close();
    }
}

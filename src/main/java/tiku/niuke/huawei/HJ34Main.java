package tiku.niuke.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 图片整理
 * <p>
 * 描述
 * <p>
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
 * 本题含有多组样例输入。
 * <p>
 * 输入描述：
 * <p>
 * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 * 输出描述：
 * <p>
 * Lily的所有图片按照从小到大的顺序输出
 * 示例1
 * <p>
 * 输入：
 * Ihave1nose2hands10fingers
 * 输出：
 * 0112Iaadeeefghhinnnorsssv
 *
 * @author wangjingdong
 * @date 2021/10/26 14:20
 * @Copyright © 云粒智慧 2018
 */
public class HJ34Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            byte[] bytes = line.getBytes();
            Arrays.sort(bytes);
            String result = new String(bytes);
            System.out.println(result);
        }
        sc.close();
    }
}

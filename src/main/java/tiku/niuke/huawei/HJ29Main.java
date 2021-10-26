package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 描述
 * <p>
 * 1、对输入的字符串进行加解密，并输出。
 * 2、加密方法为：
 * 当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；
 * 当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；
 * 其他字符不做变化。
 * 3、解密方法为加密的逆过程。
 * <p>
 * 本题含有多组样例输入。
 * 输入描述：
 * <p>
 * 输入说明
 * 输入一串要加密的密码
 * 输入一串加过密的密码
 * 输出描述：
 * <p>
 * 输出说明
 * 输出加密后的字符
 * 输出解密后的字符
 * 示例1
 * <p>
 * 输入：
 * abcdefg
 * BCDEFGH
 * 输出：
 * BCDEFGH
 * abcdefg
 *
 * @author wangjingdong
 * @date 2021/10/25 14:54
 * @Copyright © 云粒智慧 2018
 */
public class HJ29Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String toEncrypt = sc.nextLine();
            String toDecrypt = sc.nextLine();
            byte[] bytes = toEncrypt.getBytes();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                if (b == 57) {
                    sb.append("0");
                } else if (b == 90) {
                    sb.append("a");
                } else if (b == 122) {
                    sb.append("A");
                } else if (b >= 48 && b < 57) {
                    sb.append((char) (b + 1));
                } else if (b >= 65 && b < 90) {
                    sb.append((char) (b + 33));
                } else if (b >= 97 && b < 122) {
                    sb.append((char) (b - 31));
                } else {
                    sb.append((char) b);
                }
            }
            StringBuilder sb2 = new StringBuilder();
            byte[] bytes2 = toDecrypt.getBytes();
            for (byte b : bytes2) {
                if (b == 48) {
                    sb2.append("9");
                } else if (b == 65) {
                    sb2.append("z");
                } else if (b == 97) {
                    sb2.append("Z");
                } else if (b > 48 && b <= 57) {
                    sb2.append((char) (b - 1));
                } else if (b > 65 && b <= 90) {
                    sb2.append((char) (b + 31));
                } else if (b > 97 && b <= 122) {
                    sb2.append((char) (b - 33));
                } else {
                    sb2.append((char) b);
                }
            }
            System.out.println(sb.toString());
            System.out.println(sb2.toString());
        }
        sc.close();
    }
}

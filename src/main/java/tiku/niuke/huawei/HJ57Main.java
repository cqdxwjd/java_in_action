package tiku.niuke.huawei;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * 高精度整数加法
 * <p>
 * 描述
 * <p>
 * 输入两个用字符串 str 表示的整数，求它们所表示的数之和。
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * 数据范围：1<=len(str)<=10000
 * 输入描述：
 * <p>
 * 输入两个字符串。保证字符串只含有'0'~'9'字符
 * 输出描述：
 * <p>
 * 输出求和后的结果
 * 示例1
 * <p>
 * 输入：
 * 9876543210
 * 1234567890
 * 输出：
 * 11111111100
 *
 * @author wangjingdong
 * @date 2021/11/2 09:32
 * @Copyright © 云粒智慧 2018
 */
public class HJ57Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            BigInteger first = sc.nextBigInteger();
            BigInteger second = sc.nextBigInteger();
            System.out.println(first.add(second));
        }
        sc.close();
    }
}

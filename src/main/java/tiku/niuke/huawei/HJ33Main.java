package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 整数与IP地址间的转换
 * <p>
 * 描述
 * <p>
 * 原理：ip地址的每段可以看成是一个0-255的整数，把每段拆分成一个二进制形式组合起来，然后把这个二进制数转变成
 * 一个长整数。
 * 举例：一个ip地址为10.0.3.193
 * 每段数字             相对应的二进制数
 * 10                   00001010
 * 0                    00000000
 * 3                    00000011
 * 193                  11000001
 * 组合起来即为：00001010 00000000 00000011 11000001,转换为10进制数就是：167773121，即该IP地址转换后的数字就是它了。
 * <p>
 * 本题含有多组输入用例，每组用例需要你将一个ip地址转换为整数、将一个整数转换为ip地址。
 * <p>
 * <p>
 * <p>
 * 输入描述：
 * <p>
 * 输入
 * 1 输入IP地址
 * 2 输入10进制型的IP地址
 * 输出描述：
 * <p>
 * 输出
 * 1 输出转换成10进制的IP地址
 * 2 输出转换后的IP地址
 * <p>
 * 示例1
 * <p>
 * 输入：
 * 10.0.3.193
 * 167969729
 * 输出：
 * 167773121
 * 10.3.3.193
 *
 * @author wangjingdong
 * @date 2021/10/26 11:30
 * @Copyright © 云粒智慧 2018
 */
public class HJ33Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ip = sc.next();
            long num = sc.nextLong();
            String[] split = ip.split("\\.");
            // 用来保存整数结果
            long res = 0;
            // 用来保存ip结果
            StringBuilder resIP = new StringBuilder();
            for (String s : split) {
                Long value = Long.valueOf(s, 10);
                res = res * 256 + value;
            }
            System.out.println(res);
            for (int i = 0; i < 4; i++) {
                resIP.insert(0, num % 256 + ".");
                num /= 256;
            }
            System.out.println(resIP.substring(0, resIP.length() - 1));
        }
        sc.close();
    }
}

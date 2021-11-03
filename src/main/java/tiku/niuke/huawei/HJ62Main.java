package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 查找输入整数二进制中1的个数
 * <p>
 * 描述
 * <p>
 * 输入一个正整数，计算它在二进制下的1的个数。
 * 注意多组输入输出！！！！！！
 * <p>
 * 数据范围：1<=n<=2^31-1
 * 输入描述：
 * <p>
 * 输入一个整数
 * 输出描述：
 * <p>
 * 计算整数二进制中1的个数
 * 示例1
 * <p>
 * 输入：
 * 5
 * 输出：
 * 2
 * 说明：
 * 5的二进制表示是101，有2个1
 * 示例2
 * <p>
 * 输入：
 * 0
 * 输出：
 * 0
 *
 * @author wangjingdong
 * @date 2021/11/2 13:15
 * @Copyright © 云粒智慧 2018
 */
public class HJ62Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String str = Integer.toBinaryString(n);
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '1') {
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}

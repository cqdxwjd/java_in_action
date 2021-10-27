package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 统计字符
 * <p>
 * 输入描述：
 * <p>
 * 输入一行字符串，可以有空格
 * 输出描述：
 * <p>
 * 统计其中英文字符，空格字符，数字字符，其他字符的个数
 * 示例1
 * <p>
 * 输入：
 * 1qazxsw23 edcvfr45tgbn hy67uj m,ki89ol.\\/;p0-=\\][
 * 输出：
 * 26
 * 3
 * 10
 * 12
 *
 * @author wangjingdong
 * @date 2021/10/27 10:30
 * @Copyright © 云粒智慧 2018
 */
public class HJ40Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            byte[] bytes = line.getBytes();
            int alphabet = 0, blank = 0, digit = 0, others = 0;
            for (byte b : bytes) {
                if ((b >= 65 && b <= 90) || (b >= 97 && b <= 122)) {
                    alphabet++;
                } else if (b == 32) {
                    blank++;
                } else if (b >= 48 && b <= 57) {
                    digit++;
                } else {
                    others++;
                }
            }
            System.out.println(alphabet);
            System.out.println(blank);
            System.out.println(digit);
            System.out.println(others);
        }
        sc.close();
    }
}

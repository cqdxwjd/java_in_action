package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 描述
 * <p>
 * Catcher是MCA国的情报员，他工作时发现敌国会用一些对称的密码进行通信，比如像这些ABBA，ABA，A，123321，但是他们有时会在开始或结束时加入一些无关的字符以防止别国破解。
 * 比如进行下列变化 ABBA->12ABBA,ABA->ABAKK,123321->51233214　。
 * 因为截获的串太长了，而且存在多种可能的情况（abaaab可看作是aba,或baaab的加密形式），Cathcer的工作量实在是太大了，他只能向电脑高手求助，你能帮Catcher找出最长的有效密码串吗？
 * <p>
 * 输入描述：
 * <p>
 * 输入一个字符串（字符串的长度不超过2500）
 * 输出描述：
 * <p>
 * 返回有效密码串的最大长度
 * 示例1
 * <p>
 * 输入：
 * ABBA
 * 输出：
 * 4
 * 示例2
 * <p>
 * 输入：
 * ABBBA
 * 输出：
 * 5
 * 示例3
 * <p>
 * 输入：
 * 12HHHHA
 * 输出：
 * 4
 *
 * @author wangjingdong
 * @date 2021/10/26 10:46
 * @Copyright © 云粒智慧 2018
 */
public class HJ32Main {
    /**
     * 找出奇数或者偶数个数的最长回文串，当l=r时，找奇数个数回文串；当l=r-1时，找偶数个数回文串。
     *
     * @param line 原始字符串
     * @param l    起始左指针
     * @param r    起始右指针
     * @return 最大回文子串
     */
    public static String findMax(String line, int l, int r) {
        while (l >= 0 && r <= line.length() - 1 && line.charAt(l) == line.charAt(r)) {
            l -= 1;
            r += 1;
        }
        return line.substring(l + 1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 输入字符串
            String line = sc.nextLine();
            int max = 0;
            for (int i = 0; i < line.length(); i++) {
                // 找奇数个数回文串
                max = Math.max(findMax(line, i, i).length(), max);
                // 找偶数个数回文串
                max = Math.max(findMax(line, i, i + 1).length(), max);
            }
            System.out.println(max);
        }
        sc.close();
    }
}

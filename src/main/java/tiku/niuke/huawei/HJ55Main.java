package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 挑7
 * <p>
 * 描述
 * <p>
 * 输出小于 n 的与 7 有关数字的个数，包括 7 的倍数，还有包含 7 的数字（如 17 ，27 ，37 ... 70 ，71 ，72 ，73...）的个数（一组测试用例里可能有多组数据，请注意处理）
 * <p>
 * 数据范围：1<=n<=30000
 * <p>
 * 本题有多组输入
 * 输入描述：
 * <p>
 * 多组输入每组输入 1 个正整数 N 。( N 不大于 30000 )
 * 输出描述：
 * <p>
 * 不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
 * 示例1
 * <p>
 * 输入：
 * 20
 * 10
 * 输出：
 * 3
 * 1
 *
 * @author wangjingdong
 * @date 2021/11/1 17:19
 * @Copyright © 云粒智慧 2018
 */
public class HJ55Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int count = 0;
            int n = sc.nextInt();
            for (int i = 6; i <= n; i++) {
                if (Integer.toString(i).contains("7") || i % 7 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}

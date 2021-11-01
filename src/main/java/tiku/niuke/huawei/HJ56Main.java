package tiku.niuke.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 完全数计算
 * <p>
 * 描述
 * <p>
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。
 * <p>
 * 输入n，请输出n以内(含n)完全数的个数。
 * <p>
 * 数据范围：1<=n<=5*10^5
 * <p>
 * 本题输入含有多组样例。
 * 输入描述：
 * <p>
 * 输入一个数字n
 * 输出描述：
 * <p>
 * 输出不超过n的完全数的个数
 * 示例1
 * <p>
 * 输入：
 * 1000
 * 7
 * 100
 * 输出：
 * 3
 * 1
 * 2
 *
 * @author wangjingdong
 * @date 2021/11/1 17:24
 * @Copyright © 云粒智慧 2018
 */
public class HJ56Main {
    public static ArrayList<Integer> getFactors(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int count = 0;
            for (int i = 2; i <= n; i++) {
                ArrayList<Integer> factors = getFactors(i);
                int sum = 0;
                for (Integer factor : factors) {
                    sum += factor;
                }
                if (sum == i) {
                    count++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}

package tiku.niuke.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 输入n个整数，输出其中最小的k个
 * <p>
 * 描述
 * <p>
 * 输入n个整数，输出其中最小的k个整数并按升序输出
 * <p>
 * 本题有多组输入样例
 * <p>
 * 数据范围：1<=n<=1000 ，输入的整数满足 1<=val<=10000
 * 输入描述：
 * <p>
 * 第一行输入两个整数n和k
 * 第二行输入一个整数数组
 * 输出描述：
 * <p>
 * 输出一个从小到大排序的整数数组
 * 示例1
 * <p>
 * 输入：
 * 5 2
 * 1 3 5 7 2
 * 输出：
 * 1 2
 *
 * @author wangjingdong
 * @date 2021/11/2 09:43
 * @Copyright © 云粒智慧 2018
 */
public class HJ58Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < k; i++) {
                if (i != k - 1) {
                    System.out.print(arr[i] + " ");
                } else {
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}

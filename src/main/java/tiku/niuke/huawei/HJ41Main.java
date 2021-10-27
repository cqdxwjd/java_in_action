package tiku.niuke.huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 称砝码
 * <p>
 * 描述
 * <p>
 * 现有一组砝码，重量互不相等，分别为m1,m2,m3…mn；
 * 每种砝码对应的数量为x1,x2,x3...xn。现在要用这些砝码去称物体的重量(放在同一侧)，问能称出多少种不同的重量。
 * 注：
 * 称重重量包括0
 * <p>
 * 输入描述：
 * <p>
 * 输入包含多组测试数据。
 * 对于每组测试数据：
 * 第一行：n --- 砝码数(范围[1,10])
 * 第二行：m1 m2 m3 ... mn --- 每个砝码的重量(范围[1,2000])
 * 第三行：x1 x2 x3 .... xn --- 每个砝码的数量(范围[1,6])
 * 输出描述：
 * <p>
 * 利用给定的砝码可以称出的不同的重量数
 * 示例1
 * <p>
 * 输入：
 * 2
 * 1 2
 * 2 1
 * 输出：
 * 5
 * 示例2
 * <p>
 * 输入：
 * 10
 * 4 185 35 191 26 148 149 3 172 147
 * 3 5 2 1 5 5 3 1 4 2
 * 输出：
 * 3375
 *
 * @author wangjingdong
 * @date 2021/10/27 10:44
 * @Copyright © 云粒智慧 2018
 */
public class HJ41Main {
    public static void main(String[] args) {
//        tooslow();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] m = new int[n];
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                m[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
            }
            // 总砝码个数
            int xAll = 0;
            for (int j : x) {
                xAll += j;
            }
            int[] newM = new int[xAll];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < x[i]; j++) {
                    newM[count++] = m[i];
                }
            }
            // 用来排重的存放所有重量可能的集合
            HashSet<Integer> set = new HashSet<>();
            set.add(0);
            int t = 0;
            HashSet<Integer> temp = new HashSet<>();
            while (t < xAll) {
                for (Integer i : set) {
                    int i1 = i + newM[t];
                    temp.add(i1);
                }
                set.addAll(temp);
                t++;
            }
            System.out.println(set.size());
        }
        sc.close();
    }

    private static void tooslow() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] m = new int[n];
            int[] x = new int[n];
            for (int i = 0; i < n; i++) {
                m[i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
            }
            // 总砝码个数
            int xAll = 0;
            for (int j : x) {
                xAll += j;
            }
            // 所有可能的砝码组合个数
            double pow = Math.pow(2, xAll);
            int[] newM = new int[xAll];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < x[i]; j++) {
                    newM[count++] = m[i];
                }
            }
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < pow; i++) {
                String s = Integer.toBinaryString(i);
                StringBuilder sb = new StringBuilder();
                if (s.length() < xAll) {
                    for (int j = 0; j < xAll - s.length(); j++) {
                        sb.append("0");
                    }
                    sb.append(s);
                } else {
                    sb.append(s);
                }
                byte[] bytes = sb.toString().getBytes();
                int sum = 0;
                for (int i1 = 0; i1 < bytes.length; i1++) {
                    if ((char) bytes[i1] == '1') {
                        sum += newM[i1];
                    }
                }
                set.add(sum);
            }
            System.out.println(set.size());
        }
        sc.close();
    }
}

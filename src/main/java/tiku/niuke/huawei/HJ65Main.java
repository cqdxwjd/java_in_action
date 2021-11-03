package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/11/2 15:36
 * @Copyright © 云粒智慧 2018
 */
public class HJ65Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.next();
            String str2 = sc.next();
            int m = str1.length();
            int n = str2.length();
            int[][] largest = new int[m][n];
            for (int i = 0; i < n; i++) {
                if (str1.charAt(0) == str2.charAt(i)) {
                    largest[0][i] = 1;
                } else {
                    largest[0][i] = 0;
                }
            }
            for (int i = 0; i < m; i++) {
                if (str1.charAt(i) == str2.charAt(0)) {
                    largest[i][0] = 1;
                } else {
                    largest[i][0] = 0;
                }
            }
            int max = 0;
            int index = Integer.MAX_VALUE;
            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    if (str1.charAt(i) == str2.charAt(j)) {
                        largest[i][j] = largest[i - 1][j - 1] + 1;
                    } else {
                        largest[i][j] = 0;
                    }
                    if (largest[i][j] > max) {
                        max = largest[i][j];
                        if (m >= n) {
                            index = j;
                        } else {
                            index = i;
                        }
                    } else if (largest[i][j] == max) {
                        if (m >= n) {
                            if (index > j) {
                                index = j;
                            }
                        } else {
                            if (index > i) {
                                index = i;
                            }
                        }
                    }
                }
            }
            if (m >= n) {
                System.out.println(str2.substring(index - max + 1, index + 1));
            } else {
                System.out.println(str1.substring(index - max + 1, index + 1));
            }
        }
        sc.close();
    }
}

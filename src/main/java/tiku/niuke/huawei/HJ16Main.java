package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/19 16:20
 * @Copyright © 云粒智慧 2018
 */
public class HJ16Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int v = 0, p = 0, q = 0;
        int[][] val = new int[n][3];
        int[][] wei = new int[n][3];
        for (int i = 0; i < n; i++) {
            v = sc.nextInt();
            p = sc.nextInt();
            q = sc.nextInt();
            if (q == 0) {
                val[i][0] = v;
                wei[i][0] = v * p;
            } else if (val[q - 1][1] == 0) {
                val[q - 1][1] = v;
                wei[q - 1][1] = v * p;
            } else {
                val[q - 1][2] = v;
                wei[q - 1][2] = v * p;
            }
        }
//        for (int i = 0; i < n; i++) {
//            System.out.println(wei[i][0] + "," + wei[i][1] + "," + wei[i][2]);
//        }
        int[] dp = new int[32000];
        for (int i = 0; i < n; i++) {
            for (int j = m; j > 0; j--) {
                if (val[i][0] <= j) {
                    dp[j] = Math.max(dp[j], wei[i][0] + dp[j - val[i][0]]);
                }
                if (val[i][1] != 0 && (val[i][0] + val[i][1] <= j)) {
                    dp[j] = Math.max(dp[j], wei[i][0] + wei[i][1] + dp[j - val[i][0] - val[i][1]]);
                }
                if (val[i][2] != 0 && (val[i][0] + val[i][2]) <= j) {
                    dp[j] = Math.max(dp[j], wei[i][0] + wei[i][2] + dp[j - val[i][0] - val[i][2]]);
                }
                if (val[i][2] != 0 && (val[i][0] + val[i][1] + val[i][2]) <= j) {
                    dp[j] = Math.max(dp[j], wei[i][0] + wei[i][1] + wei[i][2] + dp[j - val[i][0] - val[i][1] - val[i][2]]);
                }
            }
        }
        System.out.println(dp[m]);
    }
}

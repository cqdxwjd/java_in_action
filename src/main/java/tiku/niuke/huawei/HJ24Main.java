package tiku.niuke.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/22 11:33
 * @Copyright © 云粒智慧 2018
 */
public class HJ24Main {
    // 计算每个人左边出现的最多人数
    // 时间复杂度O(n^2)
    public static int[] leftMax(int[] list) {
        int[] dp = new int[list.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < i; j++) {
                if (list[j] < list[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = sc.nextInt();
            }
            int[] list = new int[n];
            for (int i = 0; i < n; i++) {
                list[i] = height[n - 1 - i];
            }
            int[] left = leftMax(height);
            int[] right = leftMax(list);
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, left[i] + right[n - 1 - i] - 1);
            }
            System.out.println(n - max);
        }
        sc.close();
    }
}

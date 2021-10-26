package tiku.niuke.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/22 18:55
 * @Copyright © 云粒智慧 2018
 */
public class HJ28Main {
    /**
     * 判断一个数是否未素数
     */
    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean find(int odd, ArrayList<Integer> events, int[] used, int[] eventsMatch) {
        for (int i = 0; i < events.size(); i++) {
            if (isPrime(odd + events.get(i)) && used[i] == 0) {
                used[i] = 1;
                if (eventsMatch[i] == 0 || find(eventsMatch[i], events, used, eventsMatch)) {
                    eventsMatch[i] = odd;
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            ArrayList<Integer> evens = new ArrayList<>();// 偶数列表
            ArrayList<Integer> odds = new ArrayList<>();// 奇数列表
            for (int i = 0; i < n; i++) {
                if ((arr[i] & 1) != 1) {
                    evens.add(arr[i]);
                } else {
                    odds.add(arr[i]);
                }
            }
            int[] eventsMatch = new int[evens.size()];
            int result = 0;
            for (Integer odd : odds) {
                int[] used = new int[evens.size()];
                if (find(odd, evens, used, eventsMatch)) {
                    result++;
                }
            }
            System.out.println(result);
        }
        sc.close();
    }
}

package tiku.niuke.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2022/2/8 09:24
 * @Copyright © 云粒智慧 2018
 */
public class HJ77Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            System.out.println(Arrays.toString(arr));
            LinkedList<Integer> vector = new LinkedList<>();
        }
        scanner.close();
    }
}

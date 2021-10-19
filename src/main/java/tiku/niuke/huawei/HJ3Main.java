package tiku.niuke.huawei;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @author wangjingdong
 * @date 2021/10/11 11:41
 * @Copyright © 云粒智慧 2018
 */
public class HJ3Main {
    public static void main(String[] args) {
        TreeSet<Integer> set = null;
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            set = new TreeSet<>();
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                set.add(sc.nextInt());
            }
            for (Integer integer : set) {
                System.out.println(integer);
            }
        }
    }
}

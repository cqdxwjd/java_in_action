package tiku.niuke.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/19 15:45
 * @Copyright © 云粒智慧 2018
 */
public class HJ14Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            String line = sc.nextLine();
            if (!line.isEmpty()) {
                list.add(line);
            }
        }
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }
}

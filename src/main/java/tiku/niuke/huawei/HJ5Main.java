package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/12 14:10
 * @Copyright © 云粒智慧 2018
 */
public class HJ5Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String line = sc.nextLine().substring(2);
            Integer n = Integer.valueOf(line, 16);
            System.out.println(n);
        }
        sc.close();
    }
}

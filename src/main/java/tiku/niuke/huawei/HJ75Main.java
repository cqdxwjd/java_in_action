package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2022/1/26 16:41
 * @Copyright © 云粒智慧 2018
 */
public class HJ75Main {
    public static void main(String[] args) {
        int max = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            int fLength = first.length();
            int sLength = second.length();
            if (fLength <= sLength) {
                for (int i = 0; i < fLength; i++) {
                    for (int j = i; j < fLength; j++) {
                        if (second.contains(first.substring(i, j + 1))) {
                            max = Math.max(max, j + 1 - i);
                        }
                    }
                }
            } else {
                for (int i = 0; i < sLength; i++) {
                    for (int j = i; j < sLength; j++) {
                        if (first.contains(second.substring(i, j + 1))) {
                            max = Math.max(max, j + 1 - i);
                        }
                    }
                }
            }
            System.out.println(max);
        }
        scanner.close();
    }
}

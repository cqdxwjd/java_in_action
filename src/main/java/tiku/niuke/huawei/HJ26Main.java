package tiku.niuke.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/22 17:18
 * @Copyright © 云粒智慧 2018
 */
public class HJ26Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            byte[] bytes = line.getBytes();
            StringBuilder sb = new StringBuilder();
            String[] arr = new String[26];
            Arrays.fill(arr, "");
            for (byte aByte : bytes) {
                if ((aByte >= 65 && aByte <= 90)) {
                    arr[aByte - 65] += (char) aByte;
                }
                if (aByte >= 97 && aByte <= 122) {
                    arr[aByte - 97] += (char) aByte;
                }
            }
            for (String s : arr) {
                sb.append(s);
            }
//            System.out.println(sb.toString());
            int index = 0;
            for (int i = 0; i < bytes.length; i++) {
                if ((bytes[i] >= 65 && bytes[i] <= 90) || (bytes[i] >= 97 && bytes[i] <= 122)) {
                    bytes[i] = (byte) sb.charAt(index++);
                }
            }
            String output = new String(bytes);
            System.out.println(output);
        }
        sc.close();
    }
}

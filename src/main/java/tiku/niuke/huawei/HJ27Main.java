package tiku.niuke.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/22 18:05
 * @Copyright © 云粒智慧 2018
 */
public class HJ27Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            String[] words = new String[num];
            for (int i = 0; i < num; i++) {
                words[i] = sc.next();
            }
            String str = sc.next();
            int k = sc.nextInt();
            ArrayList<String> brothers = new ArrayList<>();
            for (String word : words) {
                byte[] bytes = word.getBytes();
                Arrays.sort(bytes);
                byte[] strBytes = str.getBytes();
                Arrays.sort(strBytes);
                String sortedStr = new String(strBytes);
                String s = new String(bytes);
                if (sortedStr.equals(s) && !str.equals(word)) {
                    brothers.add(word);
                }
            }
            Collections.sort(brothers);
            if (brothers.size() > k) {
                System.out.println(brothers.size());
                System.out.println(brothers.get(k - 1));
            } else {
                System.out.println(brothers.size());
            }
        }
        sc.close();
    }
}

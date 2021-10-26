package tiku.niuke.huawei;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/20 15:18
 * @Copyright © 云粒智慧 2018
 */
public class HJ17Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int x = 0, y = 0;
            String[] sArray = s.split(";");
            String res = "[ADWS]\\d{1}\\d?";
            for (String value : sArray) {
                if (value.matches(res))
                    map.put(value.charAt(0), map.getOrDefault(value.charAt(0), 0) + Integer.parseInt(value.substring(1)));
            }
            x = x - map.get('A') + map.get('D');
            y = y - map.get('S') + map.get('W');
            System.out.println(x + "," + y);
            map.clear();
        }
        sc.close();
    }
}
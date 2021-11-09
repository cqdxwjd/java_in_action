package tiku.niuke.huawei;

import java.util.*;

//字符串匹配：1.先看匹配串是一个字符还是两个字符，一个字符时，看匹配的字符是单字符还是双字符，单字符可以，双字符不行
//2.匹配串是两个字符时，看匹配了几个，只能匹配一个的话，算成功。大于一种，算不成功

public class HJ66Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        map.put("reset", "reset what");
        map.put("reset board", "board fault");
        map.put("board add", "where to add");
        map.put("reboot backplane", "impossible");
        map.put("backplane abort", "install first");
        map.put("board delete", "no board at all");
        map.put("noMatch", "unknown command");
        Set<String[]> set = new HashSet<>();
        for (String s : map.keySet()) {
            set.add(s.split(" "));
        }

        while (sc.hasNext()) {
            String[] arr = sc.nextLine().split(" ");
            String res = "noMatch";
            int count = 0;
            for (String[] s : set) {
                if (arr.length == 1) {
                    if (s.length == 2)
                        continue;
                    else {
                        if (s[0].startsWith(arr[0]))
                            res = s[0];
                    }
                }
                if (arr.length == 2) {
                    if (s[0].startsWith(arr[0]) && s[1].startsWith(arr[1])) {
                        res = s[0] + " " + s[1];
                        count++;
                    }
                }
            }
            System.out.println(count > 1 ? "unknown command" : map.get(res));
        }
    }
}

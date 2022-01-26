package tiku.niuke.huawei;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2022/1/26 14:22
 * @Copyright © 云粒智慧 2018
 */
public class HJ74Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            ArrayList<String> list = new ArrayList<>();
            String[] params = line.split("\\s+\"");
            for (String param : params) {
                if (param.contains("\"")) {
                    if (param.endsWith("\"")) {
                        list.add(param.replace("\"", ""));
                    } else {
                        String[] split = param.split("\"\\s+");
                        list.add(split[0]);
                        for (int i = 1; i < split.length; i++) {
                            String[] split1 = split[i].split("\\s+");
                            list.addAll(Arrays.asList(split1));
                        }
                    }
                } else {
                    String[] split = param.split("\\s+");
                    list.addAll(Arrays.asList(split));
                }
            }
            System.out.println(list.size());
            for (String s : list) {
                System.out.println(s);
            }
        }
        scanner.close();
    }
}
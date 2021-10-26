package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/10/20 17:29
 * @Copyright © 云粒智慧 2018
 */
public class HJ18Main {
    public static boolean isValid(String s) {
        String[] seg = s.split("\\.");
        for (String s1 : seg) {
            if (s1.isEmpty() || Integer.parseInt(s1) > 255) {
                return false;
            }
        }
        return true;
    }

    public static boolean isMask(String s) {
        if (!isValid(s)) {
            return false;
        }
        String[] seg = s.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seg.length; i++) {
            seg[i] = Integer.toBinaryString(Integer.parseInt(seg[i]));
            if (seg[i].length() < 8) {//不足8位补齐0
                for (int j = 0; j < 8 - seg[i].length(); j++) {
                    sb.append("0");//补完零
                }
                sb.append(seg[i]);//再添加转换的2进制串
            } else {
                sb.append(seg[i]);//刚好8位直接添加，因为之前已经判断过ip的有效性，所以不可能超过8位
            }
        }
        return sb.toString().lastIndexOf("1") <= sb.toString().indexOf("0")
                && sb.toString().contains("1")
                && sb.toString().contains("0");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = 0, b = 0, c = 0, d = 0, e = 0, err = 0, p = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) {
                break;
            }
            String[] split = line.split("~");
            String[] ip = split[0].split("\\.");
            if (ip[0].equals("0") || ip[0].equals("127")) {
                continue;//跳过
            }
            if (!isMask(split[1])) {
                err++;
            } else {
                if (!isValid(split[0])) {
                    err++;
                } else {
                    if (Integer.parseInt(ip[0]) >= 1 && Integer.parseInt(ip[0]) <= 126) {
                        if (Integer.parseInt(ip[0]) == 10) {
                            p++;
                            a++;
                        } else {
                            a++;
                        }
                    }
                    if (Integer.parseInt(ip[0]) >= 128 && Integer.parseInt(ip[0]) <= 191) {
                        if (Integer.parseInt(ip[0]) == 172 && (Integer.parseInt(ip[1]) >= 16 && Integer.parseInt(ip[1]) <= 31)) {
                            p++;
                            b++;
                        } else {
                            b++;
                        }
                    }
                    if (Integer.parseInt(ip[0]) >= 192 && Integer.parseInt(ip[0]) <= 223) {
                        if (Integer.parseInt(ip[0]) == 192 && Integer.parseInt(ip[1]) == 168) {
                            p++;
                            c++;
                        } else {
                            c++;
                        }
                    }
                    if (Integer.parseInt(ip[0]) >= 224 && Integer.parseInt(ip[0]) <= 239) {
                        d++;
                    }
                    if (Integer.parseInt(ip[0]) >= 240 && Integer.parseInt(ip[0]) <= 255) {
                        e++;
                    }
                }
            }
        }
        System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + err + " " + p);
        sc.close();
    }
}

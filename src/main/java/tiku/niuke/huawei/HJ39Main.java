package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 判断两个IP是否属于同一子网
 * <p>
 * 描述
 * <p>
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。
 * 利用子网掩码可以判断两台主机是否在同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
 * 示例：
 * I P 地址　 192.168.0.1
 * 子网掩码　 255.255.255.0
 * 转化为二进制进行运算：
 * I P 地址　  11000000.10101000.00000000.00000001
 * 子网掩码　11111111.11111111.11111111.00000000
 * AND运算   11000000.10101000.00000000.00000000
 * 转化为十进制后为：
 * 192.168.0.0
 * <p>
 * I P 地址　 192.168.0.254
 * 子网掩码　 255.255.255.0
 * <p>
 * 转化为二进制进行运算：
 * I P 地址　11000000.10101000.00000000.11111110
 * 子网掩码  11111111.11111111.11111111.00000000
 * AND运算  11000000.10101000.00000000.00000000
 * 转化为十进制后为：
 * 192.168.0.0
 * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
 * <p>
 * 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
 * <p>
 * 注:
 * 有效掩码与IP的性质为：
 * 1. 掩码与IP每一段在 0 - 255 之间
 * 2. 掩码的二进制字符串前缀为网络号，都由‘1’组成；后缀为主机号，都由'0'组成
 * <p>
 * <p>
 * <p>
 * 输入描述：
 * <p>
 * 多组输入，一组3行，第1行是输入子网掩码、第2，3行是输入两个ip地址
 * 输出描述：
 * <p>
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2
 * 示例1
 * <p>
 * 输入：
 * 255.255.255.0
 * 192.168.224.256
 * 192.168.10.4
 * 255.0.0.0
 * 193.194.202.15
 * 232.43.7.59
 * 255.255.255.0
 * 192.168.0.254
 * 192.168.0.1
 * 输出：
 * 1
 * 2
 * 0
 * 说明：
 * 对于第一个例子:
 * 255.255.255.0
 * 192.168.224.256
 * 192.168.10.4
 * 其中IP:192.168.224.256不合法，输出1
 * <p>
 * 对于第二个例子:
 * 255.0.0.0
 * 193.194.202.15
 * 232.43.7.59
 * 2个与运算之后，不在同一个子网，输出2
 * <p>
 * 对于第三个例子，2个与运算之后，如题目描述所示，在同一个子网，输出0
 *
 * @author wangjingdong
 * @date 2021/10/26 18:33
 * @Copyright © 云粒智慧 2018
 */
public class HJ39Main {
    public static String toBinary(String addr) {
        String[] seg = addr.split("\\.");
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
        return sb.toString();
    }

    public static boolean isMask(String mask) {
        if (!isIP(mask)) {
            return false;
        }
        String s = toBinary(mask);
        return s.lastIndexOf("1") < s.indexOf("0")
                && s.contains("1")
                && s.contains("0");
    }

    public static boolean isIP(String ip) {
        String[] seg = ip.split("\\.");
        for (String s : seg) {
            if (Integer.parseInt(s) < 0 || Integer.parseInt(s) > 255) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String mask = sc.next();
            String ip1 = sc.next();
            String ip2 = sc.next();
            if (isMask(mask) && isIP(ip1) && isIP(ip2)) {
                String bMask = toBinary(mask);
                String bIP1 = toBinary(ip1);
                String bIP2 = toBinary(ip2);
                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                for (int i = 0; i < bMask.length(); i++) {
                    int and1 = bMask.charAt(i) & bIP1.charAt(i);
                    int and2 = bMask.charAt(i) & bIP2.charAt(i);
                    sb1.append((char) and1);
                    sb2.append((char) and2);
                }
                if (sb1.toString().equals(sb2.toString())) {
                    System.out.println(0);
                } else {
                    System.out.println(2);
                }
            } else {
                System.out.println(1);
            }
        }
        sc.close();
    }
}

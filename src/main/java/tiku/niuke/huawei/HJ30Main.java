package tiku.niuke.huawei;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 描述
 * <p>
 * 按照指定规则对输入的字符串进行处理。
 * 详细描述：
 * 第一步：将输入的两个字符串str1和str2进行前后合并。如给定字符串 "dec" 和字符串 "fab" ， 合并后生成字符串 "decfab"
 * <p>
 * 第二步：对合并后的字符串进行排序，要求为：下标为奇数的字符和下标为偶数的字符分别从小到大排序。这里的下标意思是字符在字符串中的位置。
 * 注意排序后在新串中仍需要保持原来的奇偶性。
 * 例如刚刚得到的字符串“decfab”，分别对下标为偶数的字符'd'、'c'、'a'和下标为奇数的字符'e'、'f'、'b'进行排序（生成 'a'、'c'、'd' 和 'b' 、'e' 、'f'），
 * 再依次分别放回原串中的偶数位和奇数位，新字符串变为“abcedf”
 * <p>
 * 第三步：对排序后的字符串进行对每一个字符的转换操作。对每个字符所代表的十六进制用二进制表示并倒序，然后再转换回十六进制对应的大写字符（字符 a~f 的十六进制对应十进制的10~15，大写同理）。
 * 如字符 '4'，其二进制为 0100 ，则翻转后为 0010 ，也就是 2 。转换后的字符为 '2'。
 * 如字符 ‘7’，其二进制为 0111 ，则翻转后为 1110 ，对应的十进制是15，转换为十六进制的大写字母为 'E'。
 * 如字符 'C'，代表的十进制是 12 ，其二进制为 1100 ，则翻转后为 0011，也就是3。转换后的字符是 '3'。
 * 根据这个转换规则，由第二步生成的字符串 “abcedf” 转换后会生成字符串 "5D37BF"
 * <p>
 * 注意本题含有多组样例输入。
 * <p>
 * <p>
 * 输入描述：
 * <p>
 * 本题含有多组样例输入。每组样例输入两个字符串，用空格隔开。
 * 输出描述：
 * <p>
 * 输出转化后的结果。每组样例输出一行。
 * 示例1
 * <p>
 * 输入：
 * dec fab
 * 输出：
 * 5D37BF
 * 示例2
 * <p>
 * 输入：
 * ab CD
 * 输出：
 * 3B5D
 * 说明：
 * 合并后为abCD，按奇数位和偶数位排序后是CDab（请注意要按ascii码进行排序，所以C在a前面，D在b前面），转换后为3B5D
 *
 * @author wangjingdong
 * @date 2021/10/25 17:15
 * @Copyright © 云粒智慧 2018
 */
public class HJ30Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] split = line.split(" ");
            String str1 = split[0];
            String str2 = split[1];
            String str = str1 + str2;
            ArrayList<Character> list1 = new ArrayList<>();
            ArrayList<Character> list2 = new ArrayList<>();
            byte[] bytes = str.getBytes();
            for (int i = 0; i < bytes.length; i++) {
                if (i % 2 == 0) {
                    list1.add((char) bytes[i]);
                } else {
                    list2.add((char) bytes[i]);
                }
            }
            Collections.sort(list1);
            Collections.sort(list2);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
                sb.append(list1.get(i));
                sb.append(list2.get(i));
            }
            if (list1.size() < list2.size()) {
                sb.append(list2.get(list2.size() - 1));
            } else if (list1.size() > list2.size()) {
                sb.append(list1.get(list1.size() - 1));
            }
//            System.out.println(sb.toString());
            byte[] temp = sb.toString().getBytes();
            StringBuilder result = new StringBuilder();
            for (byte b : temp) {
                if ((b >= 48 && b <= 57) || (b >= 65 && b <= 70) || (b >= 97 && b <= 102)) {
                    int digit = Character.digit(b, 16);
                    String s = Integer.toBinaryString(digit);
                    StringBuilder reverse = null;
                    if (s.length() < 4) {
                        reverse = new StringBuilder(s);
                        reverse.reverse();
                        for (int i = 0; i < 4 - s.length(); i++) {
                            reverse.append('0');
                        }
                    } else {
                        reverse = new StringBuilder(s).reverse();
                    }
                    int tempDight = Integer.parseInt(reverse.toString(), 2);
                    char c = Character.forDigit(tempDight, 16);
                    result.append(Character.toUpperCase(c));
                } else {
                    result.append((char) b);
                }
            }
            System.out.println(result);
        }
        sc.close();
    }
}

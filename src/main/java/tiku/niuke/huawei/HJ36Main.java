package tiku.niuke.huawei;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 字符串加密
 * <p>
 * 描述
 * <p>
 * 有一种技巧可以对数据进行加密，它使用一个单词作为它的密匙。下面是它的工作原理：首先，选择一个单词作为密匙，如TRAILBLAZERS。
 * 如果单词中包含有重复的字母，只保留第1个，其余几个丢弃。现在，修改过的那个单词属于字母表的下面，如下所示：
 * A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
 * T R A I L B Z E S C D F G H J K M N O P Q U V W X Y
 * 上面其他用字母表中剩余的字母填充完整。在对信息进行加密时，信息中的每个字母被固定于顶上那行，并用下面那行的对应字母一一取代原文的字母(字母字符的大小写状态应该保留)。
 * 因此，使用这个密匙，Attack AT DAWN(黎明时攻击)就会被加密为Tpptad TP ITVH。
 * 请实现下述接口，通过指定的密匙和明文得到密文。
 * <p>
 * 本题有多组输入数据。
 * <p>
 * 输入描述：
 * <p>
 * 先输入key和要加密的字符串
 * 输出描述：
 * <p>
 * 返回加密后的字符串
 * 示例1
 * <p>
 * 输入：
 * nihao
 * ni
 * 输出：
 * le
 *
 * @author wangjingdong
 * @date 2021/10/26 15:32
 * @Copyright © 云粒智慧 2018
 */
public class HJ36Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            byte[] keyBytes = sc.nextLine().getBytes();
            byte[] bytes = sc.nextLine().getBytes();
            HashMap<Character, Character> map = new HashMap<>(26);
            int cnt = 0;
            for (byte keyByte : keyBytes) {
                char c = (char) keyByte;
                if (!map.containsValue(c)) {
                    if (Character.isUpperCase(c)) {
                        map.put((char) (cnt + 65), c);
                        cnt++;
                    } else {
                        map.put((char) (cnt + 97), c);
                        cnt++;
                    }
                }
            }
            for (int i = 0; i < 26; i++) {
                if (Character.isUpperCase((char) keyBytes[0])) {
                    if (!map.containsValue((char) (i + 65))) {
                        map.put((char) (65 + cnt++), (char) (i + 65));
                    }
                } else {
                    if (!map.containsValue((char) (i + 97))) {
                        map.put((char) (97 + cnt++), (char) (i + 97));
                    }
                }
            }
            char[] res = new char[bytes.length];
            for (int i = 0; i < bytes.length; i++) {
                res[i] = map.getOrDefault((char) bytes[i], (char) bytes[i]);
            }
            System.out.println(new String(res));
        }
        sc.close();
    }
}

package tiku.niuke.huawei;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 描述
 * <p>
 * 对字符串中的所有单词进行倒排。
 * 说明：
 * 1、构成单词的字符只有26个大写或小写英文字母；
 * 2、非构成单词的字符均视为单词间隔符；
 * 3、要求倒排后的单词间隔符以一个空格表示；如果原字符串中相邻单词间有多个间隔符时，倒排转换后也只允许出现一个空格间隔符；
 * 4、每个单词最长20个字母；
 * 输入描述：
 * <p>
 * 输入一行以空格来分隔的句子
 * 输出描述：
 * <p>
 * 输出句子的逆序
 * 示例1
 * <p>
 * 输入：
 * I am a student
 * 输出：
 * student a am I
 * 示例2
 * <p>
 * 输入：
 * $bo*y gi!r#l
 * 输出：
 * l r gi y bo
 *
 * @author wangjingdong
 * @date 2021/10/26 10:30
 * @Copyright © 云粒智慧 2018
 */
public class HJ31Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 原字符串
            String line = sc.nextLine();
            // 使用正则表达式匹配非字母，然后分割字符串
            String[] split = line.split("([^a-zA-Z])+");
            ArrayList<String> list = new ArrayList<>();
            for (String s : split) {
                list.add(s.trim());
            }
            StringBuilder sb = new StringBuilder();
            for (int i = list.size() - 1; i >= 0; i--) {
                if (i == 0) {
                    sb.append(list.get(i));
                } else {
                    sb.append(list.get(i)).append(" ");
                }
            }
            System.out.println(sb.toString());
        }
        sc.close();
    }
}

package tiku.niuke.huawei;

import java.util.*;

/**
 * 学英语
 * <p>
 * 描述
 * <p>
 * Jessi初学英语，为了快速读出一串数字，编写程序将数字转换成英文：
 * <p>
 * 具体规则如下:
 * 1.在英语读法中三位数字看成一整体，后面再加一个计数单位。从最右边往左数，三位一单位，例如12,345 等
 * 2.每三位数后记得带上计数单位 分别是thousand, million, billion.
 * 3.公式：百万以下千以上的数 X thousand X, 10亿以下百万以上的数：X million X thousand X, 10 亿以上的数：X billion X million X thousand X.
 * 每个X分别代表三位数或两位数或一位数。
 * 4.在英式英语中百位数和十位数之间要加and，美式英语中则会省略，我们这个题目采用加上and，百分位为零的话，这道题目我们省略and
 * <p>
 * 下面再看几个数字例句：
 * 22: twenty two
 * 100:  one hundred
 * 145:  one hundred and forty five
 * 1,234:  one thousand two hundred and thirty four
 * 8,088:  eight thousand (and) eighty eight (注:这个and可加可不加，这个题目我们选择不加)
 * 486,669:  four hundred and eighty six thousand six hundred and sixty nine
 * 1,652,510:  one million six hundred and fifty two thousand five hundred and ten
 * <p>
 * 说明：
 * 数字为正整数，不考虑小数，转化结果为英文小写；
 * 保证输入的数据合法
 * 关键字提示：and，billion，million，thousand，hundred。
 * <p>
 * 数据范围：
 * <p>
 * 本题含有多组输入数据。
 * <p>
 * 输入描述：
 * <p>
 * 输入多行long型整数
 * 输出描述：
 * <p>
 * 输出相应的英文写法
 * 示例1
 * <p>
 * 输入：
 * 22
 * 100
 * 145
 * 1234
 * 8088
 * 486669
 * 1652510
 * 输出：
 * twenty two
 * one hundred
 * one hundred and forty five
 * one thousand two hundred and thirty four
 * eight thousand eighty eight
 * four hundred and eighty six thousand six hundred and sixty nine
 * one million six hundred and fifty two thousand five hundred and ten
 *
 * @author wangjingdong
 * @date 2021/10/27 18:46
 * @Copyright © 云粒智慧 2018
 */
public class HJ42Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Long> list = new ArrayList<>();
        while (sc.hasNextLong()) {
            list.add(sc.nextLong());
        }
        String[] digitToWord = {
                "zero", "one", "two", "three", "four",
                "five", "six", "seven", "eight", "nine",
                "ten", "eleven", "twelve", "thirteen", "fourteen",
                "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] nTen = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        for (Long l : list) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            while (l >= 10) {
                int mod = (int) (l % 10);
                l = l / 10;
                count++;
                if (mod != 0) {
                    if (count == 1) {
                        if (l % 10 == 1) {
                            sb.append(" and ").append(digitToWord[10 + mod]);
                            l = l / 10;
                            count++;
                        } else if (l % 10 == 0) {
                            sb.append(" and ").append(digitToWord[mod]);
                            l = l / 10;
                            count++;
                        } else {
                            sb.append(" ").append(digitToWord[mod]);

                        }
                    } else if (count == 2 || count == 5) {
                        if (l % 10 != 0) {
                            sb.insert(0, " and " + nTen[mod - 1]);
                        } else {
                            sb.insert(0, " " + nTen[mod - 1]);
                        }
                    } else if (count == 3 || count == 6) {
                        sb.insert(0, " " + digitToWord[mod] + " hundred");
                    } else if (count == 4) {
                        sb.insert(0, " " + digitToWord[mod] + " thousand");
                    }
                } else {
                    if (count == 5) {
                        sb.insert(0, " and");
                    }
                }
            }
            if (count == 1) {
                sb.insert(0, nTen[Math.toIntExact(l) - 1]);
            } else if (count == 2 || count == 5) {
                sb.insert(0, digitToWord[Math.toIntExact(l)] + " hundred");
            } else if (count == 3) {
                sb.insert(0, digitToWord[Math.toIntExact(l)] + " thousand");
            } else if (count == 4) {
                sb.insert(0, nTen[Math.toIntExact(l) - 1] + " thousand");
            } else if (count == 6) {
                sb.insert(0, digitToWord[Math.toIntExact(l)] + " million");
            }
            System.out.println(sb.toString());
            sc.close();
        }
    }
}

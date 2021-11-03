package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * DNA序列
 * <p>
 * 描述
 * <p>
 * 一个 DNA 序列由 A/C/G/T 四个字母的排列组合组成。 G 和 C 的比例（定义为 GC-Ratio ）是序列中 G 和 C 两个字母的总的出现次数除以总的字母数目（也就是序列长度）。
 * 在基因工程中，这个比例非常重要。因为高的 GC-Ratio 可能是基因的起始点。
 * 给定一个很长的 DNA 序列，以及限定的子串长度 N ，请帮助研究人员在给出的 DNA 序列中从左往右找出 GC-Ratio 最高且长度为 N 的第一个子串。
 * DNA序列为 ACGT 的子串有: ACG , CG , CGT 等等，但是没有 AGT ， CT 等等
 * <p>
 * 数据范围：字符串长度满足 1<=n<=1000 ，输入的字符串只包含 A/C/G/T 字母
 * 输入描述：
 * <p>
 * 输入一个string型基因序列，和int型子串的长度
 * 输出描述：
 * <p>
 * 找出GC比例最高的子串,如果有多个则输出第一个的子串
 * 示例1
 * <p>
 * 输入：
 * ACGT
 * 2
 * 输出：
 * CG
 * 说明：
 * ACGT长度为2的子串有AC,CG,GT3个，其中AC和GT2个的GC-Ratio都为0.5，CG为1，故输出CG
 * 示例2
 * <p>
 * 输入：
 * AACTGTGCACGACCTGA
 * 5
 * 输出：
 * GCACG
 * 说明：
 * 虽然CGACC的GC-Ratio也是最高，但它是从左往右找到的GC-Ratio最高的第2个子串，所以只能输出GCACG。
 *
 * @author wangjingdong
 * @date 2021/11/2 13:21
 * @Copyright © 云粒智慧 2018
 */
public class HJ63Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.next();
            int n = sc.nextInt();
            if (n >= line.length()) {
                System.out.println(line);
            } else {
                double max = 0;
                int index = 0;
                for (int i = 0; i <= line.length() - n; i++) {
                    String substring = line.substring(i, i + n);
                    int count = 0;
                    for (int j = 0; j < n; j++) {
                        if (substring.charAt(j) == 'G' || substring.charAt(j) == 'C') {
                            count++;
                        }
                    }
                    double ratio = 1.0 * count / n;
                    if (ratio > max) {
                        max = ratio;
                        index = i;
                    }
                }
                System.out.println(line.substring(index, index + n));
            }
        }
        sc.close();
    }
}

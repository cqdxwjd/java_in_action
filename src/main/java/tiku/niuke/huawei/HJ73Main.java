package tiku.niuke.huawei;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * 描述
 * <p>
 * 根据输入的日期，计算是这一年的第几天。
 * 保证年份为4位数且日期合法。
 * 进阶：时间复杂度：O(n)，空间复杂度：O(1)
 * 输入描述：
 * <p>
 * 输入一行，每行空格分割，分别是年，月，日
 * 输出描述：
 * <p>
 * 输出是这一年的第几天
 * 示例1
 * <p>
 * 输入：
 * 2012 12 31
 * 输出：
 * 366
 * 示例2
 * <p>
 * 输入：
 * 1982 3 4
 * 输出：
 * 63
 *
 * @author wangjingdong
 * @date 2022/1/26 11:37
 * @Copyright © 云粒智慧 2018
 */
public class HJ73Main {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        while (scanner.hasNext()) {
            int year = scanner.nextInt();
            int month = scanner.nextInt();
            int date = scanner.nextInt();
            long time = simpleDateFormat.parse(year + "-" + month + "-" + date).getTime();
            long time1 = simpleDateFormat.parse(year + "-01-01").getTime();
            System.out.println(Math.abs((time1 - time) / 1000 / 3600 / 24) + 1);
        }
        scanner.close();
    }
}
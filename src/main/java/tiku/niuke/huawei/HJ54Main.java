package tiku.niuke.huawei;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 表达式求值
 * <p>
 * 描述
 * <p>
 * 给定一个字符串描述的算术表达式，计算出结果值。
 * 输入字符串长度不超过 100 ，合法的字符包括 ”+, -, *, /, (, )” ， ”0-9” 。
 * <p>
 * 数据范围：运算过程中和最终结果均满足 |val|<=2^31-1 ，即只进行整型运算，确保输入的表达式合法
 * 输入描述：
 * <p>
 * 输入算术表达式
 * 输出描述：
 * <p>
 * 计算出结果值
 * 示例1
 * <p>
 * 输入：
 * 400+5
 * 输出：
 * 405
 *
 * @author wangjingdong
 * @date 2021/11/1 17:07
 * @Copyright © 云粒智慧 2018
 */
public class HJ54Main {
    public static int compute(String expr) {
        int i = 0;
        if ((i = expr.lastIndexOf('(')) != -1) {
            int j = expr.indexOf(')');
            while (i > j) {
                j = expr.indexOf(')', j + 1);
            }
            int compute = compute(expr.substring(i + 1, j));
            if (compute < 0) {
                String newExpr = expr.substring(0, i) + (-compute) + expr.substring(j + 1);
                if (!newExpr.contains("-") && !newExpr.contains("+") || newExpr.charAt(0) == '-') {
                    return -compute(newExpr);
                } else {
                    byte[] bytes = newExpr.getBytes();
                    for (int k = i - 1; k > 0; k--) {
                        if ((char) bytes[k] == '+') {
                            bytes[k] = '-';
                            break;
                        } else if ((char) bytes[k] == '-') {
                            bytes[k] = '+';
                            break;
                        }
                    }
                    return compute(new String(bytes));
                }
            }
            return compute(expr.substring(0, i) + compute + expr.substring(j + 1));
        }

        if (expr.contains("+") || expr.contains("-")) {
            String[] split = expr.split("[-|+]");
            byte[] bytes = expr.getBytes();
            LinkedList<Character> list = new LinkedList<>();
            if (split[0].equals("")) {
                split[0] = "0";
            }
            list.offer('+');
            for (byte aByte : bytes) {
                if ((char) aByte == '-' || (char) aByte == '+') {
                    list.offer((char) aByte);
                }
            }
            int sum = 0;
            for (String s : split) {
                Character symbol = list.poll();
                if (symbol == '-') {
                    sum -= compute(s);
                } else {
                    sum += compute(s);
                }
            }
            return sum;
        }
        if ((i = expr.indexOf('*')) != -1) {
            return compute(expr.substring(0, i)) * compute(expr.substring(i + 1));
        }
        if ((i = expr.indexOf('/')) != -1) {
            return compute(expr.substring(0, i)) / compute(expr.substring(i + 1));
        }
        return Integer.parseInt(expr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String expr = sc.next();
            int result = compute(expr);
            System.out.println(result);
        }
        sc.close();
    }
}

package tiku.niuke.huawei;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 四则运算
 * <p>
 * 描述
 * <p>
 * 输入一个表达式（用字符串表示），求这个表达式的值。
 * 保证字符串中的有效字符包括[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’。且表达式一定合法。
 * <p>
 * 数据范围：表达式计算结果和过程中满足 -1000<=val<=1000 ，字符串长度满足 1<=n<=1000
 * 输入描述：
 * <p>
 * 输入一个算术表达式
 * 输出描述：
 * <p>
 * 得到计算结果
 * 示例1
 * <p>
 * 输入：
 * 3+2*{1+2*[-4/(8-6)+7]}
 * 1+2*[-4/(8-6)+7]
 * -4/(8-6)+7
 * -4/2+7
 * 8-6*6
 * 输出：
 * 25
 *
 * @author wangjingdong
 * @date 2021/10/31 15:44
 * @Copyright © 云粒智慧 2018
 */
public class HJ50Main {
    public static int compute(String expr) {
        int i = 0;
        if ((i = expr.lastIndexOf('{')) != -1) {
            int j = expr.indexOf('}');
            while (i > j) {
                j = expr.indexOf('}', j + 1);
            }
            int compute = compute(expr.substring(i + 1, j));
            return compute(expr.substring(0, i) + compute + expr.substring(j + 1));
        }
        if ((i = expr.lastIndexOf('[')) != -1) {
            int j = expr.indexOf(']');
            while (i > j) {
                j = expr.indexOf(']', j + 1);
            }
            int compute = compute(expr.substring(i + 1, j));
            return compute(expr.substring(0, i) + compute + expr.substring(j + 1));
        }
        if ((i = expr.lastIndexOf('(')) != -1) {
            int j = expr.indexOf(')');
            while (i > j) {
                j = expr.indexOf(')', j + 1);
            }
            int compute = compute(expr.substring(i + 1, j));
            if (compute < 0) {
                String newExpr = expr.substring(0, i) + (-compute) + expr.substring(j + 1);
                if (!newExpr.contains("-") && !newExpr.contains("+")) {
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
            String expr = sc.nextLine();
            LinkedList<String> stack = new LinkedList<>();
            int compute = compute(expr);
            System.out.println(compute);
        }
        sc.close();
    }
}

package tiku.niuke.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wangjingdong
 * @date 2021/11/4 11:09
 * @Copyright © 云粒智慧 2018
 */
public class HJ70Main {
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int compute(String rule, List<Node> list) {
        int i = rule.lastIndexOf("(");
        int j = rule.indexOf(")");
        Node node1 = null;
        Node node2 = null;
        while (i > j) {
            j = rule.indexOf(")", j + 1);
        }
        if (i <= 0 && rule.length() == 4) {
            node1 = list.get(rule.charAt(1) - 65);
            node2 = list.get(rule.charAt(2) - 65);
            return node1.x * node1.y * node2.y;
        } else if (i <= 0 && rule.length() > 4) {
            return 0;
        } else {
            String sub = rule.substring(i + 1, j);
            node1 = list.get(sub.charAt(0) - 65);
            node2 = list.get(sub.charAt(sub.length() - 1) - 65);
            int init = 0;
            if (sub.length() == 2) {
                init = node1.x * node1.y * node2.y;
            }
            char c1 = rule.charAt(i - 1);
            char c2 = rule.charAt(j + 1);
            if (c2 >= 65 && c2 <= 90) {
                int last = j + 2;
                int index = j + 1;
                while (rule.charAt(last) >= 65 && rule.charAt(last) <= 90) {
                    index = last;
                    last++;
                }
                Node node = list.get(c2 - 65);
                Node node3 = list.get(rule.charAt(index) - 65);
                return init + node1.x * node.x * node3.y + compute(rule.substring(0, i) + sub + rule.substring(j + 1), list);
            } else if (c1 >= 65 && c1 <= 90) {
                Node node = list.get(c1 - 65);
                return init + node.x * node.y * node2.y + compute(rule.substring(0, i) + sub + rule.substring(j + 1), list);
            } else {
                return init + compute(rule.substring(0, i) + sub + rule.substring(j + 1), list);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            ArrayList<Node> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(new Node(sc.nextInt(), sc.nextInt()));
            }
            System.out.println(compute(sc.next(), list));
        }
        sc.close();
    }
}

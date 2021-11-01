package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 从单向链表中删除指定值的节点
 * <p>
 * 描述
 * <p>
 * 输入一个单向链表和一个节点的值，从单向链表中删除等于该值的节点，删除后如果链表中无节点则返回空指针。
 * 链表的值不能重复。
 * 构造过程，例如输入一行数据为:
 * 6 2 1 2 3 2 5 1 4 5 7 2 2
 * 则第一个参数6表示输入总共6个节点，第二个参数2表示头节点值为2，剩下的2个一组表示第2个节点值后面插入第1个节点值，为以下表示:
 * 1 2 表示为
 * 2->1
 * 链表为2->1
 * <p>
 * 3 2表示为
 * 2->3
 * 链表为2->3->1
 * <p>
 * 5 1表示为
 * 1->5
 * 链表为2->3->1->5
 * <p>
 * 4 5表示为
 * 5->4
 * 链表为2->3->1->5->4
 * <p>
 * 7 2表示为
 * 2->7
 * 链表为2->7->3->1->5->4
 * <p>
 * 最后的链表的顺序为 2 7 3 1 5 4
 * <p>
 * 最后一个参数为2，表示要删掉节点为2的值
 * 删除 结点 2
 * 则结果为 7 3 1 5 4
 * <p>
 * 数据范围：链表长度满足 1<=n<=1000 ，节点中的值满足 0<=val<=10000
 * <p>
 * 测试用例保证输入合法
 * <p>
 * 输入描述：
 * <p>
 * 输入一行，有以下4个部分：
 * 1 输入链表结点个数
 * 2 输入头结点的值
 * 3 按照格式插入各个结点
 * 4 输入要删除的结点的值
 * 输出描述：
 * <p>
 * 输出一行
 * 输出删除结点后的序列，每个数后都要加空格
 * 示例1
 * <p>
 * 输入：
 * 5 2 3 2 4 3 5 2 1 4 3
 * 输出：
 * 2 5 4 1
 * 说明：
 * 形成的链表为2->5->3->4->1
 * 删掉节点3，返回的就是2->5->4->1
 * 示例2
 * <p>
 * 输入：
 * 6 2 1 2 3 2 5 1 4 5 7 2 2
 * 输出：
 * 7 3 1 5 4
 * 说明：
 * 如题
 *
 * @author wangjingdong
 * @date 2021/10/31 13:41
 * @Copyright © 云粒智慧 2018
 */
public class HJ48Main {
    static class Node {
        int val;
        Node parent;
        Node child;

        public Node(int val, Node parent, Node child) {
            this.val = val;
            this.parent = parent;
            this.child = child;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int headVal = sc.nextInt();
            Node head = new Node(headVal, null, null);
            for (int i = 0; i < n - 1; i++) {
                int first = sc.nextInt();
                int second = sc.nextInt();
                Node cur = head;
                while (cur != null) {
                    if (second == cur.val) {
                        Node next = cur.child;
                        cur.child = new Node(first, cur, next);
                        if (next != null) {
                            next.parent = cur.child;
                        }
                        break;
                    } else {
                        cur = cur.child;
                    }
                }
            }
            int target = sc.nextInt();
            Node cur = head;
            while (cur != null) {
                if (cur.val == target) {
                    if (cur == head) {
                        head = head.child;
                    } else {
                        cur.parent.child = cur.child;
                        cur.child.parent = cur.parent;
                    }
                    break;
                } else {
                    cur = cur.child;
                }
            }

            Node p = head;
            while (p != null) {
                if (p.child != null) {
                    System.out.print(p.val + " ");
                    p = p.child;
                } else {
                    System.out.print(p.val);
                    p = p.child;
                }
            }
        }
        sc.close();
    }
}

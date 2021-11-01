package tiku.niuke.huawei;

import java.util.Scanner;

/**
 * 输出单向链表中倒数第k个结点
 * <p>
 * 描述
 * <p>
 * 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。
 * 链表结点定义如下：
 * struct ListNode
 * {
 * int       m_nKey;
 * ListNode* m_pNext;
 * };
 * <p>
 * <p>
 * 正常返回倒数第k个结点指针，异常返回空指针
 * <p>
 * 数据范围：链表长度满足 1<=n<=1000 ，k<=n ，链表中数据满足 0<=val<=10000
 * <p>
 * 本题有多组样例输入。
 * <p>
 * <p>
 * 输入描述：
 * <p>
 * 输入说明
 * 1 输入链表结点个数
 * 2 输入链表的值
 * 3 输入k的值
 * 输出描述：
 * <p>
 * 输出一个整数
 * 示例1
 * <p>
 * 输入：
 * 8
 * 1 2 3 4 5 6 7 8
 * 4
 * 输出：
 * 5
 *
 * @author wangjingdong
 * @date 2021/11/1 14:03
 * @Copyright © 云粒智慧 2018
 */
public class HJ51Main {
    static class ListNode {
        int key;
        ListNode next;

        public ListNode(int key, ListNode next) {
            this.key = key;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListNode head = null;
        while (sc.hasNext()) {
            int n = sc.nextInt();
            ListNode cur = null;
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    cur = new ListNode(sc.nextInt(), null);
                    head = cur;
                } else {
                    cur.next = new ListNode(sc.nextInt(), null);
                    cur = cur.next;
                }
            }
            int k = sc.nextInt();
            // 找倒数第k个节点，即找顺数第n-k个节点
            int i = n - k;
            ListNode p = head;
            while (i > 0) {
                if (p == null) {
                    break;
                }
                if (p.next != null) {
                    i--;
                    p = p.next;
                } else {
                    i--;
                    p = null;
                    System.out.println(0);
                }
            }
            if (p != null) {
                System.out.println(p.key);
            }
        }
        sc.close();
    }
}

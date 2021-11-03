package tiku.niuke.huawei;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * MP3光标位置
 *
 * @author wangjingdong
 * @date 2021/11/2 13:45
 * @Copyright © 云粒智慧 2018
 */
public class HJ64Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String line = sc.next();
            int cur = 1;
            if (n <= 4) {
                for (int i = 0; i < line.length(); i++) {
                    if (cur == 1 && line.charAt(i) == 'U') {
                        cur = n;
                    } else if (cur == n && line.charAt(i) == 'D') {
                        cur = 1;
                    } else if (line.charAt(i) == 'U') {
                        cur--;
                    } else {
                        cur++;
                    }
                }
                for (int i = 1; i < n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println(n);
                System.out.println(cur);
            } else {
                LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4));
                for (int i = 0; i < line.length(); i++) {
                    if (cur == 1 && line.charAt(i) == 'U') {
                        cur = n;
                        for (int j = n - 3; j <= n; j++) {
                            list.poll();
                            list.offer(j);
                        }
                    } else if (cur == n && line.charAt(i) == 'D') {
                        cur = 1;
                        for (int j = 1; j <= 4; j++) {
                            list.poll();
                            list.offer(j);
                        }
                    } else if (cur == list.getFirst() && line.charAt(i) == 'U') {
                        cur--;
                        list.pollLast();
                        list.offerFirst(cur);
                    } else if (cur == list.getLast() && line.charAt(i) == 'D') {
                        cur++;
                        list.pollFirst();
                        list.offerLast(cur);
                    } else if (line.charAt(i) == 'U') {
                        cur--;
                    } else {
                        cur++;
                    }
                }
                for (int i = 0; i < list.size() - 1; i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println(list.get(list.size() - 1));
                System.out.println(cur);
            }
        }
        sc.close();
    }
}

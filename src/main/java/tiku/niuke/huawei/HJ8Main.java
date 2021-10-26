package tiku.niuke.huawei;

//import java.util.Scanner;
//
///**
// * @author wangjingdong
// * @date 2021/10/19 10:52
// * @Copyright © 云粒智慧 2018
// */
//public class HJ8Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int[] arr = new int[11111111];
//        for (int i = 0; i < num; i++) {
//            int key = sc.nextInt();
//            int value = sc.nextInt();
//            arr[key] += value;
//        }
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] >= 1) {
//                System.out.println(i + " " + arr[i]);
//            }
//        }
//    }
//}

import java.util.*;

public class HJ8Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tableSize = sc.nextInt();
        Map<Integer, Integer> table = new HashMap<>(tableSize);
        for (int i = 0; i < tableSize; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            if (table.containsKey(key)) {
                table.put(key, table.get(key) + value);
            } else {
                table.put(key, value);
            }
        }
//        TreeSet<Integer> treeSet = new TreeSet<>(table.keySet());
        for (Integer key : table.keySet()) {
            System.out.println(key + " " + table.get(key));
        }
        sc.close();
    }
}
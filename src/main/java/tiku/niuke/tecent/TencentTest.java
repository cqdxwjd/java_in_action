package tiku.niuke.tecent;

import java.util.TreeSet;

/**
 * 在O（lgN）的时间内找到循环递增数组的最小值。
 *
 * @author wangjingdong
 * @date 2021/10/15 16:24
 * @Copyright © 云粒智慧 2018
 */
public class TencentTest {
    public static void main(String[] args) {
//        TreeSet<Integer> set = new TreeSet<>();
        int[] myArray = {50, 52, 63, 90, 3, 8, 15, 44};
//        int[] myArray = {7, 8, 1, 2, 3, 4, 5, 6};
//        for (int i : myArray) {
//            set.add(i);
//        }
//        System.out.println(set.first());
        int start = 0;
        int end = myArray.length - 1;
        int mid = 0;
        int min = 0;
        while (start <= end) {
            mid = (start + end) / 2;
            if ((myArray[start] < myArray[mid]) && (myArray[mid] > myArray[end])) {
                start = mid + 1;
            } else if ((myArray[start] > myArray[mid]) && (myArray[mid] < myArray[end])) {
                end = mid - 1;
            } else if ((myArray[start] <= myArray[mid]) && (myArray[mid] <= myArray[end])) {
                min = myArray[start];
                break;
            }
        }
        System.out.println(min);
    }
}

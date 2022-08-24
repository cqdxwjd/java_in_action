package tiku.niuke.huawei;

import java.util.Stack;

/**
 * @author wangjingdong
 * @date 2021/11/3 17:36
 * @Copyright © 云粒智慧 2018
 */
public class SortCombine2 {
    public static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        order(arr, 3, 0);
    }

    private static void order(int[] arr, int target, int cur) {
        if (cur == target) {
            System.out.println(stack);
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!stack.contains(arr[i])) {
                stack.add(arr[i]);
                order(arr, target, cur + 1);
                stack.pop();
            }
        }
    }
}

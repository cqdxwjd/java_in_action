package tiku.niuke.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 杨辉三角的变形
 * <p>
 * 以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和（如果不存在某个数，认为该数就是0）。
 * 求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
 * 数据范围：1<=n<=10^9
 * 本题有多组输入数据
 * 输入描述：
 * <p>
 * 输入一个int整数
 * 输出描述：
 * <p>
 * 输出返回的int值
 * 示例1
 * <p>
 * 输入：
 * 4
 * 2
 * 输出：
 * 3
 * -1
 *
 * @author wangjingdong
 * @date 2021/11/1 15:57
 * @Copyright © 云粒智慧 2018
 */
public class HJ53Main {

    // 获取第n行的所有数字，当n特别大时，由于递归层次太深，会发生栈溢出
    public static int[] getArr(int n) {
        if (n < 1) {
            return null;
        }
        if (n == 1) {
            int[] ints = new int[1];
            Arrays.fill(ints, 1);
            return ints;
        }
        if (n == 2) {
            int[] ints = new int[3];
            Arrays.fill(ints, 1);
            return ints;
        }
        int[] arr = getArr(n - 1);
        int[] newArr = new int[2 * n - 1];
        if (arr != null) {
            for (int i = 2; i < newArr.length - 2; i++) {
                newArr[i] = arr[i - 2] + arr[i - 1] + arr[i];
            }
            newArr[0] = arr[0];
            newArr[1] = arr[0] + arr[1];
            newArr[newArr.length - 2] = arr[arr.length - 2] + arr[arr.length - 1];
            newArr[newArr.length - 1] = arr[arr.length - 1];
        }
        return newArr;
    }

    public static int findFirstEven(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                return i + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = getArr(n);
            if (arr != null) {
                int result = findFirstEven(arr);
                System.out.println(result);
            }
        }
        sc.close();
    }
}

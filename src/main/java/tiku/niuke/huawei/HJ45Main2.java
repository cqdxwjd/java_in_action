package tiku.niuke.huawei;

import java.util.*;

/**
 * 名字的漂亮度
 * <p>
 * 描述
 * <p>
 * 给出一个名字，该名字由26个字符组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个不同字母拥有相同的“漂亮度”。字母忽略大小写。
 * 给出多个名字，计算每个名字最大可能的“漂亮度”。
 * <p>
 * 本题含有多组数据。
 * <p>
 * 数据范围：输入的名字长度满足 1<=n<=10000
 * <p>
 * 输入描述：
 * <p>
 * 整数N，后续N个名字
 * 输出描述：
 * <p>
 * 每个名称可能的最大漂亮程度
 * 示例1
 * <p>
 * 输入：
 * 2
 * zhangsan
 * lisi
 * 输出：
 * 192
 * 101
 *
 * @author wangjingdong
 * @date 2021/10/29 17:50
 * @Copyright © 云粒智慧 2018
 */
public class HJ45Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(sc.next().toLowerCase());
            }
            for (String s : list) {
                // 存储每个字母出现的次数
                HashMap<Character, Integer> countMap = new HashMap<>();
                byte[] bytes = s.getBytes();
                for (byte b : bytes) {
                    if (countMap.containsKey((char) b)) {
                        countMap.put((char) b, countMap.get((char) b) + 1);
                    } else {
                        countMap.put((char) b, 1);
                    }
                }
                Collection<Integer> values = countMap.values();
                Object[] array = values.toArray();
                Arrays.sort(array);
                int sum = 0;
                for (int i = array.length - 1; i >= 0; i--) {
                    sum += (int) array[i] * (27 - array.length + i);
                }
                System.out.println(sum);
            }
        }
        sc.close();
    }
}

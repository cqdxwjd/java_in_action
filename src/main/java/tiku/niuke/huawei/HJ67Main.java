package tiku.niuke.huawei;

import java.util.*;

/**
 * 24点游戏算法
 * <p>
 * 描述
 * <p>
 * 问题描述：给出4个1-10的数字，通过加减乘除，得到数字为24就算胜利
 * 输入：
 * 4个1-10的数字。[数字允许重复，但每个数字仅允许使用一次，测试用例保证无异常数字。
 * 输出：
 * true or false
 * 注意：本题含有多组样例输入。
 * 数据范围：数字大小：1<=num<=10
 * 输入描述：
 * <p>
 * 输入4个int整数
 * 输出描述：
 * <p>
 * 返回能否得到24点，能输出true，不能输出false
 * 示例1
 * <p>
 * 输入：
 * 7 2 1 10
 * 输出：
 * true
 *
 * @author wangjingdong
 * @date 2021/11/3 15:29
 * @Copyright © 云粒智慧 2018
 */
public class HJ67Main {
    public static void compute(double sum, int[] nums, int step, Set<Integer> set) {
        if (step == 4) {
            if (sum == 24) {
                set.add(1);
            }
        } else {
            step++;
            compute(sum + nums[step - 1], nums, step, set);
            compute(sum - nums[step - 1], nums, step, set);
            compute(sum * nums[step - 1], nums, step, set);
            compute(sum / nums[step - 1], nums, step, set);
        }
    }

    public static void getAllPossible(List<Integer> candidate, String prefix, HashSet<String> set) {
        if (candidate.size() == 0 && !set.contains(prefix)) {
            set.add(prefix);
        }
        for (int i = 0; i < candidate.size(); i++) {
            LinkedList<Integer> temp = new LinkedList<>(candidate);
            Integer tempInt = temp.remove(i);
            getAllPossible(temp, prefix + "-" + tempInt, set);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] nums = new int[4];
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                nums[i] = sc.nextInt();
                list.add(nums[i]);
            }
            HashSet<Integer> set = new HashSet<>();
            HashSet<String> possibleSet = new HashSet<>();
            getAllPossible(list, "", possibleSet);
            for (String s : possibleSet) {
                s = s.substring(1);
                String[] split = s.split("-");
                for (int i = 0; i < split.length; i++) {
                    if (!split[i].isEmpty()) {
                        nums[i] = Integer.parseInt(split[i]);
                    }
                }
                compute(nums[0], nums, 1, set);
            }
            System.out.println(set.contains(1));
        }
        sc.close();
    }
}

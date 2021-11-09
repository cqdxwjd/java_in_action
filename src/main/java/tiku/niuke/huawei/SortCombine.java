package tiku.niuke.huawei;

import java.util.*;

/**
 * 无重复的全排列
 *
 * @author wangjingdong
 * @date 2021/11/3 17:36
 * @Copyright © 云粒智慧 2018
 */
public class SortCombine {
    public static void getAllPossible(List<String> candidate, String prefix, HashSet<String> set) {
        if (candidate.size() == 0 && !set.contains(prefix)) {
            System.out.println(prefix);
            set.add(prefix);
        }
        for (int i = 0; i < candidate.size(); i++) {
            LinkedList<String> temp = new LinkedList<>(candidate);
            String tempString = temp.remove(i);
            getAllPossible(temp, prefix + tempString, set);
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        getAllPossible(list, "", new HashSet<>());
    }
}

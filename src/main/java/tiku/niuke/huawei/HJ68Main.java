package tiku.niuke.huawei;

import java.util.*;

/**
 * @author wangjingdong
 * @date 2021/11/4 10:25
 * @Copyright © 云粒智慧 2018
 */
public class HJ68Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sortType = sc.nextInt();
            HashMap<Integer, ArrayList<String>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int grade = sc.nextInt();
                if (map.containsKey(grade)) {
                    map.get(grade).add(name);
                } else {
                    map.put(grade, new ArrayList<>(Collections.singletonList(name)));
                }
            }
            Set<Integer> set = map.keySet();
            Object[] objects = set.stream().sorted(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    if (sortType == 1) {
                        return o1 - o2;
                    } else {
                        return o2 - o1;
                    }
                }
            }).toArray();
            for (Object object : objects) {
                Integer key = (Integer) object;
                ArrayList<String> values = map.get(key);
                for (String value : values) {
                    System.out.println(value + " " + key);
                }
            }
        }
        sc.close();
    }
}

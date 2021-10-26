package tiku.niuke.huawei;

import java.util.*;

/**
 * @author wangjingdong
 * @date 2021/10/22 15:32
 * @Copyright © 云粒智慧 2018
 */
public class HJ25Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 接受I序列
            int iNum = sc.nextInt();
            String[] iArr = new String[iNum];
            for (int i = 0; i < iNum; i++) {
                iArr[i] = String.valueOf(sc.nextInt());
            }
            // 接受R序列
            int rNum = sc.nextInt();
            int[] rArr = new int[rNum];
            for (int i = 0; i < rArr.length; i++) {
                rArr[i] = sc.nextInt();
            }
            // 对R序列排序并去重
            Arrays.sort(rArr);
            int[] finalRArr = Arrays.stream(rArr).distinct().toArray();
            ArrayList<Integer> output = new ArrayList<>();
            for (int k : finalRArr) {
                ArrayList<Integer> list = new ArrayList<>();
                int num = 0;
                for (int j = 0; j < iArr.length; j++) {
                    if (iArr[j].contains(String.valueOf(k))) {
                        num++;
                        list.add(j);
                        list.add(Integer.parseInt(iArr[j]));
                    }
                }
                if (num > 0) {
                    output.add(k);
                    output.add(num);
                    output.addAll(list);
                }
            }
//            System.out.println(output);
            output.add(0, output.size());
            for (int i = 0; i < output.size(); i++) {
                if (i == output.size() - 1) {
                    System.out.print(output.get(i));
                } else {
                    System.out.print(output.get(i) + " ");
                }
            }
            System.out.println();
        }
        sc.close();
    }
}

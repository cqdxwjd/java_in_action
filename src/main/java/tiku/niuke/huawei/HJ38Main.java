package tiku.niuke.huawei;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * 求小球落地5次后所经历的路程和第5次反弹的高度
 * <p>
 * 描述
 * <p>
 * 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
 * 最后的误差判断是小数点6位
 * <p>
 * <p>
 * 输入描述：
 * <p>
 * 输入起始高度，int型
 * 输出描述：
 * <p>
 * 分别输出第5次落地时，共经过多少米
 * 第5次反弹多高
 * 示例1
 * <p>
 * 输入：
 * 1
 * 输出：
 * 2.875
 * 0.03125
 *
 * @author wangjingdong
 * @date 2021/10/26 18:20
 * @Copyright © 云粒智慧 2018
 */
public class HJ38Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int height = sc.nextInt();
            System.out.println(height * (1.0 + 1.0 + 1.0 / 2 + 1.0 / 4 + 1.0 / 8));
            BigDecimal bigDecimal = new BigDecimal(height * (1.0 / 32));
            System.out.println(bigDecimal.setScale(5, BigDecimal.ROUND_HALF_UP));

        }
        sc.close();
    }
}

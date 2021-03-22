package tiku.niuke.xiaomi;

/**
 * he的平方=she。h、e、s代表的数字分别是多少。s,h,e不能为0.
 */
public class SHE {
    public static void main(String[] args) {
//        while ((h * 10 + e) * (h * 10 + e) == s * 100 + h * 10 + e) {
//            System.out.println(s + "," + h + "," + e);
//        }
        for (int s = 1; s <= 9; s++) {
            for (int h = 1; h <= 9; h++) {
                for (int e = 1; e <= 9; e++) {
                    if ((h * 10 + e) * (h * 10 + e) == s * 100 + h * 10 + e) {
                        System.out.println(s + "," + h + "," + e);
                    }
                }
            }
        }
    }
}

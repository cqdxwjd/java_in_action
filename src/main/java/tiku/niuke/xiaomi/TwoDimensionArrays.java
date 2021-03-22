package tiku.niuke.xiaomi;

/**
 * 有一个二维数组a[1...100 , 1...65]有100行，65列，我们以行序为主序，如果该数组的基地址是10000，且每个元素占2个存储单元，
 * 请问a[56 , 22]的存储地址是多少。注意是下标是从1开始的
 */
public class TwoDimensionArrays {
    public static void main(String[] args) {
        System.out.println(2 * 65 * 55 + 10000 + 2 * 22);
    }
}

package tiku.niuke.xiaomi;

/**
 * 一个完全二叉树有770个节点，那么其叶子的个数为多少个
 */
public class BinaryTree {
    public static void main(String[] args) {
        int depth = (int) Math.floor(Math.log(770) / Math.log(2));
        System.out.println(depth);
        int leaves = (int) (770 - Math.pow((double) 2, (double) depth - 1) + 1);
        System.out.println(leaves);
    }
}

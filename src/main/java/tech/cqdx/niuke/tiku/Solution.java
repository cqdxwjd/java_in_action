package tech.cqdx.niuke.tiku;

public class Solution {

    /**
     * 二维数组中的查找
     *
     * @param target
     * @param array
     * @return
     */
    public boolean find(int target, int[][] array) {
        int n = array.length;
        if (n == 0) {
            return false;
        }
        int m = array[0].length;
        if (m == 0) {
            return false;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (array[i][0] <= target) {
                for (int j = 0; j <= m - 1; j++) {
                    if (array[i][j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 替换空格
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}

package tiku.niuke.huawei;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 迷宫问题
 * <p>
 * 描述
 * <p>
 * 定义一个二维数组 N*M ，如 5 × 5 数组下所示：
 * <p>
 * int maze[5][5] = {
 * 0, 1, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 0, 0,
 * 0, 1, 1, 1, 0,
 * 0, 0, 0, 1, 0,
 * };
 * <p>
 * 它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的路线。入口点为[0,0],既第一格是可以走的路。
 * <p>
 * 本题含有多组数据。
 * <p>
 * 数据范围：2<=n,m<=10， 输入的内容只包含0<=val<=1
 * 输入描述：
 * <p>
 * 输入两个整数，分别表示二维数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * 输出描述：
 * <p>
 * 左上角到右下角的最短路径，格式如样例所示。
 * 示例1
 * <p>
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 0 1 1 1 0
 * 0 0 0 1 0
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (2,1)
 * (2,2)
 * (2,3)
 * (2,4)
 * (3,4)
 * (4,4)
 * 示例2
 * <p>
 * 输入：
 * 5 5
 * 0 1 0 0 0
 * 0 1 0 1 0
 * 0 0 0 0 1
 * 0 1 1 1 0
 * 0 0 0 0 0
 * 输出：
 * (0,0)
 * (1,0)
 * (2,0)
 * (3,0)
 * (4,0)
 * (4,1)
 * (4,2)
 * (4,3)
 * (4,4)
 * <p>
 * 说明：
 * 注意：不能斜着走！！
 *
 * @author wangjingdong
 * @date 2021/10/28 15:29
 * @Copyright © 云粒智慧 2018
 */
public class HJ43Main {
    static class Node {
        int x;
        int y;
        public Node parent;

        public Node(int x, int y, Node parent) {
            this.x = x;
            this.y = y;
            this.parent = parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Node getParent() {
            return parent;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static Node findTarget(Node start, Node end, HashMap<Node, ArrayList<Node>> map) {
        List<Node> hasSearchList = new ArrayList<Node>();
        LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (hasSearchList.contains(node)) {
                continue;
            }
//            System.out.print("判断节点:" + node + "\n");
            if (node.equals(end)) {
                return node;
            }
            hasSearchList.add(node);
            if (map.get(node) != null && map.get(node).size() > 0) {
                for (Node childNode : map.get(node)) {
                    childNode.setParent(node);
                    queue.offer(childNode);
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 行数
            int n = sc.nextInt();
            // 列数
            int m = sc.nextInt();
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            HashMap<Node, ArrayList<Node>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    Node node = new Node(i, j, null);
                    if (arr[i][j] == 0) {
                        if (!map.containsKey(node)) {
                            map.put(node, new ArrayList<>());
                        }
                        if (j + 1 < m && arr[i][j + 1] == 0) {
                            map.get(node).add(new Node(i, j + 1, null));
                        }
                        if (i + 1 < n && arr[i + 1][j] == 0) {
                            map.get(node).add(new Node(i + 1, j, null));
                        }
                        if (i - 1 >= 0 && arr[i - 1][j] == 0) {
                            map.get(node).add(new Node(i - 1, j, null));
                        }
                        if (j - 1 >= 0 && arr[i][j - 1] == 0) {
                            map.get(node).add(new Node(i, j - 1, null));
                        }
                    }
                }
            }
//            for (Node node : map.keySet()) {
//                System.out.println(node + "---" + map.get(node));
//            }
            Node target = findTarget(new Node(0, 0, null), new Node(n - 1, m - 1, null), map);
//            System.out.println(target);
            ArrayList<Node> result = new ArrayList<>();
            while (true) {
                assert target != null;
                if (null == target.getParent()) break;
                result.add(target);
                target = target.getParent();
            }
            System.out.println("(0,0)");
            for (int i = result.size() - 1; i >= 0; i--) {
                System.out.println("(" + result.get(i).getX() + "," + result.get(i).getY() + ")");
            }
        }
        sc.close();
    }
}

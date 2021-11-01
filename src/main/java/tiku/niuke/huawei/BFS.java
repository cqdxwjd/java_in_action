package tiku.niuke.huawei;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wangjingdong
 * @date 2021/10/28 16:07
 * @Copyright © 云粒智慧 2018
 */

public class BFS {
    public static void main(String[] args) {
        HashMap<String, String[]> hashMap = new HashMap<>();
        hashMap.put("YOU", new String[]{"CLAIRE", "ALICE", "BOB"});
        hashMap.put("CLAIRE", new String[]{"YOU", "JONNY", "THON"});
        hashMap.put("JONNY", new String[]{"CLAIRE"});
        hashMap.put("THOH", new String[]{"CLAIRE"});
        hashMap.put("ALICE", new String[]{"YOU", "PEGGY"});
        hashMap.put("BOB", new String[]{"YOU", "PEGGY", "ANUJ"});
        hashMap.put("PEGGY", new String[]{"BOB", "ALICE"});
        hashMap.put("ANUJ", new String[]{"BOB"});
        Node target = findTarget(hashMap);
        //打印出最短路径的各个节点信息
        printSearPath(target);
    }

    /**
     * 打印出到达节点target所经过的各个节点信息
     */
    static void printSearPath(Node target) {
        if (target != null) {
            System.out.print("找到了目标节点:" + target.id + "\n");

            List<Node> searchPath = new ArrayList<Node>();
            searchPath.add(target);
            Node node = target.parent;
            while (node != null) {
                searchPath.add(node);
                node = node.parent;
            }
            StringBuilder path = new StringBuilder();
            for (int i = searchPath.size() - 1; i >= 0; i--) {
                path.append(searchPath.get(i).id);
                if (i != 0) {
                    path.append("-->");
                }
            }
            System.out.print("步数最短：" + path);
        } else {
            System.out.print("未找到了目标节点");
        }
    }

    static Node findTarget(HashMap<String, String[]> map) {
        List<String> hasSearchList = new ArrayList<String>();
        LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<>();
        queue.offer(new Node("YOU", null));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (hasSearchList.contains(node.id)) {
                continue;
            }
            System.out.print("判断节点:" + node.id + "\n");
            if ("ANUJ".equals(node.id)) {
                return node;
            }
            hasSearchList.add(node.id);
            if (map.get(node.id) != null && map.get(node.id).length > 0) {
                for (String childId : map.get(node.id)) {
                    queue.offer(new Node(childId, node));
                }
            }
        }
        return null;
    }

    static class Node {
        public String id;
        public Node parent;

        public Node(String id, Node parent) {
            this.id = id;
            this.parent = parent;
        }
    }
}


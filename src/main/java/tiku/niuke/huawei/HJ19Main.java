package tiku.niuke.huawei;

import java.util.*;

/**
 * @author wangjingdong
 * @date 2021/10/21 14:42
 * @Copyright © 云粒智慧 2018
 */
public class HJ19Main {
    static class Record {
        String path;
        Integer line;
        Integer num;

        public Record(String path, Integer line, Integer num) {
            this.path = path;
            this.line = line;
            this.num = num;
        }

        public Integer getNum() {
            return num;
        }

        public String getPath() {
            return path;
        }

        public Integer getLine() {
            return line;
        }

        public void addNum() {
            this.num++;
        }

        @Override
        public String toString() {
            return "Record{" +
                    "path='" + path + '\'' +
                    ", line=" + line +
                    ", num=" + num +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Record record = (Record) o;
            return Objects.equals(path, record.path) && Objects.equals(line, record.line);
        }

        @Override
        public int hashCode() {
            return Objects.hash(path, line);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 保存结果的队列
        LinkedList<Record> list = new LinkedList<>();
        // 辅助过滤重复记录的hashset
        HashSet<Record> set = new HashSet<>();
        while (sc.hasNextLine()) {
            String[] split = sc.nextLine().split(" ");
            if (split[0].isEmpty()) {
                break;
            }
            String filename = split[0].substring(split[0].lastIndexOf("\\") + 1);
            if (filename.length() > 16) {
                filename = filename.substring(filename.length() - 16);
            }
            Record record = new Record(filename, Integer.parseInt(split[1]), 1);
            if (set.contains(record)) {
                int i = list.indexOf(record);
                if (i >= 0) {
                    record.addNum();
                    list.set(i, record);
                }
            } else {
                set.add(record);
                list.add(record);
            }
            if (list.size() > 8) {
                list.pop();
            }
        }
        for (Record record : list) {
            System.out.println(record.getPath() + " " + record.getLine() + " " + record.getNum());
        }
        sc.close();
    }
}

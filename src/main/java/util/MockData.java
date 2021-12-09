package util;

import java.io.*;

/**
 * @author wangjingdong
 * @date 2021/12/9 17:30
 * @Copyright © 云粒智慧 2018
 */
public class MockData {
    public static void main(String[] args) throws IOException {
        File file = new File("skew_test_a.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        for (int i = 0; i < 100000000; i++) {
            writer.write("NULL,zzz\n");
        }
        writer.write("111,aaa\n");
        writer.write("222,bbb\n");
        writer.write("333,ccc\n");
        writer.write("444,ddd\n");
        writer.write("555,eee\n");
        writer.write("666,fff");
        writer.flush();
    }
}

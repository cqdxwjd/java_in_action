package io;

import oracle.jrockit.jfr.events.Bits;

import java.io.UnsupportedEncodingException;

public class MyBits {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // byte: -128~127
//        byte[] b = {95, 96, 97};
//        System.out.println(b[0]);
//        System.out.println(Integer.toBinaryString(-128));
        /**
         * 有符号数 byte 8位
         * 原码表示                 反码表示                补码表示
         * 正数                     正数                   正数
         * 0111 1111：127          0111 1111:127          0111 1111:127
         * 0000 0000：0            0000 0000:0            0000 0000:0
         * 负数                     负数                   负数
         * 1000 0000：-0           1111 1111:-127
         * 1111 1111：-127         1000 0000:-0
         * 0111 1111+
         * 0111 1110:126
         * 无符号数
         * 0000 0000：0
         * 1111 1111：255
         *
         * 5-4
         * 0000 0101=+5
         * 1000 0100=-4
         * 1000 1001=-9
         * 0000 0101=+5
         * 1111 1011=-123
         *
         */
//        System.out.println(getChar(b, 1));
//        byte[] b = "abc".getBytes();
//        for (byte b1 : b) {
//            System.out.println((char) b1);
//        }
//        System.out.println((char) 1);
//        for (int i = 0; i < 128; i++) {
//            System.out.println((char) i);
//        }
        byte[] bytes = "慢".getBytes();
        System.out.println(bytes.length);
        for (byte b : bytes) {
            System.out.println(b);
        }

        System.out.println(getChar("abc".getBytes(), 0));
        System.out.println("慢".getBytes().length);
        int a = Character.digit('a', 2);
        System.out.println(a);
        System.out.println(Character.getDirectionality('慢'));
        byte[] gbks = "慢".getBytes("GBK");
        System.out.println(gbks.length);
        for (byte gbk : gbks) {
            System.out.println(gbk);
        }
    }

    static boolean getBoolean(byte[] b, int off) {
        return b[off] != 0;
    }

    static char getChar(byte[] b, int off) {
        return (char) ((b[off + 1] & 0xFF) + (b[off] << 8));
    }
}

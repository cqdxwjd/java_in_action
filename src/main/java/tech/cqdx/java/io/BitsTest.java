package tech.cqdx.java.io;

public class BitsTest {

    static boolean getBoolean(byte[] b, int off) {
        return b[off] != 0;
    }

    static char getChar(byte[] b, int off) {
        return (char) ((b[off + 1] & 0xFF) +
                (b[off] << 8));
    }

    public static void main(String[] args) {
        byte b = 'a';

        for (int i = 0; i < 255; i++) {
            System.out.println(i + "---" + (char) i);
        }
        byte[] barray = {1, 2, 97};

//        System.out.println(b);
        boolean aBoolean = BitsTest.getBoolean(barray, 1);
        System.out.println(barray[1]);
        System.out.println(aBoolean);

        System.out.println(getChar(barray, 2));
    }
}
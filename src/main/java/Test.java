import desp.ObjectUtil;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static final String EMPTY = "";

    public static String toStringWithSep(List<String> array, String sep) {
        if (ObjectUtil.isEmpty(array)) {
            return EMPTY;
        }
        StringBuilder builder = new StringBuilder();
//        array.forEach(a -> {
//            builder.append(a);
//            builder.append(sep);
//        });
        for (String str : array) {
            builder.append(str);
            builder.append(sep);
        }
        return builder.substring(0, builder.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(toStringWithSep(Arrays.asList("aaa", "bbb", "ccc"), ","));
    }
}

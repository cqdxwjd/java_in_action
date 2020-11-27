package desp;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 对象工具
 *
 * @author zhangws
 */
public final class ObjectUtil {

  private static final String EMPTY = "";

  private static final String NULL = "null";

  public static boolean isEmpty(Object obj) {
    if (obj == null) {
      return true;
    }
    if (obj instanceof String) {
      String s = (String) obj;
      return EMPTY.equals(s) || NULL.equals(s);
    } else if (obj instanceof Map) {
      Map m = (Map) obj;
      return m.size() == 0;
    } else if (obj instanceof List) {
      List l = (List) obj;
      return l.size() == 0;
    } else if (obj instanceof String[]) {
      String[] arr = (String[]) obj;
      return arr.length == 0;
    } else if (obj instanceof Set) {
      Set s = (Set) obj;
      return s.size() == 0;
    }
    return false;
  }

  public static boolean isNotEmpty(Object obj) {
    return !isEmpty(obj);
  }

  public static boolean isAnyNotEmpty(Object obj, Object... objs) {
    if (isNotEmpty(obj)) {
      return true;
    }
    if (objs != null) {
      for (Object o : objs) {
        if (isNotEmpty(o)) {
          return true;
        }
      }
    }
    return false;
  }

  public static boolean isAnyEmpty(Object obj, Object... objs) {
    if (isEmpty(obj)) {
      return true;
    }
    if (objs != null) {
      for (Object o : objs) {
        if (isEmpty(o)) {
          return true;
        }
      }
    }

    return false;
  }

  public static boolean isAllEmpty(Object date, Object... dates) {
    return !isAnyNotEmpty(date, dates);
  }

  public static boolean isAllNotEmpty(Object date, Object... dates) {
    return !isAnyEmpty(date, dates);
  }
}

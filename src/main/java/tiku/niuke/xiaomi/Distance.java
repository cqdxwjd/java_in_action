package tiku.niuke.xiaomi;

/**
 * 两个人，A的速度为a，B的速度为b,在一直路上相向而行。在A、B距离为s的时候，A放出一个鸽子C，速度为c，C飞到B后，立即掉头飞向A，
 * 遇到A在掉头飞向B......就这样在AB之间飞来飞去，直到A、B相遇，假设a=40， b=60， c=400， s=100，这期间鸽子共飞行路程为
 */
public class Distance {
    public static void main(String[] args) {
        double flight = flight(40, 60, 400, 100);
        System.out.println(flight);
    }

    public static double flight(double a, double b, double c, double s) {
        double time = meetTime(a, b, s);
        return c * time;
    }

    public static double meetTime(double a, double b, double s) {
        return s / (a + b);
    }
}

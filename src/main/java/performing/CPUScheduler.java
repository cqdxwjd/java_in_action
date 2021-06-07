package performing;

/**
 * @author wangjingdong
 * @date 2021/6/6 08:13
 * @Copyright © 云粒智慧 2018
 */
public class CPUScheduler {
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2000; i++) {
            Thread.sleep(2);
        }
        long end = System.currentTimeMillis();
        System.out.println("Millis elapsed: " + (end - start) / 4000.0);
    }
}

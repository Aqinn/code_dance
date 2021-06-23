package 非算法题;

/**
 * @Author Aqinn
 * @Date 2021/3/11 5:22 下午
 */
public class 三个线程交替打印1至100_synchronized {

    public static void main(String[] args) {
        MyThread t1 = new MyThread(0);
        MyThread t2 = new MyThread(1);
        MyThread t3 = new MyThread(2);
        t1.start();
        t2.start();
        t3.start();
    }

    static class MyThread extends Thread {

        private static Object lock = new Object();
        public static int target = 100;
        public static int count = 0;
        private int number;

        public MyThread(int n) {
            number = n;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    if (count >= target) {
                        break;
                    }
                    if (count % 3 == number) {
                        System.out.println("No." + number + " say " + ++count);
                    } else {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    lock.notifyAll();
                }
            }
        }
    }

}

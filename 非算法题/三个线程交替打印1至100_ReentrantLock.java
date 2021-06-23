package 非算法题;

import java.util.concurrent.locks.*;

/**
 * @Author Aqinn
 * @Date 2021/3/11 5:33 下午
 */
public class 三个线程交替打印1至100_ReentrantLock {

    public static void main(String[] args) {
        MyThread t1 = new MyThread(0);
        MyThread t2 = new MyThread(1);
        MyThread t3 = new MyThread(2);
        t1.start();
        t2.start();
        t3.start();
    }

    // 方法一
    static class MyThread extends Thread {

        private static ReentrantLock lock = new ReentrantLock();
        private static Condition condition = lock.newCondition();
        public static int target = 100;
        public static int count = 0;
        private int number;

        public MyThread(int n) {
            number = n;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                if (count >= 100) {
                    lock.unlock();
                    break;
                }
                if (count % 3 == number) {
                    System.out.println("No." + number + " say " + ++count);
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                condition.signalAll();
                lock.unlock();
            }
        }
    }

    // 方法二 没有用到 Condition
//    static class MyThread extends Thread {
//
//        private static ReentrantLock lock = new ReentrantLock();
//        public static int target = 100;
//        public static int count = 0;
//        private int number;
//
//        public MyThread(int n) {
//            number = n;
//        }
//
//        public void run() {
//            while (true) {
//                lock.lock();
//                if (count >= target) {
//                    lock.unlock();
//                    break;
//                }
//                if (count % 3 == number) {
//                    System.out.println("No." + number + " say " + ++count);
//                    lock.unlock();
//                } else {
//                    lock.unlock();
//                }
//            }
//        }
//    }

}

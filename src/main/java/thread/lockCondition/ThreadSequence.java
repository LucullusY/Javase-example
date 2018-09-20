package thread.lockCondition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * <br/>使用显式锁的Condition实现线程执行顺序的控制
 * <br/>Date:2018/9/20
 *
 * @author YangBo
 * @version 1.0
 */
public class ThreadSequence {

    volatile private static int nextSequence = 1;
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    public static void main(String[] args){
        Thread a = new Thread(){
            @Override
            public void run () {
                try {
                    lock.lock();
                    while (nextSequence != 1){
                        conditionA.await();
                    }
                    for (int i=0;i<3; i++){
                        System.out.println("ThreadA " + (i+1) );
                    }
                    nextSequence = 2;
                    conditionB.signalAll();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        };

        Thread b = new Thread(){
            @Override
            public void run () {
                try {
                    lock.lock();
                    while (nextSequence != 2){
                        conditionB.await();
                    }
                    for (int i=0; i<3; i++){
                        System.out.println("ThreadB " + (i+1) );
                    }
                    nextSequence = 3;
                    conditionC.signalAll();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        };

        Thread c = new Thread(){
            @Override
            public void run () {
                try {
                    lock.lock();
                    while (nextSequence != 3){
                        conditionC.await();
                    }
                    for (int i=0; i<3; i++){
                        System.out.println("ThreadC " + (i+1));
                    }
                    nextSequence = 1;
                    conditionA.signalAll();
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                finally {
                    lock.unlock();
                }
            }
        };

        Thread[] threadAs = new Thread[5];
        Thread[] threadBs = new Thread[5];
        Thread[] threadCs = new Thread[5];

        for (int i=0; i<5; i++){
            threadAs[i] = new Thread(a);
            threadAs[i].start();
            threadBs[i] = new Thread(b);
            threadBs[i].start();
            threadCs[i] = new Thread(c);
            threadCs[i].start();
        }
    }
}

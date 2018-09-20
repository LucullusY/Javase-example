package thread.ProducerConsumerMode.manyToMany.lock;

import thread.ProducerConsumerMode.tools.ValueObject;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description:
 * <br/>
 * <br/>Date:2018/9/20
 *
 * @author YangBo
 * @version 1.0
 */
public class ProducerConsumerLock {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void setValue(){
        try {
            lock.lock();
            while (!ValueObject.value.equals("")) {
                System.out.println("线程 " + Thread.currentThread().getName() + " 等待中。。。");
                condition.await();
            }
            ValueObject.value = System.currentTimeMillis() + "_" +System.nanoTime();
            System.out.println(Thread.currentThread().getName() + "线程set值为：" + ValueObject.value);
            condition.signalAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void getValue(){
        try {
            lock.lock();
            while (ValueObject.value.equals("")){
                System.out.println("线程 " + Thread.currentThread().getName() + " 等待中。。。");
                condition.await();
            }
            System.out.println(Thread.currentThread().getName() + "线程get值为：" + ValueObject.value);
            ValueObject.value = "";
            condition.signalAll();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}

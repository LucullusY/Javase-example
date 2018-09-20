package thread.ProducerConsumerMode.oneToOne.lock;

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

    //生产者方法
    public void setValue(){
        try {
            lock.lock();
            if (!ValueObject.value.equals("")){
                condition.await();
            }
            ValueObject.value = System.currentTimeMillis() + "_" +System.nanoTime();
            System.out.println("set值为：" + ValueObject.value);
            condition.signal();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    //消费者方法
    public void getValue(){
        try {
            lock.lock();
            if (ValueObject.value.equals("")){
                condition.await();
            }
            System.out.println("get值为：" + ValueObject.value);
            ValueObject.value = "";
            System.out.println();
            condition.signal();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }
}

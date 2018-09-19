package thread.ProducerConsumerMode.manyToMany;

import thread.ProducerConsumerMode.oneToOne.ValueObject;

/**
 * Description:
 * <br/>
 * <br/>Date:2018/9/19
 *
 * @author YangBo
 * @version 1.0
 */
public class Producer {

    private String lock;

    public Producer(String lock){
        this.lock = lock;
    }

    public void setValue(){
        try {
            synchronized (lock){
                //必须使用循环，否则唤醒后的线程将直接执行wait后边的代码
                while (!ValueObject.value.equals("")){
                    System.out.println(Thread.currentThread().getName() + "：WAITING ★");
                    lock.wait();
                }
                System.out.println(Thread.currentThread().getName() + "：RUNNING ☆");
                ValueObject.value = System.currentTimeMillis() + "_" + System.nanoTime();
                System.out.println("set值：" + ValueObject.value);
                lock.notifyAll();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

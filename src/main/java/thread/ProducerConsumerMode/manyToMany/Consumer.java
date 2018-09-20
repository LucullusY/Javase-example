package thread.ProducerConsumerMode.manyToMany;

import thread.ProducerConsumerMode.tools.ValueObject;

/**
 * Description:
 * <br/>
 * <br/>Date:2018/9/19
 *
 * @author YangBo
 * @version 1.0
 */
public class Consumer {
    private String lock;

    public Consumer(String lock){
        this.lock = lock;
    }

    public void getValue(){
        try {
            synchronized (lock){
                while (ValueObject.value.equals("")){
                    System.out.println(Thread.currentThread().getName() + "：WAITING ★");
                    lock.wait();
                }
                System.out.println(Thread.currentThread().getName() + "：RUNNING ☆");
                System.out.println("get值：" + ValueObject.value);
                ValueObject.value = "";
                lock.notifyAll();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

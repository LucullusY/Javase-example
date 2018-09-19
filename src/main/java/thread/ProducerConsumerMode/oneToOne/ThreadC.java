package thread.ProducerConsumerMode.oneToOne;

/**
 * Description:消费者线程
 * <br/>
 * <br/>Date:2018/9/19
 *
 * @author YangBo
 * @version 1.0
 */
public class ThreadC extends Thread {
    private Consumer consumer;

    public ThreadC(Consumer consumer){
        this.consumer = consumer;
    }

    @Override
    public void run(){
        for (int i=0; i<10; i++) {
            consumer.getValue();
        }
    }
}

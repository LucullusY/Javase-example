package thread.ProducerConsumerMode.oneToOne;

/**
 * Description:生产者线程
 * <br/>
 * <br/>Date:2018/9/19
 *
 * @author YangBo
 * @version 1.0
 */
public class ThreadP extends Thread {

    private Producer producer;

    public ThreadP(Producer producer){
        this.producer = producer;
    }

    @Override
    public void run () {
        for (int i=0; i<10; i++) {
            producer.setValue();
        }
    }
}

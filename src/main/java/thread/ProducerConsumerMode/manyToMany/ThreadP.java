package thread.ProducerConsumerMode.manyToMany;

/**
 * Description:
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
    public void run(){
        for (int i=0; i<5; i++) {
            producer.setValue();
        }
    }
}

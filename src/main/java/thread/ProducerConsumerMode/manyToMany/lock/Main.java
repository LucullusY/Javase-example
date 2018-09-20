package thread.ProducerConsumerMode.manyToMany.lock;

/**
 * Description:
 * <br/>
 * <br/>Date:2018/9/20
 *
 * @author YangBo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args){
        ProducerConsumerLock service = new ProducerConsumerLock();
        Thread threadPa = new ThreadP(service);
        threadPa.setName("生产者01");
        Thread threadPb = new ThreadP(service);
        threadPb.setName("生产者02");
        Thread threadCa = new ThreadC(service);
        threadCa.setName("消费者01");
        Thread threadCb = new ThreadC(service);
        threadCb.setName("消费者02");
        threadPa.start();
        threadPb.start();
        threadCa.start();
        threadCb.start();
    }
}

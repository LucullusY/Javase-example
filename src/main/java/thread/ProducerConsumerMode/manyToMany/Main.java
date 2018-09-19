package thread.ProducerConsumerMode.manyToMany;

/**
 * Description:
 * <br/>
 * <br/>Date:2018/9/19
 *
 * @author YangBo
 * @version 1.0
 */
public class Main {

    public static void main(String[] args){
        String lock = "";
        Producer producer = new Producer(lock);
        Consumer consumer = new Consumer(lock);
        Thread[] threadPs = new ThreadP[2];
        Thread[] threadCs = new ThreadC[2];
        for (int i=0; i<2; i++){
            threadPs[i] = new ThreadP(producer);
            threadPs[i].setName("生产者" + i);
            threadPs[i].start();
            threadCs[i] = new ThreadC(consumer);
            threadCs[i].setName("消费者" + i);
            threadCs[i].start();
        }
    }
}

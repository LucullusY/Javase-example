package thread.ProducerConsumerMode.oneToOne;

/**
 * Description:程序入口
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
        Thread p = new ThreadP(producer);
        p.start();
        Thread c = new ThreadC(consumer);
        c.start();
    }
}

package thread.ProducerConsumerMode.oneToOne.lock;

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
        ProducerConsumerLock plc = new ProducerConsumerLock();
        Thread threadP = new ThreadP(plc);
        Thread threadC = new ThreadC(plc);
        threadP.start();
        threadC.start();
    }
}

package thread.ProducerConsumerMode.oneToOne.lock;

/**
 * Description:
 * <br/>
 * <br/>Date:2018/9/20
 *
 * @author YangBo
 * @version 1.0
 */
public class ThreadP extends Thread {

    private ProducerConsumerLock pcl ;

    public ThreadP(ProducerConsumerLock pcl){
        this.pcl = pcl;
    }

    @Override
    public void run () {
        for (int i=0; i<5; i++) {
            pcl.setValue();
        }
    }
}

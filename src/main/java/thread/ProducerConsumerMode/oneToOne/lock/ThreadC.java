package thread.ProducerConsumerMode.oneToOne.lock;

/**
 * Description:
 * <br/>
 * <br/>Date:2018/9/20
 *
 * @author YangBo
 * @version 1.0
 */
public class ThreadC extends Thread {

    private ProducerConsumerLock plc;

    public ThreadC(ProducerConsumerLock plc){
        this.plc = plc;
    }

    @Override
    public void run () {
        for (int i=0; i<5; i++) {
            plc.getValue();
        }
    }
}

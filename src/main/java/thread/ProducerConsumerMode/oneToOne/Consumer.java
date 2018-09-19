package thread.ProducerConsumerMode.oneToOne;

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
                if(ValueObject.value.equals("")){
                    lock.wait();
                }
                System.out.println("get值：" + ValueObject.value);
                ValueObject.value = "";
                lock.notify();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}

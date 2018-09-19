package thread.ProducerConsumerMode.oneToOne;

/**
 * Description: 生产者类
 * <br/>修改ValueObject的值
 * <br/>Date:2018/9/19
 *
 * @author YangBo
 * @version 1.0
 */
public class Producer {
    private String lock;

    public Producer(String lock){
        this.lock = lock;
    }

    public void setValue(){
        try {
            synchronized (lock) {
                if (!ValueObject.value.equals("")){
                    lock.wait();
                }
                String s = System.currentTimeMillis() + "_" + System.nanoTime();
                ValueObject.value = s;
                System.out.println("set值：" + ValueObject.value);
                lock.notify();
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}

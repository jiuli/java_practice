package effectivejava.CH2.javatuning.ch2.proxy.future_pattern;

/**
 * @author lijunsong
 * @date 2019/3/22 14:13
 * @since 1.0
 */
public class FutureData implements Data {
    private RealData realData;

    private boolean isReady = false;


    public synchronized void setRealData(RealData realData) {
        if (isReady) {
            return;
        }
        this.realData = realData;
        isReady = true;
        notify();
    }

    @Override
    public synchronized String getRequest() {
        while (!isReady) {
            try {
                wait(); //等notify()通知
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.realData.getRequest();
    }


}

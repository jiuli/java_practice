package effectivejava.CH4.javatuning.ch4.future.pattern;


/**
 * FutureData是Future模式的关键，它实际上是真实数据RealData的代理，
 * 封装了获取RealData的等待过程
 */
public class FutureData implements Data {
    protected RealData realdata = null;
    protected boolean isReady = false;

    public synchronized void setRealData(RealData realdata) {
        if (isReady) {
            return;
        }
        this.realdata = realdata;
        isReady = true;
        notifyAll(); //RealData被注入，通知getResult()
    }

    @Override
    public synchronized String getResult() {
        while (!isReady) {
            try {
                //一直等待，直到RealData被注入
                wait();
            } catch (InterruptedException e) {
            }
        }
        return realdata.result;
    }
}

package effectivejava.CH2.javatuning.ch2.proxy.future_pattern;

/**
 * @author lijunsong
 * @date 2019/3/22 14:17
 * @since 1.0
 */
public class FutureClient {

    public Data request(final String request) {
        final FutureData futureData = new FutureData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                RealData realData = new RealData(request);
                futureData.setRealData(realData);
            }
        }).start();

        return futureData;
    }

}

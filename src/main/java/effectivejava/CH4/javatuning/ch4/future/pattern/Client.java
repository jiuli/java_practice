package effectivejava.CH4.javatuning.ch4.future.pattern;

public class Client {
    public Data request(final String queryStr) {
        final FutureData future = new FutureData();
        /**
         * 实现获取FutureData，开启构造RealData的线程，
         * 并在接受请求后，很快地返回FutureData
         */
        new Thread(() -> {
            //当RealData的构件很慢，所以在单独的线程中进行
            RealData realdata = new RealData(queryStr);
            future.setRealData(realdata);
        }).start();
        return future;
    }
}

package effectivejava.CH2.javatuning.ch2.proxy.future_pattern;

import java.util.concurrent.Callable;

/**
 * @author lijunsong
 * @date 2019/3/22 15:21
 * @since 1.0
 */
public class RealData2 implements Callable<String> {
    private String data;

    public RealData2(String data) {
        this.data = data;
    }

    @Override
    public String call() throws Exception {
        Thread.sleep(3000);
        return "处理" + data + "jieguo";
    }
}

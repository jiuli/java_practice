package effectivejava.CH2.javatuning.ch2.proxy.future_pattern;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * @author lijunsong
 * @date 2019/3/22 14:19
 * @since 1.0
 */
@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {
        FutureClient futureClient = new FutureClient();
        Data data = futureClient.request("hello,world");
        log.info("请求发送成功。。。");
        log.info("干其他的事情。。。");

        String result = data.getRequest();

        log.info(result);

        Long start = System.currentTimeMillis();
        FutureTask<String> futureTask = new FutureTask<>(new RealData2("this future task"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(futureTask);

        Thread.sleep(2000);
        log.info("结果:::::" + futureTask.get());
        log.info("运行时间--->" + (System.currentTimeMillis() - start));
    }
}

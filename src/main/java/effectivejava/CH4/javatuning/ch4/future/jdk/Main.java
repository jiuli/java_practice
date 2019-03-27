package effectivejava.CH4.javatuning.ch4.future.jdk;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //构造FutureTask
        FutureTask<String> futureTask = new FutureTask<>(new RealData("name"));
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        //执行FutureTask,相当于上例中的client.request("a")发送请求
        //在这里开启线程进行RealData的call()执行
        executorService.submit(futureTask);
        log.info("请求完毕");
        try {
            //依然可以做额外的数据操作，使用sleep代替
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        //相当上例中的data.getResult(),取得call()方法返回值
        //如果此时call()方法没有执行完成，则依然会等待
        log.info("数据=" + futureTask.get());

    }
}

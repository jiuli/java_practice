package effectivejava.CH4.javatuning.ch4.gs.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * 客户端发起请求
 */
@Slf4j
public class ClientThread extends Thread {
    //请求队列
    private RequestQueue requestQueue;

    public ClientThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            //构造请求
            Request request = new Request("RequestID:" + i + " Thread_Name:" + Thread.currentThread().getName());

            log.info(Thread.currentThread().getName() + " requests " + request);
            //提交请求
            requestQueue.addRequest(request);
            try {
                //客户端请求的速度，快于服务端处理的速度
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            log.info("ClientThread Name is:" + Thread.currentThread().getName());
        }
        log.info(Thread.currentThread().getName() + " request end");
    }
}

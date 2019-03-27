package effectivejava.CH4.javatuning.ch4.gs.simple;

import lombok.extern.slf4j.Slf4j;

/**
 * 服务端进程代码，处理用户的请求操作
 */
@Slf4j
public class ServerThread extends Thread {
    //请求队列
    private RequestQueue requestQueue;

    public ServerThread(RequestQueue requestQueue, String name) {
        super(name);
        this.requestQueue = requestQueue;
    }

    @Override
    public void run() {
        while (true) {
            //得到请求
            final Request request = requestQueue.getRequest();
            try {
                //模拟请求处理耗时
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            log.info(Thread.currentThread().getName() + " handles  " + request);
        }
    }
}

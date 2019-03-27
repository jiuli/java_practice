package effectivejava.CH4.javatuning.ch4.gs.simple;

import java.util.LinkedList;

/**
 * 作为Request的集合
 */
public class RequestQueue {
    private LinkedList queue = new LinkedList();

    public synchronized Request getRequest() {
        while (queue.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        //返回队列中第一个请求
        return (Request) queue.remove();
    }

    public synchronized void addRequest(Request request) {
        queue.add(request);
        notifyAll();
    }
}

package effectivejava.CH4.javatuning.ch4.future.pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {
        //发起请求
        Client client = new Client();
        //这里会立即返回，因为得到的是FutureData而不是RealData
        Data data = client.request("a");
        log.info("请求完毕");
        try {
            /**
             * 可以用sleep代替对其他业务逻辑的处理
             * 处理业务逻辑过程中，RealData被创建，从而充分利用了等待时间
             */
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        //使用真实的数据
        log.info("数据 = " + data.getResult());
    }
}

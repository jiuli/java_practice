package effectivejava.CH2.javatuning.ch2.proxy.future_pattern;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/22 14:08
 * @since 1.0
 */
@Slf4j
public class RealData implements Data {
    private String result;

    @Override
    public String getRequest() {
        return result;
    }

    public RealData(String request) {
        log.info("根据" + request + "进行查询。。。。。要花很久");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("操作完成，获取结果");
        result = "查询结果";
    }
}

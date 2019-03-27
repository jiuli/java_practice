package effectivejava.CH4.javatuning.ch4.mstrwkr;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Map;
import java.util.Set;

@Slf4j
public class TestMasterWorker {

    public class PlusWorker extends Worker {
        @Override
        public Object handle(Object input) {
            Integer i = (Integer) input;
            return i * i * i;
        }
    }

    @Test
    public void testMasterWorker() {
        //固定5个Worker,并指定Worker
        Master m = new Master(new PlusWorker(), 5);
        //提交100个子任务
        for (int i = 0; i < 100; i++) {
            m.submit(i);
        }
        //开始计算
        m.execute();
        int re = 0;
        Map<String, Object> resultMap = m.getResultMap();
        while (resultMap.size() > 0 || !m.isComplete()) {
            //不需要等待所有Worker都执行完，即可计算最终结果
            Set<String> keys = resultMap.keySet();
            String key = null;
            for (String k : keys) {
                key = k;
                break;
            }
            Integer i = null;
            if (key != null)
                i = (Integer) resultMap.get(key);
            if (i != null)
                re += i;
            //移除已经被计算过的
            if (key != null)
                resultMap.remove(key);
        }

        log.info("testMasterWorker:" + re);
    }

    @Test
    public void testPlus() {
        int re = 0;
        for (int i = 0; i < 100; i++) {
            re += i * i * i;
        }
        System.out.println("testPlus:" + re);
    }

}

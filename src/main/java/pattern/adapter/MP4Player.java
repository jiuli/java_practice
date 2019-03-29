package pattern.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/29 9:27
 * @since 1.0
 */
@Slf4j
public class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        //不处理
    }

    @Override
    public void playMP4(String fileName) {
        log.info("Playing mp4 file name:" + fileName);
    }
}

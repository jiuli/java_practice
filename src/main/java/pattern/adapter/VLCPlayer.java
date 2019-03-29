package pattern.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/29 9:26
 * @since 1.0
 */
@Slf4j
public class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        log.info("Playing vlc file name:" + fileName);
    }

    @Override
    public void playMP4(String fileName) {
        //不处理
    }
}

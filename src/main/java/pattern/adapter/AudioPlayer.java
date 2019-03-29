package pattern.adapter;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lijunsong
 * @date 2019/3/29 9:37
 * @since 1.0
 */
@Slf4j
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;


    @Override
    public void play(String audioType, String fileName) {
        switch (audioType.toLowerCase()) {
            case "mp3":
                log.info("Playing mp3 file name: " + fileName);
            case "vlc":
            case "mp4":
                mediaAdapter = new MediaAdapter(audioType);
                mediaAdapter.play(audioType, fileName);
                break;
            default:
                log.info("Invalid media." + audioType + " format not supported.");
                break;
        }
    }
}

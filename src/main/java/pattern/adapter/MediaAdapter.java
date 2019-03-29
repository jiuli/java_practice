package pattern.adapter;

/**
 * 适配器类
 *
 * @author lijunsong
 * @date 2019/3/29 9:28
 * @since 1.0
 */
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        switch (audioType.toLowerCase()) {
            case "vlc":
                advancedMediaPlayer = new VLCPlayer();
                break;

            case "mp4":
                advancedMediaPlayer = new MP4Player();
                break;
            default:
                break;
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        switch (audioType.toLowerCase()) {
            case "vlc":
                advancedMediaPlayer.playVLC("vlc");
                break;
            case "mp4":
                advancedMediaPlayer.playMP4("mp4");
                break;
            default:
                break;
        }
    }


}

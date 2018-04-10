public class MediaAdapter implements MediaPlayer {
    private AdvancedMediaPlayer _player;

    public MediaAdapter(String type) {
        if (type.equalsIgnoreCase("mp4")) {
            _player = new Mp4Player();
        }
        if (type.equalsIgnoreCase("vli")) {
            _player = new VlcPlayer();
        }
    }

    @Override
    public void play(String type, String name) {
        if(type.equalsIgnoreCase("vlc")){
            _player.playVlc(name);
        }else if(type.equalsIgnoreCase("mp4")){
            _player.playMp4(name);
        }
    }
}

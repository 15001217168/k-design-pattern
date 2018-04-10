public class Mp4Player implements IAdvancedMediaPlayer {
    @Override
    public void playVlc(String name) {

    }

    @Override
    public void playMp4(String name) {
        System.out.println("Playing mp4 file. Name: "+ name);
    }
}

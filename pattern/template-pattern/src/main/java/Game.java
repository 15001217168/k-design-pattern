public abstract class Game {
    abstract  void  init();
    abstract  void  start();
    abstract  void  stop();
    public  final void  play()
    {
        init();
        start();
        stop();
    }
}

public class Cricket extends Game {
    @Override
    void init() {
        System.out.println("Cricket Game init! Start playing.");
    }

    @Override
    void start() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }

    @Override
    void stop() {
        System.out.println("Cricket Game Finished!");
    }
}

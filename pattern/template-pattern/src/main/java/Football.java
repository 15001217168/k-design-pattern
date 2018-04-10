public class Football extends  Game {
    @Override
    void init() {
        System.out.println("Football Game init! Start playing.");
    }

    @Override
    void start() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void stop() {
        System.out.println("Football Game Finished!");
    }
}

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GameStore store = new GameStore();
        store.addPlayTime("Vlad",50);
        store.addPlayTime("Anna",50);
        System.out.println(store.getSumPlayedTime());
     }
}


//    GameStore store = new GameStore();
//    Game football = store.publishGame("Football", "sport");
//    Game tennis = store.publishGame("Tennis", "sport");
//    Game batman = store.publishGame("Batman", "action");
//    Game spider = store.publishGame("Spider-man", "action");
//    Game chess = store.publishGame("Chess", "desktop");
//    Game monopoly = store.publishGame("Monopoly", "desktop");
//        store.publishGame("Monopoly", "desktop");
//                Game puzzle=new Game("Puzzle","desktop",store);
// for (int i = 0; i < store.getGames().size(); i++) {
//        System.out.print(store.getGames().get(i));
//        }
//Game spider = store.publishGame("Spider-man", "action");
//    Player player = new Player("Anton");
//        player.installGame(tennis);
//                player.play(tennis,10);
//                player.play(tennis,10);

//store.addPlayTime("Anton",25);
//        store.addPlayTime("John",35);
//        store.addPlayTime("Bob",30);
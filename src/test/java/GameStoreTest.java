import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("NFS", "racing");

        Assertions.assertTrue(store.containsGame(game));
    }

    @Test

    public void showAddedTime() {
        Player player = new Player("Vitya");
        GameStore store = new GameStore();
        Game gameNfs = store.publishGame("NFS", "racing");
        player.installGame(gameNfs);
        store.addPlayTime("Vitya", 20);

        int expected = 40;
        int actual = store.addPlayTime("Vitya", 20);



        Assertions.assertEquals(expected, actual);


    }
   @Test
           public void showMostPlayer() {

       Player playerVitya = new Player("Vitya");
       Player playerKolya = new Player("Kolya");
       GameStore store = new GameStore();
       Game gameNfs = store.publishGame("NFS", "racing");
       playerVitya.installGame(gameNfs);
       playerKolya.installGame(gameNfs);

       store.addPlayTime("Vitya", 50);
       store.addPlayTime("Kolya",40);

       String actual = store.getMostPlayer();

       Assertions.assertTrue(actual== playerVitya.getName());

   }
   @Test

    public void showAllPlayedTimeInStore(){
       GameStore store = new GameStore();
       Player playerVitya = new Player("Vitya");
       Player playerKolya = new Player("Kolya");

       Game gameNfs = store.publishGame("NFS", "racing");
       playerVitya.installGame(gameNfs);
       playerKolya.installGame(gameNfs);

       store.addPlayTime("Vitya", 50);
       store.addPlayTime("Kolya",40);

       int expected = 90;
       int actual = store.getSumPlayedTime();

       Assertions.assertEquals(expected, actual);


   }
    @Test

    public void showMostPlayerWhenNoOnePlaying(){
        GameStore store = new GameStore();


        Assertions.assertNull(store.getMostPlayer());


    }
    @Test

    public void showAllPlayedTimeInStoreWhenNoOneWasPlaying(){
        GameStore store = new GameStore();
        int expected = 0;
        int actual = store.getSumPlayedTime();

        Assertions.assertEquals(expected, actual);


    }
@Test
    public void shouldNotShowTheGameOfAnotherStore() {

        GameStore storeOne = new GameStore();
        GameStore storeTwo = new GameStore();

        Game gameLrs = storeTwo.publishGame("Lrs", "racing");

        Assertions.assertFalse(storeOne.containsGame(gameLrs));
    }

}

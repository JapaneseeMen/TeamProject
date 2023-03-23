import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class PlayerTest {
    GameStore store = new GameStore();
    Game football = store.publishGame("Football", "sport");
    Game tennis = store.publishGame("Tennis", "sport");
    Game basketball = store.publishGame("Basketball", "sport");
    Game batman = store.publishGame("Batman", "action");
    Game spider = store.publishGame("Spider-man", "action");
    Game portal = store.publishGame("Portal", "action");
    Game chess = store.publishGame("Chess", "desktop");
    Game monopoly = store.publishGame("Monopoly", "desktop");
    Game puzzle = new Game("Puzzle", "desktop", store);
    Player player = new Player("Anton");

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getNameTest() {
        Player player1 = new Player("Vlad");
        Assertions.assertEquals("Vlad", player1.getName());
    }
    @Test
    public void installGameWithoutPublishTest(){
        player.installGame(puzzle);
        Assertions.assertEquals(0, player.getPlayedTime().size());
    }
    @Test
    public void installGameWithTest(){
        player.installGame(tennis);
        player.installGame(puzzle);
        Assertions.assertEquals(1, player.getPlayedTime().size());
    }
    @Test
    public void installGameTest() {
        player.installGame(football);
        player.installGame(tennis);
        player.installGame(monopoly);
        Assertions.assertEquals(3, player.getPlayedTime().size());

    }

    @Test
    public void getTimeNewPlayerTest() {
        player.installGame(spider);
        Assertions.assertEquals(0, player.play(spider, 0));

    }

    @Test
    public void installExistsGameTest() {
        player.installGame(football);
        player.installGame(tennis);
        player.installGame(monopoly);
        player.installGame(monopoly);
        Assertions.assertEquals(3, player.getPlayedTime().size());

    }

    @Test
    public void sumTimePlayTest() {
        player.installGame(football);
        player.installGame(tennis);
        player.play(football, 6);
        player.play(football, 10);
        Assertions.assertEquals(20, player.play(football, 4));

    }

    @Test
    public void playNotInstallGameTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            player.play(football, 5);
        });
        Assertions.assertNotNull(exception.getMessage());
    }

    @Test
    public void checkTextExceptionTest() {
        Exception exception = assertThrows(Exception.class, () -> {
            player.play(football, 5);
        });
        Assertions.assertTrue(exception.getMessage().contains("игра не установлена"));
    }

    @Test
    public void shouldSumTimeByGenresGames() {
        player.installGame(football);
        player.installGame(monopoly);
        player.installGame(batman);
        player.play(football, 20);
        player.play(football, 20);
        player.play(monopoly, 30);
        player.play(monopoly, 30);
        player.play(batman, 10);
        player.play(batman, 10);
        Assertions.assertEquals(40, player.sumGenre("sport"));
        Assertions.assertEquals(60, player.sumGenre("desktop"));
        Assertions.assertEquals(20, player.sumGenre("action"));

    }

    @Test
    public void shouldSumTimeByGenreTest() {
        player.installGame(basketball);
        Assertions.assertEquals(0, player.sumGenre("sport"));
    }

    @Test
    public void sumGenreWithoutInstallGamesTest() {
        Assertions.assertEquals(0, player.sumGenre("sport"));
    }

    @Test
    public void sumGenreAnyGamesTest() {
        player.installGame(spider);
        player.play(spider, 15);
        Assertions.assertEquals(0, player.sumGenre("sport"));
    }

    @Test
    public void sumGenreActionGamesTest() {
        player.installGame(spider);
        player.installGame(batman);
        player.installGame(portal);
        player.installGame(chess);
        player.play(spider, 15);
        player.play(batman, 15);
        player.play(portal, 15);
        player.play(chess, 50);
        Assertions.assertEquals(45, player.sumGenre("action"));
    }

    @Test
    public void mostPlayerByGenreAction() {
        player.installGame(spider);
        player.installGame(batman);
        player.installGame(portal);
        player.installGame(chess);
        player.play(spider, 15);
        player.play(batman, 15);
        player.play(portal, 50);
        player.play(portal, 30);
        Assertions.assertEquals(portal, player.mostPlayerByGenre("action"));
    }

    @Test
    public void mostPlayerByNullGenre() {
        player.installGame(spider);
        player.installGame(batman);
        player.installGame(chess);
        player.play(chess, 15);
        player.play(chess, 15);
        Assertions.assertEquals(null, player.mostPlayerByGenre("action"));
    }

    @Test
    public void mostPlayerByGenreDesktop() {
        player.installGame(spider);
        player.installGame(monopoly);
        player.installGame(chess);
        player.play(chess, 15);
        Assertions.assertEquals(chess, player.mostPlayerByGenre("desktop"));
    }
}

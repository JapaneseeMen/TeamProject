public class NotInstalledException extends RuntimeException{
    public NotInstalledException(Game game) {
        super(game.getTitle()+": игра не установлена");
    }
}

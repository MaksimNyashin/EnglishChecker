import java.awt.*;

public class Main {
    private static NewGame newGame;
    private static Font font = new Font("Dialog", Font.PLAIN, 20);
    private static boolean hide;
    private static int onPage;
    private static String language = "English";
    private static String test = "qwe.txt";
    private static int widthOne = 192, heightOne = 108;

    public static void main(String[] args) {
	// write your code here
        hide = true;
        onPage = 10;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        heightOne = screenSize.height / 10;
        widthOne = screenSize.width / 10;
        new NewGame();
    }

    public static NewGame getNewGame() {
        return newGame;
    }
    public static void setNewGame(NewGame newNewGame) {
        newGame = newNewGame;
    }

    public static Font getFont() {
        return font;
    }

    public static boolean isHide() {
        return hide;
    }
    public static  boolean needShow(){
            return (!hide);
    }
    public static  void setHide(boolean newHide) {
        hide = newHide;
    }
    public static  void setShow(boolean newShow){
        hide = (!newShow);
    }

    public static int getOnPage() {
        return onPage;
    }

    public static String getLanguage() {
        return language;
    }
    public static void setLanguage(String language) {
        Main.language = language;
    }

    public static String getTest() {
        return test;
    }
    public static void setTest(String test) {
        Main.test = test;
    }

    public static int getHeightOne() {
        return heightOne;
    }

    public static int getWidthOne() {
        return widthOne;
    }
}

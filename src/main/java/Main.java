import Controller.PeopleAppController;
import Data.DatabasePool;
import GUI.GUIMain;


public class Main {
    public static void main(String[] args) {
        GUIMain gui = new GUIMain();
        DatabasePool databasePool = new DatabasePool();
        PeopleAppController controller = new PeopleAppController(databasePool, gui);
        controller.start();
    }
}

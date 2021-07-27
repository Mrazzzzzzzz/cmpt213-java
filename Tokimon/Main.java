package Documents.cmpt213.a1.Tokimon;

import java.util.ArrayList;
import java.util.List;

/**
 * Main Class runs for testing
 */

public class Main {
    public static void main(String[] args){
        TokimonTrackerMenu main_menu = new TokimonTrackerMenu("Main Menu");
        List<Tokimon> tokimons_list = new ArrayList<>();
        main_menu.displayMainMenu(tokimons_list);
    }
}

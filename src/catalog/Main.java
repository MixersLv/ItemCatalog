package catalog;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Object o = new Object();



        Logic logic = new Logic();
        ItemManagerFrontend itemManagerFrontend = new ItemManagerFrontend(logic);
        ItemDeleteFrontend itemDeleteFrontend = new ItemDeleteFrontend(logic);
        Frontend frontend = new Frontend(logic, itemManagerFrontend, itemDeleteFrontend);

        // used so i dont need to pass in the current itemmanagerFRE in the logic object
        logic.setItemManagerFrontendClass(itemManagerFrontend);

        logic.run();
        frontend.makeCatalogFrame();
        frontend.makeCatalogManagerFrame();
        frontend.makeFrame();
    }
}

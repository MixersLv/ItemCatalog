package catalog;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Logic logic = new Logic();
        ItemManagerFrontend itemManagerFrontend = new ItemManagerFrontend(logic);
        Frontend frontend = new Frontend(logic, itemManagerFrontend);

        logic.run();
        frontend.makeCatalogFrame();
        frontend.makeCatalogManagerFrame();
        frontend.makeFrame();
    }
}

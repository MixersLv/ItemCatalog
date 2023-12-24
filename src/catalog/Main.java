package catalog;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Logic logic = new Logic();
        Frontend frontend = new Frontend(logic);

        logic.run();
        frontend.makeCatalogFrame();
        frontend.makeCatalogManagerFrame();
        frontend.makeFrame();
    }
}

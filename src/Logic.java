import java.awt.event.ActionListener;

public class Logic {
    private Frontend frontend = new Frontend();
    public void run(){
        frontend.makeFrame();
    }

    public void makeItem(){
        System.out.println("MAKE");
    }
    public void saveCatalog(){
        System.out.println("SAVE");
    }
    public void loadCatalog(){
        System.out.println("LOAD");
    }



}

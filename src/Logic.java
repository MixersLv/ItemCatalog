import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logic {
    // TODO
    // have to fix the fact the makeItemObject method only makes the last line of the scanner, have to make it iterate through everything somehow.
    List addedItems = new ArrayList<String>();
    Scanner scanner;
    String itemName;
    String itemType;
    String itemPrice;

    public void run() throws IOException {
        makeSaveFile();
        readCatalog();
    }
    public void makeSaveFile() throws IOException {
        if (Files.notExists(Path.of("./catalog.txt"))){
            Files.createFile(Path.of("./catalog.txt"));
        }
        //DO NOTHING
    }
    // Name, type, price

    public void makeItem(){
        Scanner userinput = new Scanner(System.in);
        System.out.println("Enter the properties for the item: ");
        String itemProperties = userinput.nextLine();
        addedItems.add(itemProperties);
        System.out.println("Item was added to the list!");
    }
    public void saveCatalog() throws IOException {
        for (int i = 0; i < addedItems.size(); i++) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./catalog.txt",true));
            writer.write(addedItems.get(i)+"\n");
            writer.close();
        }
        addedItems.clear();
        System.out.println("All changes were saved!");
    }
    public void readCatalog() throws IOException {
        scanner = new Scanner(Path.of("./catalog.txt"));
        while (scanner.hasNextLine()){
            String currentLine = scanner.nextLine();
            separateString(currentLine);
        }
    }
    public void separateString(String currentline){
        itemName = currentline.substring(0,currentline.lastIndexOf("."));
        itemType = currentline.substring(currentline.lastIndexOf(".")+1,currentline.lastIndexOf("="));
        itemPrice = currentline.substring(currentline.lastIndexOf("=")+1);
    }
    public void loadCatalog() throws IOException {
        readCatalog();

    }

}

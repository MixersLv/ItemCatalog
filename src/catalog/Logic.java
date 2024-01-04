package catalog;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Logic {
    private final List<CatalogItem> items = new ArrayList<>();
    private ItemManagerFrontend itemManagerFrontendClass;
    private Scanner scanner;
    //SETTER
    public void setItemManagerFrontendClass(ItemManagerFrontend itemManagerFrontendClass){
        this.itemManagerFrontendClass = itemManagerFrontendClass;
    }
    //METHODS
    public void run() throws IOException {
        makeSaveFile();
        readCatalog();
    }

    public void makeSaveFile() throws IOException {
        Path path = Path.of("./catalog.txt");
        if (Files.notExists(path)) {
            Files.createFile(path);
        }
        //DO NOTHING
    }
    public void saveCatalog() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("./catalog.txt"));
        for (int i = 0; i < items.size(); i++) {
            writer.write(items.get(i) + "\n");
        }
        writer.close();
        System.out.println("All changes were saved!");
    }

    public void readCatalog() throws IOException {
        scanner = new Scanner(Path.of("./catalog.txt"));
        while (scanner.hasNextLine()) {
            String currentLine = scanner.nextLine();
            separateString(currentLine);
        }
    }

    public void separateString(String itemData) {
        String itemName = itemData.substring(0, itemData.lastIndexOf("."));
        String itemType = itemData.substring(itemData.lastIndexOf(".") + 1, itemData.lastIndexOf("="));
        String itemPrice = itemData.substring(itemData.lastIndexOf("=") + 1);

        CatalogItem newItem = new CatalogItem(itemName, itemType, itemPrice);
        items.add(newItem);
    }

    public void saveItemProperties(){
        String currentItemName = itemManagerFrontendClass.getNameTextField().getText();
        String currentItemType = itemManagerFrontendClass.getTypeTextField().getText();
        String currentItemPrice = itemManagerFrontendClass.getPriceTextField().getText();

        items.add(new CatalogItem(currentItemName, currentItemType, currentItemPrice));
        System.out.println("Item has been added to the list\nDont forget to save!");
    }

    //GETTERS
    public List<CatalogItem> getItems() {
        return items;
    }

}

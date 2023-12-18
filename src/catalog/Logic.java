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
    // TODO
    // have to fix the fact the makeItemObject method only makes the last line of the scanner, have to make it iterate through everything somehow.
    private final List addedItems = new ArrayList<String>();
    private final List<CatalogItem> items = new ArrayList<>();
    private Scanner scanner;

    public void run() throws IOException {
        makeSaveFile();
        readCatalog();
    }

    public void makeSaveFile() throws IOException {
        if (Files.notExists(Path.of("./catalog.txt"))) {
            Files.createFile(Path.of("./catalog.txt"));
        }
        //DO NOTHING
    }
    // Name, type, price

    public void makeItem() {
        Scanner userinput = new Scanner(System.in);
        System.out.println("Enter the properties for the item: ");
        String itemProperties = userinput.nextLine();
        addedItems.add(itemProperties);
        System.out.println("Item was added to the list!");
    }

    public void saveCatalog() throws IOException {
        for (int i = 0; i < addedItems.size(); i++) {
            BufferedWriter writer = new BufferedWriter(new FileWriter("./catalog.txt", true));
            writer.write(addedItems.get(i) + "\n");
            writer.close();
        }
        addedItems.clear();
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

    public List<CatalogItem> getItems() {
        return items;
    }
}

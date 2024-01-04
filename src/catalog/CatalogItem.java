package catalog;

public class CatalogItem {
    private final String type;
    private final String price;
    private final String name;

    public CatalogItem(String name, String type, String price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getName() + '.' + getType() + '=' + getPrice();
    }
}

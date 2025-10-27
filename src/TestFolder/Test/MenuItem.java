package Test;

public class MenuItem {
    private final int key;
    private final String menuName;
    private final int  menuPrice;
    private final String  information;

    MenuItem(int key, String menuName, int menuPrice, String information) {
        this.key = key;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.information = information;
    }

    int getKey() {
        return key;
    }

    void printMenu() {
        System.out.println(key + ". " + menuName + " | " + menuPrice + "원 | " + information);
    }
}

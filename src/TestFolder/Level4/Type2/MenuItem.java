package TestFolder.Level4.Type2;

public class MenuItem {
    private final String Menuname;
    private final Integer MenuPrice;
    private final String MenuInfomation;

    MenuItem(String Menuname, Integer MenuPrice, String MenuInfomation) {
        this.Menuname = Menuname;
        this.MenuPrice = MenuPrice;
        this.MenuInfomation = MenuInfomation;
    }

    String menuPrint(int index){
        return index + ". " + Menuname + " | " + MenuPrice + "원 | " + MenuInfomation;
    }
}
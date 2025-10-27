package TestFolder.Level3;

public class MenuItem {
    private final String Menuname;
    private final Integer MenuPrice;
    private final String MenuInfomation;


    MenuItem(String Menuname, Integer MenuPrice, String MenuInfomation) {
        this.Menuname = Menuname;
        this.MenuPrice = MenuPrice;
        this.MenuInfomation = MenuInfomation;
    }

    void menuPrint(int index){
        System.out.println(index + ". " + Menuname + " | " + MenuPrice + "원 | " + MenuInfomation);
    }
}

package Level4.Type1;

public class MenuItem {
    private final String Menuname;
    private final Integer MenuPrice;
    private final String MenuInfomation;

    MenuItem(String Menuname, Integer MenuPrice, String MenuInfomation) {
        this.Menuname = Menuname;
        this.MenuPrice = MenuPrice;
        this.MenuInfomation = MenuInfomation;
    }

    /**
     * 생성자에 넣어진 데이터 하나씩 뽑아오는 객체
     * @param index
     * @return
     */
    String menuPrint(int index){
        return index + ". " + Menuname + " | " + MenuPrice + "원 | " + MenuInfomation;
    }
}
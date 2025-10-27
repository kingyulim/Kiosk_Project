package Level5.Type2;

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
     * 캡슐화된 MenuItem속성 데이터 메뉴이룸, 가격, 설명 한줄씩 반환하는 객체
     * @return MenuItem속성 데이터 한줄씩 반환
     */
    String menuPrint(){
        return Menuname + " | " + MenuPrice + "원 | " + MenuInfomation;
    }
}

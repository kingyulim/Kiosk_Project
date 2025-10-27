package Level3;

public class MenuItem {
    private final String menuName;
    private final Integer menuPrice;
    private final String menuInfomation;

    MenuItem(String data1, Integer data2, String data3) {
        this.menuName = data1;
        this.menuPrice = data2;
        this.menuInfomation = data3;
    }

    /**
     * 캡슐화된 메뉴 데이터들을 이어 프린트 형식을오 반환하는 객체
     * @return 메뉴 정보들 프린트 형식으로 반환
     */
    String getMenuPrint() {
        return this.menuName + " | " +  this.menuPrice + " 원 | " + this.menuInfomation;
    }
}

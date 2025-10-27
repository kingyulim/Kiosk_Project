package Challenge.Level1.Type2;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String menuCategoryName;
    private final List<MenuItem> menuList = new ArrayList<>();

    Menu(String data1){
        this.menuCategoryName = data1;
    }

    /**
     * 메뉴의 카테고리 이름을 뽑아오는 객체
     * @return 매뉴 카테고리 이름 반환
     */
    String getMenuCategoryName(){
        return this.menuCategoryName;
    }

    /**
     * 저장된 메뉴 데이터를 뽑아오는 객체
     * @return menuList 반환
     */
    List<MenuItem> getMenuList(){
        return menuList;
    }

    /**
     * MenuItem 배열에 데이터 추가하는 함수
     * @param data1 매개변수 MenuItem 형태의 데이터 추가
     */
    void addMenuItem(MenuItem data1){
        menuList.add(data1);
    }
}

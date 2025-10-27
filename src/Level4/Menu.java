package Level4;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String menuCategoryName;
    private final List<MenuItem> menuItems;

    Menu(String data1) {
        this.menuCategoryName = data1;

        this.menuItems = new ArrayList<>();
    }

    /**
     * 캡술화된 getMenuCategoryName 가져오는 객체
     * @return
     */
    String getMenuCategoryName() {
        return menuCategoryName;
    }

    /**
     * 캡슐화된 menuItems에 저장된 배열을 가져오는 객체
     * @return
     */
    List<MenuItem> getMenuItem() {
        return this.menuItems;
    }

    /**
     * 캡슐화된 addMenuItem 에 배열을 넣는 함수
     * @param data1
     */
    void addMenuItem(MenuItem data1) {
        this.menuItems.add(data1);
    }
}

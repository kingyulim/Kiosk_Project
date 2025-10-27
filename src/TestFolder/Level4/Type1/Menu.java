package Level4.Type1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private final String categoryName;
    private final List<MenuItem> menuArr;

    public Menu(String data1) {
        this.categoryName = data1;
        this.menuArr = new ArrayList<>();
    }

    /**
     * 캡슐화 돼 있는 카테고리 이름 가져오는 객체
     * @return 카테고리 이름 반환
     */
    String getCategoryName() {
        return categoryName;
    }

    /**
     * 캡슐화 돼 있는 각 카테고리별 데이터 가져오는 객체
     * @return 카테고리별 메뉴 리스트 반환
     */
    List<MenuItem> getMenuArr() {
        return menuArr;
    }

    /**
     * MenuItem 의 객체만 담을 수 있는 데이터를 추가 하는 객체
     * @param data1 MenuItem 객체 데이터 삽입
     */
    void addMenuItem(MenuItem data1) {
        menuArr.add(data1);
    }
}

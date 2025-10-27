package Level3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("알리오올리오", 5000, "마늘과 페페론치노를 올리브 오일에 잘 버무린 이탈리아 정통 크리미한 파스타"));
        menuItems.add(new MenuItem("뽀모도로파스타", 8000, "싱싱한 토마토를 당일날에 수확하여 소스를 만들어 버무린 파스타"));
        menuItems.add(new MenuItem("까르보나라파스타", 9000, "싱싱한 유정란을 사용하고 관찰레를 사용한 꾸덕꾸덕한 이탈리아 정통 파스타"));
        menuItems.add(new MenuItem("바질페스토파스타", 7000, "생 바질을 수작업으로 만든 바질페스토를 이용하여 버무린 파스타"));
        menuItems.add(new MenuItem("감자뇨끼", 11000, "수작업으로 작업한 뇨끼를 부드러운 크림을 이용하여 요리 하였습니다"));

        Kiosk Kiosk = new Kiosk(menuItems);

        Kiosk.start();
    }
}

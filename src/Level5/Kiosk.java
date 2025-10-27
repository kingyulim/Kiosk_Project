package Level5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menuCategory;

    Kiosk() {
        this.menuCategory = new ArrayList<>();

        Menu wineMenu = new Menu("wineMenu");
        Menu mainMenu = new Menu("mainMenu");
        Menu dessertMenu = new Menu("dessertMenu");

        wineMenu.addMenuItem(new MenuItem("무똥 까데 루즈", 20000, "각종 고기 요리 및 치즈류와 잘 어울리는 대중적인 와인"));
        wineMenu.addMenuItem(new MenuItem("이기깔 꼬뜨 뒤 론 루즈", 20000, "해산물요리 가금류 육류 크림파스타와 잘 어울리는 와인"));
        wineMenu.addMenuItem(new MenuItem("앙시앙땅 까베르네 쉬라", 30000, "두껍지 않은 스테이크나 로스트 비프 같은 서양식 고기 요리와 잘 어울리는 와인"));
        wineMenu.addMenuItem(new MenuItem("루이라뚜르 피노누나", 40000, "육류와 파스타, 피자와 두루두루 잘 어울리는 화이트 와인"));

        mainMenu.addMenuItem(new MenuItem("타르티플레트", 18000, "겨울에 알프스 지역에서 먹는 그라탕 추운날 몸을 든든하고 따듯하게 데워주는 프랑스 전통 요리"));
        mainMenu.addMenuItem(new MenuItem("뵈포 부르기뇽", 15000, "부르고뉴지방 요리 와인에 소고기를 푹 삶아 걸쭉하고 진한 소스가 인상적인 요리"));
        mainMenu.addMenuItem(new MenuItem("꼬꼬뱅", 12000, "와인에 닭을 푹 삶아낸 요리"));
        mainMenu.addMenuItem(new MenuItem("키슈 로렌느", 11500, "프랑스 로렌느 지방(알자스쪽)의 전통 요리, 파이에 계란, 크림, 베이컨을 넣어 아주 두툼하고 먹음직스러운 요리"));

        dessertMenu.addMenuItem(new MenuItem("마카롱 5p", 8000, "아몬드 가루와 설탕을 넣은 쿠키에 크림을 넣은 마카롱"));
        dessertMenu.addMenuItem(new MenuItem("크림 브륄레", 5000, "차가운 커스터드 크림 위에 설탕을 구워 녹여 깨먹는 재미가 있는 크림 브륄레"));
        dessertMenu.addMenuItem(new MenuItem("베이비 슈 2p", 6500, "빠다슈 위에 캐러멜을 입힌 베이비 슈"));
        dessertMenu.addMenuItem(new MenuItem("에끌레르 2p", 7000, "빠다슈 일종의 길쭉하고 다양한 맛이 나는 베이비 슈"));

        menuCategory.add(wineMenu);
        menuCategory.add(mainMenu);
        menuCategory.add(dessertMenu);
    }

    void start() {
        Scanner input = new Scanner(System.in);

        String[] menuNameArr = {"와인 메뉴", "메인 메뉴", "디저트 메뉴"};

        while (true) {
            System.out.println("\n[ 카테고리 ]");
            for (int i = 0; i < menuCategory.size(); i++) {
                String menuName = "";

                switch (menuCategory.get(i).getMenuCategoryName()) {
                    case "wineMenu":
                        menuName = menuNameArr[0];

                        break;

                    case "mainMenu":
                        menuName = menuNameArr[1];

                        break;

                    case "dessertMenu":
                        menuName = menuNameArr[2];

                        break;
                }

                System.out.println((i + 1) + ". " + menuName);
            }

            int menuCategoryNumber = 0;
            try {
                System.out.print("\n메뉴 카테고리 번호를 입력해주세요. \n(종료: 0): ");
                menuCategoryNumber = input.nextInt();
                input.nextLine();

                if (menuCategoryNumber == 0) {
                    break;
                }

                if (menuCategoryNumber < 1 || menuCategoryNumber > menuCategory.size()) {
                    System.out.println("\n입력하신 번호와 맞는 카테고리가 없습니다.\n");

                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n숫자만 입력해주세요.\n");
                input.nextLine();

                continue;
            }

            List<MenuItem> menuItemList;
            menuItemList = menuCategory.get(menuCategoryNumber - 1).getMenuItem();

            System.out.println("\n[ " + menuNameArr[menuCategoryNumber - 1] + " ]");
            for (int i = 0; i < menuItemList.size(); i++) {
                System.out.println((i + 1) + ". " + menuItemList.get(i).getMenuPrint());
            }

            int menuNumber = 0;
            try {
                System.out.print("\n메뉴 메뉴 번호를 입력해주세요. \n(뒤로가기: 0): ");
                menuNumber = input.nextInt();
                input.nextLine();

                if (menuNumber == 0) {
                    continue;
                }

                if (menuNumber < 1 || menuNumber > menuItemList.size()) {
                    System.out.println("\n입력하신 번호와 맞는 메뉴가 없습니다.\n");

                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("\n숫자만 입력해주세요.\n");
                input.nextLine();

                continue;
            }

            System.out.println("\n선택하신 메뉴: " + menuItemList.get(menuNumber - 1).getMenuPrint() + "\n");

            continue;
        }
    }
}

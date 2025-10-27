package Level4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<Menu> menuCategory;

    Kiosk(List<Menu> data1) {
        this.menuCategory = new ArrayList<>();

        menuCategory.addAll(data1);
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

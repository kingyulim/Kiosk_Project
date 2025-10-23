package Level5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menuItemsArr;

    Kiosk () {
        this.menuItemsArr = new ArrayList<>();

        this.menuItemsArr.add(new Menu("drink"));
        this.menuItemsArr.add(new Menu("food"));
        this.menuItemsArr.add(new Menu("desserts"));
    }
    
    void start () {
        Scanner sc = new Scanner(System.in);

        String exitCammand = "";

        String[] cateNameArr = {"와인", "음식", "디저트"};

        while (!exitCammand.equalsIgnoreCase("exit")) {
            System.out.println("[카테고리]");

            for (int a = 0; a < menuItemsArr.size(); a++) {
                Menu menuCateListArr = menuItemsArr.get(a);

                String menuCateName = "";
                String menuCateNameCode = menuCateListArr.getCategoryName();

                switch (menuCateNameCode) {
                    case "drink":
                        menuCateName = "1. " + cateNameArr[0];

                        break;

                    case "food":
                        menuCateName = "2. 음식" + cateNameArr[1];

                        break;

                    case "desserts":
                        menuCateName = "3. 디저트" + cateNameArr[2];

                        break;
                }

                System.out.println(menuCateName);
            }
            System.out.println("\n===============================================\n");

            System.out.print("카테고리 번호를 입력해주세요.\n(종료 : exit) : ");
            String choice = sc.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                System.out.println("\n===============================================\n");
                System.out.println("감사합니다. 또 이용해주세요.");
                System.out.println("\n===============================================\n");

                exitCammand = choice;

                break;
            }

            int choiceNum = 0;
            try {
                choiceNum = Integer.parseInt(choice);

                if (choiceNum < 1 || choiceNum > 3) {
                    System.out.println("\n===============================================\n");
                    System.out.println("일치하는 카테고리 번호가 없습니다.\n");

                    continue;
                }
            } catch(NumberFormatException e) {
                System.out.println("\n===============================================\n");
                System.out.println("숫자를 입력하거나 'exit'를 입력해주세요.\n");

                continue;
            }

            int thisIndex = choiceNum - 1;

            Menu thisMenuArr = menuItemsArr.get(thisIndex);
            List<MenuItem> thisMenuArrList = thisMenuArr.getMenuArr();

            System.out.println("\n===============================================\n");
            System.out.println("[" + cateNameArr[thisIndex] + "]");

            for (int a = 0; a < thisMenuArrList.size(); a++) {
                System.out.println(thisMenuArrList.get(a).menuPrint(a + 1));
            }

            System.out.println("\n===============================================\n");

            System.out.print("메뉴 번호를 입력해주세요.\n(뒤로가기 : prev) : ");
            String menuNumber = sc.nextLine();

            if (menuNumber.equalsIgnoreCase("prev")) {
                continue;
            }

            try {
                int menuNum = Integer.parseInt(menuNumber);

                if  (menuNum < 1 || menuNum > thisMenuArrList.size()) {
                    System.out.println("\n===============================================\n");

                    System.out.println("입력하신 메뉴 번호는 존재하지 않는 메뉴 입니다.");

                    System.out.println("\n===============================================\n");

                    continue;
                }

                System.out.println("\n===============================================\n");

                MenuItem thisCategoryItem = thisMenuArrList.get(menuNum - 1);
                System.out.println("주문하신 메뉴 : " + thisCategoryItem.menuPrint(menuNum));

                System.out.println("\n===============================================\n");

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");

                continue;
            }
        }

        sc.close();
    }

    List<Menu> getMenuItemsArr() {
        return menuItemsArr;
    }
}

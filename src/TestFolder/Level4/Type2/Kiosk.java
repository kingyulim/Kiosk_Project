package Level4.Type2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menuCateDrink;
    private final List<MenuItem> menuCateFood;
    private final List<MenuItem> menuCateDesserts;

    private final String menuCateDrinkName;
    private final String menuCateFoodName;
    private final String menuCateDessertsName;

    Kiosk(String menuCateDrinkNameData, String menuCateFoodNameData, String menuCateDessertsNameData, List<MenuItem> menuCateDrink,  List<MenuItem> menuCateFood, List<MenuItem> menuCateDesserts) {
        this.menuCateDrinkName = menuCateDrinkNameData;
        this.menuCateFoodName = menuCateFoodNameData;
        this.menuCateDessertsName = menuCateDessertsNameData;

        this.menuCateDrink = menuCateDrink;
        this.menuCateFood = menuCateFood;
        this.menuCateDesserts = menuCateDesserts;
    }

    void start() {
        Scanner sc = new Scanner(System.in);

        String exitCammand = "";
        while (!exitCammand.equalsIgnoreCase("exit")) {
            System.out.println("[카테고리]");
            System.out.println("1. " + menuCateDrinkName + "\n2. " + menuCateFoodName + "\n3. " + menuCateDessertsName + "\n");
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

            List<MenuItem> categoryDataArr = new ArrayList<>();
            String categoryName = "";
            switch (choiceNum) {
                case 1:
                    categoryDataArr = menuCateDrink;
                    categoryName = menuCateDrinkName;

                    break;

                case 2:
                    categoryDataArr = menuCateFood;
                    categoryName = menuCateFoodName;

                    break;

                case 3:
                    categoryDataArr = menuCateDesserts;
                    categoryName = menuCateDessertsName;

                    break;
            }

            System.out.println("\n===============================================\n");
            System.out.println("[" + categoryName + "]");

            for (int a = 0; a < categoryDataArr.size(); a++) {
                MenuItem categoryItem = categoryDataArr.get(a);
                System.out.println(categoryItem.menuPrint(a + 1));
            }

            System.out.println("\n===============================================\n");

            System.out.print("메뉴 번호를 입력해주세요.\n(뒤로가기 : prev) : ");
            String menuNumber = sc.nextLine();

            if (menuNumber.equalsIgnoreCase("prev")) {
                continue;
            }

            try {
                int menuNum = Integer.parseInt(menuNumber);

                if  (menuNum < 1 || menuNum > categoryDataArr.size()) {
                    System.out.println("\n===============================================\n");

                    System.out.println("입력하신 메뉴 번호는 존재하지 않는 메뉴 입니다.");

                    System.out.println("\n===============================================\n");

                    continue;
                }

                System.out.println("\n===============================================\n");

                MenuItem thisCategoryItem = categoryDataArr.get(menuNum - 1);
                System.out.println("주문하신 메뉴 : " + thisCategoryItem.menuPrint(menuNum));

                System.out.println("\n===============================================\n");

            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");

                continue;
            }
        }
    }
}

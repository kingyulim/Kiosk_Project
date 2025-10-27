package Level4.Type1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menuBook;

    Kiosk(Menu data1, Menu data2, Menu data3) {
        this.menuBook = new ArrayList<>();

        this.menuBook.add(data1);
        this.menuBook.add(data2);
        this.menuBook.add(data3);
    }

    void start (){
        Scanner sc = new Scanner(System.in);

        String[] categoryNameArr = {"와인", "음식", "디저트"};

        String exitCommand = "";
        while (!exitCommand.equalsIgnoreCase("exit")) {
            System.out.println("===============================================");
            System.out.println("[ 카테고리 ]");
            for (int i = 0; i < menuBook.size(); i++) {
                String categoryNameCode = menuBook.get(i).getCategoryName();

                String categoryName = "";
                if (categoryNameCode.equals("wine")) {
                    categoryName = categoryNameArr[0];
                } else if (categoryNameCode.equals("food")) {
                    categoryName = categoryNameArr[1];
                } else if (categoryNameCode.equals("dessert")) {
                    categoryName = categoryNameArr[2];
                }

                System.out.println((i + 1) + ". " + categoryName);
            }

            System.out.println("\n===============================================\n");

            System.out.print("카테고리 번호를 입력해주세요.\n(종료 : exit) : ");
            String choiceCategory = sc.nextLine();

            if (choiceCategory.equalsIgnoreCase("exit")) {
                System.out.println("\n===============================================\n");
                System.out.println("감사합니다. 또 이용해주세요.");
                System.out.println("\n===============================================\n");

                exitCommand = choiceCategory;
            }

            int choiceCategoryNum = 0;
            try {
                choiceCategoryNum = Integer.parseInt(choiceCategory);

                if (choiceCategoryNum < 1 || choiceCategoryNum > menuBook.size()) {
                    System.out.println("\n===============================================\n");
                    System.out.println("일치하는 카테고리 번호가 없습니다.\n");

                    continue;
                }
            } catch(NumberFormatException e) {
                System.out.println("\n===============================================\n");
                System.out.println("숫자를 입력하거나 'exit'를 입력해주세요.\n");

                continue;
            }

            int thisIndex = choiceCategoryNum - 1;

            System.out.println("\n===============================================\n");
            System.out.println("[" + categoryNameArr[thisIndex] + "]");

            List<MenuItem> thisMenuItemList = menuBook.get(thisIndex).getMenuArr();

            for (int i = 0; i < thisMenuItemList.size(); i++) {
                System.out.println(thisMenuItemList.get(i).menuPrint(i + 1));
            }

            System.out.println("\n===============================================\n");

            System.out.print("메뉴 번호를 입력해주세요.\n(뒤로가기 : prev) : ");
            String menuNumber = sc.nextLine();

            if (menuNumber.equalsIgnoreCase("prev")) continue;

            try {
                int menuNum = Integer.parseInt(menuNumber);

                if  (menuNum < 1 || menuNum > thisMenuItemList.size()) {
                    System.out.println("\n===============================================\n");

                    System.out.println("입력하신 메뉴 번호는 존재하지 않는 메뉴 입니다.");

                    System.out.println("\n===============================================\n");

                    continue;
                }

                System.out.println("\n===============================================\n");

                MenuItem thisCategoryItem = thisMenuItemList.get(menuNum - 1);
                System.out.println("주문하신 메뉴 : " + thisCategoryItem.menuPrint(menuNum));

                System.out.println("\n===============================================\n");
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력해주세요.");

                continue;
            }
        }
    }
}

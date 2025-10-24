package Challenge.Level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menuBookList = new ArrayList<>();

    Kiosk() {
        menuBookList.add(new Menu("wine"));
        menuBookList.add(new Menu("mainMenu"));
        menuBookList.add(new Menu("dessert"));
    }

    void start() {
        Scanner input = new Scanner(System.in);

        String[] menuCategoryArr = {"와인", "메인", "디저트"};
        List<String> shoppingBasketArr = new ArrayList<>();
        List<Integer> shoppingBasketPriceArr = new ArrayList<>();

        String exitCommand = "";
        int cnt = 0;

        FIRSTOUTSIDE: // 첫 와일 레이블
        while (!exitCommand.equalsIgnoreCase("exit")) {
            System.out.println("==============================================");
            System.out.println("[ 카테고리 ]");

            for (int i = 0; i < menuBookList.size(); i++) {
                String replaceCategoryName = "";

                switch(menuBookList.get(i).getCategoryName()) {
                    case "wine":
                        replaceCategoryName = menuCategoryArr[0];

                        break;

                    case "mainMenu":
                        replaceCategoryName = menuCategoryArr[1];

                        break;

                    case "dessert":
                        replaceCategoryName = menuCategoryArr[2];

                        break;
                }

                System.out.println((i + 1) + ". " + replaceCategoryName);
            }

            String categoryCommand = "";
            if (cnt > 0) {
                System.out.println("\n[ 오더 ]");
                System.out.println("1. 카테고리 번호를 입력해주세요 (커멘드: 메뉴 카테고리 숫자)");
                System.out.println("2. 장바구니 확인 후 주문 (커멘드: check)");
                System.out.println("3. 진행중인 주문을 취소 합니다 (커멘드: cencle)");
                System.out.println("4. 종료 (커멘드: exit)");
                System.out.print("커멘드를 입력해주세요: ");
                categoryCommand = input.nextLine();

                if (categoryCommand.equalsIgnoreCase("check")) {
                    Integer totalPrice = 0;
                    for (Integer i : shoppingBasketPriceArr) {
                        totalPrice += i;
                    }

                    System.out.println("\n[ 주문 내역 ]");
                    for (String str : shoppingBasketArr) {
                        System.out.println(str);
                    }
                    System.out.println("-------------------------------------");
                    System.out.println("총 주문 가격 : " + totalPrice + "원");

                    System.out.print("\n위와 같이 주문하시겠습니까?\n(예: yes) (아니오: no): ");
                    String orderCommand = input.nextLine();

                    if (orderCommand.equalsIgnoreCase("yes")) {
                        System.out.println("==============================================");
                        System.out.println("\n주문이 완료되었습니다. 금액은 " + totalPrice + "원 입니다.");

                        exitCommand = "exit";

                        break;
                    }else if (orderCommand.equalsIgnoreCase("no")) {
                        break FIRSTOUTSIDE;
                    }
                }
            } else {
                System.out.print("\n카테고리 번호를 입력해주세요.\n(종료 : exit): ");
                categoryCommand = input.nextLine();
            }

            if (categoryCommand.equalsIgnoreCase("exit")) {
                exitCommand = "exit";

                break;
            }

            int categoryCommandNumber = 0;
            try {
                categoryCommandNumber = Integer.parseInt(categoryCommand);

                if (categoryCommandNumber < 0 || categoryCommandNumber > menuBookList.size()) {
                    System.out.println("\n해당 카테고리 번호는 존재하지 않는 번호 입니다.\n");

                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("\n숫자만 입력해주세요.\n");

                continue;
            }

            String choiceMenu = "";
            String nextCommand1 = "";
            int menuCommandNumber = 0;
            List<MenuItem> thisMenuList;

            SECONDUTSIDE: // 두번째 와일 레이블
            while (true) {
                int thisCategoryIndex = categoryCommandNumber - 1;

                System.out.println("\n==============================================");
                System.out.println("\n[ " + menuCategoryArr[thisCategoryIndex] + " 메뉴 ]\n");

                thisMenuList = menuBookList.get(thisCategoryIndex).getMenuItemsList();
                for (int i = 0; i < thisMenuList.size(); i++) {
                    System.out.println((i + 1) + ". " + thisMenuList.get(i).menuPrint());
                }

                System.out.print("\n메뉴 번호를 입력해주세요.\n(이전 : prev): ");
                String menuCommand = input.nextLine();

                if (menuCommand.trim().isEmpty()) {
                    System.out.println("\n커멘드를 입력해주세요.");

                    continue;
                }

                if (menuCommand.equalsIgnoreCase("prev")) continue FIRSTOUTSIDE;

                menuCommandNumber = 0;
                try {
                    menuCommandNumber = Integer.parseInt(menuCommand);

                    if (menuCommandNumber < 0 || menuCommandNumber > thisMenuList.size()) {
                        System.out.println("\n해당 메뉴 번호는 존재하지 않는 번호 입니다.\n");

                        continue;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("\n숫자만 입력해주세요.\n");
                }

                choiceMenu = thisMenuList.get(menuCommandNumber - 1).menuPrint();

                System.out.println("\n선택한 메뉴: " + choiceMenu + "\n");

                while (true) {
                    System.out.print("(다음: next) (이전: prev) : ");
                    nextCommand1 = input.nextLine();

                    if (nextCommand1.trim().isEmpty()) {
                        System.out.println("\n커멘드를 입력해주세요.\n");

                        continue;
                    }

                    if (nextCommand1.equalsIgnoreCase("next")) {
                        break;
                    } else if(nextCommand1.equalsIgnoreCase("prev")) {
                        continue SECONDUTSIDE;
                    } else {
                        System.out.println("정확한 커멘드를 입력해주세요.");

                        break;
                    }
                }

                break;
            }

            if (nextCommand1.equalsIgnoreCase("next")) {
                while (true) {
                    System.out.print("\n" + choiceMenu + "\n위 메뉴를 장바구니에 추가하시겠습니까?\n\n(확인: next) (취소: cencle): ");
                    String shoppingBasket = input.nextLine();

                    if (shoppingBasket.trim().isEmpty()) {
                        System.out.println("커멘드를 입력해주세요.");

                        continue;
                    }

                    if (shoppingBasket.equalsIgnoreCase("next")) {
                        shoppingBasketArr.add(thisMenuList.get(menuCommandNumber - 1).getMenuName());
                        shoppingBasketPriceArr.add(thisMenuList.get(menuCommandNumber - 1).getMenuPrice());

                        break;
                    } else if (shoppingBasket.equalsIgnoreCase("cencel")) {
                        break;
                    }

                    break;
                }
            } else if (nextCommand1.equalsIgnoreCase("prev")){
                continue;
            }

            cnt++;
            continue;
        }
    }
}

package Level3;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kiosk {
    private final List<MenuItem> menuItems;

    Kiosk(List<MenuItem> data1) {
        this.menuItems = new ArrayList<>();

        this.menuItems.addAll(data1);
    }

    void start() {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("[ 메뉴판 ]");
            for  (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i).getMenuPrint());
            }

            try {
                System.out.print("\n메뉴 번호를 입력해주세요. \n(종료: 0): ");
                Integer menuNumber = input.nextInt();
                input.nextLine();

                if (menuNumber == 0) {
                    break;
                }

                if (menuNumber < 1 || menuNumber > menuItems.size()) {
                    System.out.println("\n입력하신 번호와 맞는 메뉴가 없습니다.\n");

                    continue;
                }

                System.out.println("\n주문하신 메뉴: " + menuItems.get(menuNumber - 1).getMenuPrint() + "\n");
            } catch (InputMismatchException e) {
                System.out.println("\n숫자만 입력해주세요.\n");
                input.nextLine();

                continue;
            }
        }
    }
}

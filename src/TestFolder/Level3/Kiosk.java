package Level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    List<MenuItem> menuArr;

    Kiosk (List<MenuItem> thisArr) {
        this.menuArr = new ArrayList<>();
        this.menuArr = thisArr;
    }

    void start () {
        Scanner sc = new Scanner(System.in);

        String exit = "";
        while (!exit.equalsIgnoreCase("exit")) {
            System.out.print("메뉴 번호를 입력해주세요 : ");

            if(!sc.hasNextInt()){
                System.out.println("번호 형식이 아닙니다.");
                sc.nextLine();

                continue;
            }

            int menuIndex = sc.nextInt();
            sc.nextLine();

            if(menuIndex <= 0 || menuIndex > menuArr.size()) {
                System.out.println("메뉴판에 존재하지 않는 번호 입니다.");

                continue;
            }
            MenuItem menuItem = menuArr.get(menuIndex - 1);
            menuItem.menuPrint(menuIndex);

            System.out.print("더 주문하시겠습니까?아니라면 엔터를 눌러주세요\n(종료 : exit) : ");
            String exitInput = sc.nextLine();

            if (exitInput.equalsIgnoreCase("exit")) {
                System.out.println("감사합니다 다음에 또 주문해주세요.");

                exit = exitInput;
            } else {
                continue;
            }
        }
    }
}

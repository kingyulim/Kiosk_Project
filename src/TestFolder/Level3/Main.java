package TestFolder.Level3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<MenuItem> menuItems = new ArrayList<>();

        menuItems.add(new MenuItem("알리오 올리오 파스타", 5000, "마늘과 페페론치노를 올리브 오일에 잘 버무린 이탈리아 정통 크리미한 파스타"));
        menuItems.add(new MenuItem("뽀모도로 파스타", 8000, "싱싱한 토마토를 당일날에 수확하여 소스를 만들어 버무린 파스타"));
        menuItems.add(new MenuItem("까르보나라 파스타", 9000, "싱싱한 유정란을 사용하고 관찰레를 사용한 꾸덕꾸덕한 이탈리아 정통 파스타"));
        menuItems.add(new MenuItem("바질페스토 파스타", 7000, "생 바질을 수작업으로 만든 바질페스토를 이용하여 버무린 파스타"));
        menuItems.add(new MenuItem("감자뇨끼", 11000, "수작업으로 작업한 뇨끼를 부드러운 크림을 이용하여 요리 하였습니다"));

        Kiosk kiosk = new Kiosk(menuItems);

        System.out.println("메뉴판");

        for (int a = 0; a < menuItems.size(); a++){
            menuItems.get(a).menuPrint(a + 1);
        }

        System.out.println("\n=============================================\n");

        String systemExit = "";
        while (!systemExit.equalsIgnoreCase("exit")){
            System.out.print("메뉴 주문을 진행하시겠습니까?\n(다음으로 : next) (종료 : exit) : ");
            String startInput = sc.nextLine();

            if (startInput.equalsIgnoreCase("next")){
                kiosk.start();

                break;
            } else if (startInput.equalsIgnoreCase("exit")){
                systemExit = startInput;
            }else if (startInput == null || startInput.trim().isEmpty()){
                System.out.println("입력이 없습니다. 'next' 또는 'exit'을 입력해주세요.");

                continue;
            }
        }

        sc.close();
    }
}

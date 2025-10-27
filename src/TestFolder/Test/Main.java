package TestFolder.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<MenuItem> menuArr = new ArrayList<>();

        menuArr.add(new MenuItem(1, "알리오 올리오 파스타", 5000, "마늘과 페페론치노를 올리브 오일에 잘 버무린 이탈리아 정통 크리미한 파스타"));
        menuArr.add(new MenuItem(2, "뽀모도로 파스타", 8000, "싱싱한 토마토를 당일날에 수확하여 소스를 만들어 버무린 파스타"));
        menuArr.add(new MenuItem(3, "까르보나라 파스타", 9000, "싱싱한 유정란을 사용하고 관찰레를 사용한 꾸덕꾸덕한 이탈리아 정통 파스타"));
        menuArr.add(new MenuItem(4, "바질페스토 파스타", 7000, "생 바질을 수작업으로 만든 바질페스토를 이용하여 버무린 파스타"));
        menuArr.add(new MenuItem(5, "감자뇨끼", 11000, "수작업으로 작업한 뇨끼를 부드러운 크림을 이용하여 요리 하였습니다"));

        System.out.println("[메뉴판]");
        for(int a = 0; a < menuArr.size(); a++){
            MenuItem menuItem = menuArr.get(a);

            menuItem.printMenu();
        }
        System.out.println("==============================================================================");

        /**
         * 주문 실행
         */
        String exit = "";
        while (!exit.equalsIgnoreCase("exit")) {
            System.out.print("==============================================================================\n메뉴 번호를 입력해주세요 : ");
            int menuNum = sc.nextInt();
            sc.nextLine();

            try {
                boolean found = false;

                if (menuArr.size() > menuNum) {
                    MenuItem getMenuItemList = menuArr.get(menuNum);

                    found = true;

                    getMenuItemList.printMenu();
                }

                if(!found){
                    throw new IOException("==============================================================================\n해당 메뉴는 존재하지 않습니다.");
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());

                continue;
            }

            System.out.print("==============================================================================\n더 주문하시겠습니까? 더 주문하시려면 엔터를 눌러주세요\n(종료 커멘드 : exit) : ");
            String exitCommand = sc.nextLine();

            if (exitCommand.equalsIgnoreCase("exit")) {
                exit = exitCommand;

                System.out.println("==============================================================================\n감사합니다 또 이용해주세요.");
            }else{
                continue;
            }
        }

        sc.close();
    }
}

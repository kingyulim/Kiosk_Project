package TestFolder.Level1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] menuNames = {
                "알리오 올리오 파스타",
                "뽀모도로 파스타",
                "까르보나라 파스타",
                "바질페스토 파스타",
                "감자뇨끼"
        };

        List<String> menuSava = new ArrayList<>();

        System.out.println("[메뉴판]");
        System.out.println("1 " + menuNames[0] + " | 5000원 | 마늘과 페페론치노를 올리브 오일에 잘 버무린 이탈리아 정통 크리미한 파스타");
        System.out.println("2 " + menuNames[1] + " | 8000원 | 싱싱한 토마토를 당일날에 수확하여 소스를 만들어 버무린 파스타");
        System.out.println("3 " + menuNames[2] + " | 9000원 | 싱싱한 유정란을 사용하고 관찰레를 사용한 꾸덕꾸덕한 이탈리아 정통 파스타");
        System.out.println("4 " + menuNames[3] + " | 7000원 | 생 바질을 수작업으로 만든 바질페스토를 이용하여 버무린 파스타");
        System.out.println("5 " + menuNames[4] + " | 11000원 | 수작업으로 작업한 뇨끼를 부드러운 크림을 이용하여 요리 하였습니다");
        System.out.println("=======================================================================================");

        String exit = "";
        while (!exit.equalsIgnoreCase("exit")) {
            System.out.print("=======================================================================================\n주문하실 메뉴를 입력해주세요 : ");

            String menuName = sc.nextLine();

            try {
                boolean valid = false;

                for(String menu : menuNames) {
                    if(menuName.equals(menu)) {
                        valid = true;

                        break;
                    }
                }

                if(!valid) {
                    throw new IOException("=======================================================================================\n입력값이 잘못 되었습니다.");
                }

                menuSava.add(menuName);
            } catch(IOException e) {
                System.out.println(e.getMessage());

                continue;
            }

            String menuStringList = "";
            for (int i = 0; i < menuSava.size(); i++) {
                if(i > 0){
                    menuStringList += ", ";
                }

                menuStringList += menuSava.get(i);
            }

            System.out.println("주문 내역 : " + menuStringList);

            System.out.print("=======================================================================================\n더 주문하시겠습니까?\n아니라면 'exit' 를 입력해주세요 : ");
            String exitCommand = sc.nextLine();

            if (exitCommand.equalsIgnoreCase("exit")) {
                exit = exitCommand;

                System.out.println("=======================================================================================\n감사합니다 또 이용해주세요.");
            }else{
                continue;
            }
        }

        sc.close();
    }
}
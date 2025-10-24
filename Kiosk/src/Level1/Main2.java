package Level1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 메뉴 데이터
        String[] menuNames = {
                "알리오 올리오 파스타",
                "뽀모도로 파스타",
                "까르보나라 파스타",
                "바질페스토 파스타",
                "감자뇨끼"
        };

        int[] menuPrices = {5000, 8000, 9000, 7000, 11000};
        String[] menuDescriptions = {
                "마늘과 페페론치노를 올리브 오일에 잘 버무린 파스타",
                "싱싱한 토마토를 당일날 수확하여 소스를 만들어 버무린 파스타",
                "유정란과 관찰레를 사용한 꾸덕한 파스타",
                "생 바질을 수작업으로 만든 바질페스토를 이용",
                "수작업으로 만든 뇨끼를 부드러운 크림으로 요리"
        };

        // 메뉴판 출력
        System.out.println("[메뉴판]");
        for (int i = 0; i < menuNames.length; i++) {
            System.out.println((i + 1) + ". " + menuNames[i] + " | " + menuPrices[i] + "원 | " + menuDescriptions[i]);
        }
        System.out.println("==================================================");

        String exit = "";
        while (!exit.equalsIgnoreCase("exit")) {
            System.out.print("주문하실 메뉴 번호를 입력해주세요 (종료하려면 'exit'): ");
            String input = sc.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                exit = "exit";
                System.out.println("감사합니다. 또 이용해주세요!");
                break;
            }

            try {
                int menuNum = Integer.parseInt(input);

                if (menuNum < 1 || menuNum > menuNames.length) {
                    System.out.println("입력값이 잘못 되었습니다.");
                    continue;
                }

                System.out.println("선택하신 메뉴: " + menuNames[menuNum - 1] + " | " + menuPrices[menuNum - 1] + "원 | " + menuDescriptions[menuNum - 1]);

            } catch (NumberFormatException e) {
                System.out.println("숫자를 입력하거나 'exit'를 입력해주세요.");
            }
        }

        sc.close();

    }
}

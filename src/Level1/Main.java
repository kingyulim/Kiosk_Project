package Level1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<String> menuItems = new ArrayList<>();

        menuItems.add("알리오올리오 | 5000원 | 마늘과 페페론치노를 올리브 오일에 잘 버무린 이탈리아 정통 크리미한 파스타");
        menuItems.add("뽀모도로파스타 | 8000원 | 싱싱한 토마토를 당일날에 수확하여 소스를 만들어 버무린 파스타");
        menuItems.add("까르보나라파스타 | 9000원 | 싱싱한 유정란을 사용하고 관찰레를 사용한 꾸덕꾸덕한 이탈리아 정통 파스타");
        menuItems.add("바질페스토파스타 | 7000원 | 생 바질을 수작업으로 만든 바질페스토를 이용하여 버무린 파스타");
        menuItems.add("감자뇨끼 | 11000원 | 수작업으로 작업한 뇨끼를 부드러운 크림을 이용하여 요리 하였습니다");

        while (true) {
            System.out.println("[ 메뉴판 ]");
            for  (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i));
            }

            try {
                System.out.print("\n메뉴 번호를 입력해주세요: ");
                Integer menuNumber = input.nextInt();
                input.nextLine();

                if(menuNumber < 0 || menuNumber > menuItems.size()) {
                    System.out.println("\n입력하신 번호와 맞는 메뉴가 없습니다.\n");

                    continue;
                }

                System.out.println("\n주문하신 메뉴: " + menuItems.get(menuNumber - 1));

                break;
            } catch (InputMismatchException e) {
                System.out.println("\n숫자만 입력해주세요.\n");
                input.nextLine();

                continue;
            }
        }
    }
}

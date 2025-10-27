package Challenge.Level2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//
public class Kiosk {
    private final List<Menu> menuClassArr;

    Kiosk() {
        this.menuClassArr = new ArrayList<>();

        /**
         * 카테고리 생성
         */
        Menu wineClass = new Menu("wine");
        Menu mainClass = new Menu("main");
        Menu dessertClass = new Menu("dessert");

        /**
         * 와인 메뉴 추가
         */
        wineClass.addMenuItem(new MenuItem("무똥 까데 루즈", 20000, "각종 고기 요리 및 치즈류와 잘 어울리는 대중적인 와인"));
        wineClass.addMenuItem(new MenuItem("이기깔 꼬뜨 뒤 론 루즈", 20000, "해산물요리 가금류 육류 크림파스타와 잘 어울리는 와인"));
        wineClass.addMenuItem(new MenuItem("앙시앙땅 까베르네 쉬라", 30000, "두껍지 않은 스테이크나 로스트 비프 같은 서양식 고기 요리와 잘 어울리는 와인"));
        wineClass.addMenuItem(new MenuItem("루이라뚜르 피노누나", 40000, "육류와 파스타, 피자와 두루두루 잘 어울리는 화이트 와인"));

        /**
         * 메인 메뉴 추가
         */
        mainClass.addMenuItem(new MenuItem("타르티플레트", 18000, "겨울에 알프스 지역에서 먹는 그라탕 추운날 몸을 든든하고 따듯하게 데워주는 프랑스 전통 요리"));
        mainClass.addMenuItem(new MenuItem("뵈포 부르기뇽", 15000, "부르고뉴지방 요리 와인에 소고기를 푹 삶아 걸쭉하고 진한 소스가 인상적인 요리"));
        mainClass.addMenuItem(new MenuItem("꼬꼬뱅", 12000, "와인에 닭을 푹 삶아낸 요리"));
        mainClass.addMenuItem(new MenuItem("키슈 로렌느", 11500, "프랑스 로렌느 지방(알자스쪽)의 전통 요리, 파이에 계란, 크림, 베이컨을 넣어 아주 두툼하고 먹음직스러운 요리"));

        /**
         * 디저트 메뉴 추가
         */
        dessertClass.addMenuItem(new MenuItem("마카롱 5p", 8000, "아몬드 가루와 설탕을 넣은 쿠키에 크림을 넣은 마카롱"));
        dessertClass.addMenuItem(new MenuItem("크림 브륄레", 5000, "차가운 커스터드 크림 위에 설탕을 구워 녹여 깨먹는 재미가 있는 크림 브륄레"));
        dessertClass.addMenuItem(new MenuItem("베이비 슈 2p", 6500, "빠다슈 위에 캐러멜을 입힌 베이비 슈"));
        dessertClass.addMenuItem(new MenuItem("에끌레르 2p", 7000, "빠다슈 일종의 길쭉하고 다양한 맛이 나는 베이비 슈"));

        /**
         * menuClassArr 각각의 객체 add
         */
        this.menuClassArr.add(wineClass);
        this.menuClassArr.add(mainClass);
        this.menuClassArr.add(dessertClass);
    }

    void start (){
        Scanner input = new Scanner(System.in);

        List<Map<String, Object>> basketArr = new ArrayList<>();

        String[] categoryNameArr = {"와인", "메인", "디저트"};

        FIRSTWHILE:
        while (true) {
            System.out.println("\n[ 카테고리 ]");

            for (int a = 0; a < menuClassArr.size(); a++){
                String categoryName = "";

                switch (menuClassArr.get(a).getMenuCategoryName()) {
                    case "wine":
                        categoryName = categoryNameArr[0];

                        break;

                    case "main":
                        categoryName = categoryNameArr[1];

                        break;

                    case "dessert":
                        categoryName = categoryNameArr[2];

                        break;
                }

                System.out.println((a + 1) + ". " + categoryName);
            }

            if (basketArr.size() > 0) {
                System.out.println("\n[ 오더 ]");
                System.out.println("1. 카테고리 번호를 입력해주세요 (커멘드: 메뉴 카테고리 숫자)");
                System.out.println("2. 장바구니 확인 후 주문 (커멘드: check)");
                System.out.println("3. 진행중인 주문을 취소 합니다 (커멘드: cencle)");
                System.out.println("4. 종료 (커멘드: exit)");
                System.out.print("커멘드를 입력해주세요: ");
            } else {
                System.out.print("\n카테고리 번호를 입력해주세요.\n(종료: exit): ");
            }

            String categoryInput = input.nextLine();

            if (categoryInput.equalsIgnoreCase("exit")) {
                System.out.println("\n키오스크를 종료합니다.");

                break;
            } else if (categoryInput.equalsIgnoreCase("check")) {
                Integer totalPrice = 0;

                System.out.println("\n[ 장바구니 ]");
                for (int a = 0; a < basketArr.size(); a++){
                    System.out.println((a + 1) + ". " + basketArr.get(a).get("menuName"));

                    totalPrice = totalPrice + (Integer) basketArr.get(a).get("menuPrice");
                }

                System.out.println("-----------------------");
                System.out.println("총 가격: " + totalPrice + "원");

                System.out.print("\n위와 같이 주문하시겠습니까?\n(확인: clear) (할인: discount) (삭제: delete) (취소: cencel): ");
                String lastOrder = input.nextLine();

                if (lastOrder.equalsIgnoreCase("clear")) {
                    System.out.println("\n주문이 완료되었습니다.");
                    System.out.println("-----------------------");
                    System.out.println("금액: " + totalPrice + "원");

                    break;
                } else if (lastOrder.equalsIgnoreCase("discount")) {
                    System.out.println("\n할인 정보를 입력해주세요.");

                    Discount[] discountsArr = Discount.values();
                    String[] discountsNamesArr = {"국가유공자", "군인", "학생"};

                    for (int i = 0; i < discountsArr.length; i++) {
                        System.out.println((i + 1) + ". " + discountsNamesArr[i] + " " + discountsArr[i].getRate() + "%");
                    }

                    int discountInputNumber = 0;

                    String numdot = IntStream.range(0, discountsArr.length)
                            .mapToObj(i -> String.valueOf(i + 1))
                            .collect(Collectors.joining(", "));

                    while (true) {
                        System.out.print("(할인 번호: " + numdot + ") (취소: cancel): ");
                        String discountInput = input.nextLine();

                        if (discountInput.equalsIgnoreCase("cancel")) {
                            continue FIRSTWHILE;
                        }

                        try {
                            discountInputNumber = Integer.parseInt(discountInput);

                            if (discountInputNumber < 1 || discountInputNumber > discountsArr.length) {
                                System.out.println("\n해당되는 할인 번호가 아닙니다.\n");

                                continue;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("\n숫자만 입력해주세요.\n");

                            continue;
                        }

                        break;
                    }

                    int discountTotalPrice = discountsArr[discountInputNumber - 1].discount(totalPrice);

                    System.out.println("\n주문이 완료되었습니다.");
                    System.out.println("-----------------------");
                    System.out.println("금액: " + discountTotalPrice + "원");

                    break;
                } else if (lastOrder.equalsIgnoreCase("delete")) {
                    String basketDelInput = "";
                    while (true) {
                        System.out.print("\n삭제\n(부분: select) (전체: all): ");
                        basketDelInput = input.nextLine();

                        if (basketDelInput.trim().isEmpty()) {
                            System.out.println("\n커멘드 입력이 되지 않았습니다.\n");

                            continue;
                        }

                        if (!List.of("select", "all").contains(basketDelInput.toLowerCase())) {
                            System.out.println("\n정확한 커멘드를 입력해주세요.");

                            continue;
                        }

                        break;
                    }

                    if(basketDelInput.equalsIgnoreCase("select")){
                        while (true) {
                            try {
                                if (basketArr.size() == 0) {
                                    System.out.println("\n장바구니가 비어있습니다.");

                                    break;
                                }

                                System.out.println("\n[ 장바구니 ]");
                                for (int a = 0; a < basketArr.size(); a++) {
                                    System.out.println((a + 1) + ". " + basketArr.get(a).get("menuName"));
                                }

                                System.out.print("\n삭제할 메뉴 번호를 입력해주세요: ");
                                int selectDelete = input.nextInt();
                                input.nextLine();

                                if (selectDelete <= 0 || selectDelete > basketArr.size()) {
                                    System.out.println("\n입력하신 번호와 맞는 메뉴가 없습니다.");

                                    continue;
                                }

                                basketArr.remove(selectDelete - 1);
                                System.out.println("\n선택한 메뉴가 삭제되었습니다.");

                                continue;
                            } catch (InputMismatchException e) {
                                System.out.println("\n숫자만 입력해주세요.");
                                input.nextLine();

                                continue;
                            }
                        }

                        continue FIRSTWHILE;
                    } else if(basketDelInput.equalsIgnoreCase("all")){
                        System.out.println("\n장바구니 내역이 전체 삭제 되었습니다.\n");

                        basketArr.clear();

                        continue FIRSTWHILE;
                    }
                } else if (lastOrder.equalsIgnoreCase("cencel")) {
                    continue FIRSTWHILE;
                }
            } else if (categoryInput.equalsIgnoreCase("cencel")) {
                System.out.println("\n장바구니 내역이 전체 삭제 되었습니다.\n");

                basketArr.clear();

                continue FIRSTWHILE;
            }

            int categoryChoiceNumber = 0;
            try {
                categoryChoiceNumber = Integer.parseInt(categoryInput);

                if(categoryChoiceNumber < 0 || categoryChoiceNumber > menuClassArr.size()){
                    System.out.println("\n입력하신 번호와 일치하는 카테고리가 없습니다.");

                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("\n숫자와 커멘드만 입력해주세요.");

                continue;
            }

            int thisCategoryChoiceNumber = categoryChoiceNumber - 1;
            int menuChoiceNumber = 0; // 내가 선택 한 메뉴 전역 변수 설정

            List<MenuItem> thisCategoryMenuArr = menuClassArr.get(thisCategoryChoiceNumber).getMenuList(); // 내가 선택한 카테고리 메뉴 배열 반환

            MENULISTWHILE:
            while (true) {
                System.out.println("\n[ " + categoryNameArr[thisCategoryChoiceNumber] + " ]");

                for (int a = 0; a < thisCategoryMenuArr.size(); a++) {
                    System.out.println((a + 1) + ". " + thisCategoryMenuArr.get(a).menuPrint());
                }

                System.out.print("\n메뉴 번호를 입력해주세요.\n(뒤로가기: prev): ");
                String menuInput = input.nextLine();

                if (menuInput.equalsIgnoreCase("prev")) continue FIRSTWHILE;

                try {
                    menuChoiceNumber = Integer.parseInt(menuInput);

                    if (menuChoiceNumber < 0 || menuChoiceNumber > thisCategoryMenuArr.size()) {
                        System.out.println("\n입력하신 번호와 일치하는 메뉴가 없습니다.");

                        continue;
                    }
                } catch (NumberFormatException e){
                    System.out.println("\n숫자만 입력해주세요.");

                    continue;
                }

                System.out.println("\n선택한 메뉴: " + thisCategoryMenuArr.get(menuChoiceNumber - 1).menuPrint() + "\n");

                while (true) {
                    System.out.print("위 메뉴를 장바구니에 추가하시겠습니까?\n(예: yes) (아니오: no) (뒤로가기: prev): ");
                    String basketCommand = input.nextLine();

                    if (basketCommand.trim().isEmpty()) {
                        System.out.println("\n입력값이 비어 있습니다.\n");

                        continue;
                    }

                    if (!List.of("yes", "no", "prev").contains(basketCommand.toLowerCase())) {
                        System.out.println("\n정확한 커멘드를 입력해주세요.\n");

                        continue;
                    }

                    if (List.of("yes", "no").contains(basketCommand.toLowerCase())) {
                        if(basketCommand.equalsIgnoreCase("yes")){
                            Map<String, Object> basketMap = new HashMap<>();

                            String menuName = thisCategoryMenuArr.get(menuChoiceNumber - 1).getMenuname();

                            basketMap.put("menuName", menuName);
                            basketMap.put("menuPrice", thisCategoryMenuArr.get(menuChoiceNumber - 1).getMenuPrice());

                            basketArr.add(basketMap);

                            System.out.println("\n" + menuName + "가 장바구니에 추가 되었습니다\n");
                        }

                        continue FIRSTWHILE;
                    } else if (basketCommand.equalsIgnoreCase("prev")) {
                        continue MENULISTWHILE;
                    }
                }
            }
        }
    }
}

package Level4.Type2;

public class Main {
    public static void main(String[] args) {
        Menu menuCateDrink = new Menu("drink");
        Menu menuCateFood = new Menu("food");
        Menu menuCateDesserts = new Menu("desserts");

        Kiosk kiosk = new Kiosk(
                "와인",
                "음식",
                "디저트",
                menuCateDrink.getMenuArr(),
                menuCateFood.getMenuArr(),
                menuCateDesserts.getMenuArr()
        );

        kiosk.start();
    }
}
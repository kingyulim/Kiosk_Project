package Challenge.Level2;

public enum Discount {
    NATIONALMERIT("10") {
        @Override
        Integer discount(Integer data1){
            Double result = data1 - (data1 * 0.1);

            return result.intValue();
        };
    },
    MILITARY("5") {
        @Override
        Integer discount(Integer data1){
            Double result = data1 - (data1 * 0.05);

            return result.intValue();
        };
    },
    STUDENT("3") {
        @Override
        Integer discount(Integer data1){
            Double result = data1 - (data1 * 0.03);

            return result.intValue();
        };
    };


    private final String rate;

    Discount(String data1) {
        this.rate = data1;
    }

    /**
     * 할인율 추상화 메소드
     * @param data1 전체가격 매게변수
     * @return 할인된 가격으로 반환
     */
    abstract Integer discount(Integer data1);

    /**
     * 선언된 열거형 값 반환 객체
     * @return 선언된 열거형 값 반환
     */
    String getRate() {
        return this.rate;
    }
}

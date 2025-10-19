package calculator.domain;

public class Numbers {
    private static final String ERR_EMPTY = "빈 값은 허용되지 않습니다.";
    private static final String ERR_NOT_NUMBER = "숫자만 입력할 수 있습니다.";
    private static final String ERR_NEGATIVE = "음수는 허용되지 않습니다.";

    private final int[] numbers;

    public Numbers(String regex, String numbersPart) {
        String[] tokens;
        tokens = numbersPart.split(regex);
        numbers = parseAndValidate(tokens);
    }


    private int[] parseAndValidate(String[] tokens) {

        int[] ints = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i].trim();

            if (t.isBlank()) {
                throw new IllegalArgumentException(ERR_EMPTY);
            }

            int value;

            try {
                value = Integer.parseInt(t);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERR_NOT_NUMBER);
            }

            if (value < 0) {
                throw new IllegalArgumentException(ERR_NEGATIVE);
            }
            ints[i] = value;
        }
        return ints;
    }

    public int[] getNumbers() {
        return numbers.clone();
    }
}

package calculator.domain;

public class Numbers {

    private final int[] numbers;

    public Numbers(String rawInput, String separator) {
        String[] tokens;

        if (separator.equals("[,|:]")) {
            tokens = rawInput.split(separator);
        } else {
            int index = rawInput.indexOf("\\n");
            tokens = rawInput.substring(index + 2).split(separator);
        }
        numbers = parseAndValidate(tokens);
    }


    private int[] parseAndValidate(String[] tokens) {

        int[] ints = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];

            if (t.isBlank()) {
                throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
            }

            int value;

            try {
                value = Integer.parseInt(t);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
            }

            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            ints[i] = value;
        }
        return ints;
    }

    public int[] getNumbers() {
        return numbers;
    }
}

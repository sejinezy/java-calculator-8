package calculator.service;

import java.util.regex.Pattern;

public class Separator {

    private static final String DEFAULT_SEPARATOR = "[,:]";

    private Separator() {
    }

    public static Result extract(String rawInput) {

        if (rawInput.startsWith("//")
                && rawInput.indexOf("\\n") == 3) {

            char delim = rawInput.charAt(2);
            validate(delim);

            String regex = Pattern.quote(String.valueOf(delim));

            int index = rawInput.indexOf("\\n");
            String numbersPart = rawInput.substring(index + 2);

            return new Result(regex, numbersPart);
        }
        return new Result(DEFAULT_SEPARATOR,rawInput);
    }

    private static void validate(char delim) {
        if (Character.isDigit(delim)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }

    public record Result(String regex, String numbersPart) {
    }

}

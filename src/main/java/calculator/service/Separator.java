package calculator.service;

import calculator.dto.RequestDto;
import java.util.regex.Pattern;

public class Separator {

    private String separator;

    public Separator() {
        separator = "[,|:]";
    }

    public void extract(RequestDto requestDto) {
        String rawInput = requestDto.getRawInput();

        if (rawInput.startsWith("//")
                && rawInput.indexOf("\\n") == 3) {

            char delim = rawInput.charAt(2);
            validate(delim);

            separator = Pattern.quote(String.valueOf(delim));
        }
    }

    private static void validate(char delim) {
        if (Character.isDigit(delim)) {
            throw new IllegalArgumentException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }

    public String getSeparator() {
        return separator;
    }


}

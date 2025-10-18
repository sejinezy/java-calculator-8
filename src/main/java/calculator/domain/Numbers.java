package calculator.domain;

import calculator.dto.RequestDto;
import calculator.service.Separator;

public class Numbers {

    private String[] numbers;


    public void extract(RequestDto requestDto, Separator separator) {
        String rawInput = requestDto.getRawInput();
        String sep = separator.getSeparator();

        String[] strings;
        if (sep.equals("[,|:]")) {
            strings = rawInput.split(sep);
        } else {
            strings = rawInput.substring(5).split(sep);
        }

        validate(strings);

        numbers = strings;
    }

    private void validate(String[] strings) {

        for (String s : strings) {
            if (s.isBlank()) {
                throw new IllegalArgumentException("빈 값은 허용되지 않습니다.");
            }

            int value;

            try {
                value = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
            }

            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
        }
    }

    public String[] getNumbers() {
        return numbers;
    }
}

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
            if (Integer.parseInt(s) < 0) {
                throw new IllegalArgumentException();
            }
        }
    }

    public String[] getNumbers() {
        return numbers;
    }
}

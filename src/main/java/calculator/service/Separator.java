package calculator.service;

import calculator.dto.RequestDto;

public class Separator {

    private String separator;

    public void extract(RequestDto requestDto) {
        if (requestDto.getRawInput().charAt(0) == '/' && requestDto.getRawInput().charAt(1) == '/'
                && requestDto.getRawInput().charAt(3) == '\\' && requestDto.getRawInput().charAt(4) == 'n') {

            validate(requestDto);
            separator = String.valueOf(requestDto.getRawInput().charAt(2));
        }
        else {
            separator = "[,|:]";
        }
    }

    private static void validate(RequestDto requestDto) {
        if (Character.isDigit(requestDto.getRawInput().charAt(2))) {
            throw new IllegalStateException("커스텀 구분자는 숫자가 될 수 없습니다.");
        }
    }

    public String getSeparator() {
        return separator;
    }


}

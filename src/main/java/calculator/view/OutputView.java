package calculator.view;

import calculator.dto.ResponseDto;

public final class OutputView {

    private static final String RESULT_PREFIX = "결과 : ";

    public static void print(ResponseDto responseDto) {
        System.out.print(RESULT_PREFIX);
        System.out.println(responseDto.getSum());
    }
}

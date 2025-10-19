package calculator.view;

import calculator.dto.ResponseDto;

public final class ConsoleOutputView implements OutputView {

    private static final String RESULT_PREFIX = "결과 : ";

    @Override
    public void print(ResponseDto responseDto) {
        System.out.print(RESULT_PREFIX);
        System.out.println(responseDto.getSum());
    }
}

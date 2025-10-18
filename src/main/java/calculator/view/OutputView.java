package calculator.view;

import calculator.dto.ResponseDto;

public class OutputView {

    public static void print(ResponseDto responseDto) {
        System.out.print("결과 : ");
        System.out.println(responseDto.getSum());
    }
}

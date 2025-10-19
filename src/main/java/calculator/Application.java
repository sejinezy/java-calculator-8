package calculator;

import calculator.service.Separator;
import calculator.service.Separator.Result;
import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.domain.Numbers;
import calculator.dto.RequestDto;
import calculator.dto.ResponseDto;
import calculator.service.Adder;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView.guide();
        String rawInput = Console.readLine();
        RequestDto requestDto = new RequestDto(rawInput);

        Result result = Separator.extract(requestDto.getRawInput());

        Numbers numbers = new Numbers(result.regex(), result.numbersPart());

        ResponseDto responseDto = Adder.add(numbers);
        OutputView.print(responseDto);

    }

}

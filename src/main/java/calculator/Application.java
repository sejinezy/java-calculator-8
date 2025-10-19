package calculator;

import calculator.boundary.InputNormalizer;
import calculator.service.Separator;
import calculator.service.Separator.Result;
import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.domain.Numbers;
import calculator.dto.RequestDto;
import calculator.dto.ResponseDto;
import calculator.service.Adder;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String rawInput = InputView.readLine();
        String normalized = InputNormalizer.normalizeBlankToZero(rawInput);
        RequestDto requestDto = new RequestDto(normalized);

        Result result = Separator.extract(requestDto.getRawInput());

        Numbers numbers = new Numbers(result.regex(), result.numbersPart());

        ResponseDto responseDto = Adder.add(numbers);
        OutputView.print(responseDto);

    }

}

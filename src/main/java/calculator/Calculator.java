package calculator;

import calculator.boundary.InputNormalizer;
import calculator.domain.Numbers;
import calculator.dto.RequestDto;
import calculator.dto.ResponseDto;
import calculator.service.Adder;
import calculator.service.DefaultSeparator.Result;
import calculator.service.Separator;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Calculator {

    private final InputView inputView;
    private final Separator separator;
    private final Adder adder;
    private final OutputView outputView;

    public Calculator(InputView inputView, Separator separator, Adder adder, OutputView outputView) {
        this.inputView = inputView;
        this.separator = separator;
        this.adder = adder;
        this.outputView = outputView;
    }

    public void run() {
        String rawInput = inputView.readLine();
        String normalized = InputNormalizer.normalizeBlankToZero(rawInput);
        RequestDto requestDto = new RequestDto(normalized);

        Result result = separator.extract(requestDto.getRawInput());
        Numbers numbers = new Numbers(result.regex(), result.numbersPart());

        ResponseDto responseDto = adder.add(numbers);
        outputView.print(responseDto);
    }
}

package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;
import calculator.domain.Numbers;
import calculator.dto.RequestDto;
import calculator.dto.ResponseDto;
import calculator.service.Adder;
import calculator.service.Separator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView.guide();
        String rawInput = Console.readLine();
        RequestDto requestDto = new RequestDto(rawInput);

        Separator separator = new Separator();
        separator.extract(requestDto);

        Numbers numbers = new Numbers();
        numbers.extract(requestDto, separator);

        ResponseDto responseDto = Adder.add(numbers);
        OutputView.print(responseDto);



    }

}

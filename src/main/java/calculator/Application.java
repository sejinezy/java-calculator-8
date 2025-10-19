package calculator;

import calculator.service.Adder;
import calculator.service.DefaultSeparator;
import calculator.service.Separator;
import calculator.view.ConsoleInputView;
import calculator.view.ConsoleOutputView;
import calculator.service.PositiveAdder;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputView inputView = new ConsoleInputView();
        Separator separator = new DefaultSeparator();
        Adder adder = new PositiveAdder();
        OutputView outputView = new ConsoleOutputView();

        Calculator calculator = new Calculator(inputView, separator, adder, outputView);
        calculator.run();

    }

}

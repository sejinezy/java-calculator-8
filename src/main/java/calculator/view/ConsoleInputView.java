package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public final class ConsoleInputView implements InputView {

    private static final String GUIDE = "덧셈할 문자열을 입력해 주세요.";

    @Override
    public String readLine() {
        System.out.println(GUIDE);
        return Console.readLine();
    }
}

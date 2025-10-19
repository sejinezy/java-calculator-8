package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public final class InputView {

    private static final String GUIDE = "덧셈할 문자열을 입력해 주세요.";

    public static String readLine() {
        System.out.println(GUIDE);
        return Console.readLine();
    }
}

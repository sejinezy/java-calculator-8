package calculator.service;

import java.util.regex.Pattern;

public class DefaultSeparator implements Separator {
    private static final String ERR_INVALID_CUSTOM_FORMAT = "커스텀 구분자 형식이 틀렸습니다.";
    private static final String ERR_CUSTOM_TOO_LONG = "커스텀 구분자는 문자 1개여야합니다.";
    private static final String ERR_CUSTOM_DIGIT = "커스텀 구분자는 숫자가 될 수 없습니다.";

    private static final String DEFAULT_SEPARATOR = "[,:]";
    private static final String CUSTOM_PREFIX_HEADER = "//";
    private static final String CUSTOM_END_HEADER = "\\n";

    @Override
    public Result extract(String rawInput) {
        if (isCustom(rawInput)) {

            char delim = rawInput.charAt(2);
            validate(delim);

            String regex = Pattern.quote(String.valueOf(delim));

            int index = rawInput.indexOf("\\n");
            String numbersPart = rawInput.substring(index + 2);

            return new Result(regex, numbersPart);
        }
        return new Result(DEFAULT_SEPARATOR,rawInput);
    }

    private boolean isCustom(String rawInput) {

        if (rawInput.startsWith(CUSTOM_PREFIX_HEADER)) {
            int customPrefixHeaderIndex = rawInput.indexOf(CUSTOM_END_HEADER);

            if (customPrefixHeaderIndex == 3) {
                return true;
            }

            if (customPrefixHeaderIndex == -1) {
                throw new IllegalArgumentException(ERR_INVALID_CUSTOM_FORMAT);
            }

            if (customPrefixHeaderIndex > 3) {
                throw new IllegalArgumentException(ERR_CUSTOM_TOO_LONG);
            }
        }
        return false;
    }

    private void validate(char delim) {
        if (Character.isDigit(delim)) {
            throw new IllegalArgumentException(ERR_CUSTOM_DIGIT);
        }
    }

    public record Result(String regex, String numbersPart) {
    }

}

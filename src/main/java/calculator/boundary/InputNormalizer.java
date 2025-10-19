package calculator.boundary;

public final class InputNormalizer {

    private InputNormalizer() {
    }

    public static String normalizeBlankToZero(String rawInput) {
        if (rawInput.isBlank()) {
            return "0";
        }
        return rawInput;
    }


}

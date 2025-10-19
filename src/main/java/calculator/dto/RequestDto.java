package calculator.dto;

public class RequestDto {

    private final String rawInput;

    public RequestDto(String rawInput) {
        this.rawInput = rawInput;
    }

    public String getRawInput() {
        return rawInput;
    }

}

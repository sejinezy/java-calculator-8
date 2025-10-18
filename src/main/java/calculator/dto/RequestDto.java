package calculator.dto;

public class RequestDto {

    private String rawInput;

    public RequestDto(String rawInput) {
        if (rawInput.isBlank()) {
            this.rawInput = "0";
        } else {
            this.rawInput = rawInput;
        }
    }

    public String getRawInput() {
        return rawInput;
    }




}

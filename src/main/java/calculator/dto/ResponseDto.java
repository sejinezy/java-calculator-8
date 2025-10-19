package calculator.dto;

public class ResponseDto {

    private final int sum;

    public ResponseDto(int sum) {
        this.sum = sum;
    }

    public int getSum() {
        return sum;
    }
}

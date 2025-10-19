package calculator.service;

import calculator.domain.Numbers;
import calculator.dto.ResponseDto;

public interface Adder {

    public ResponseDto add(Numbers numbers);
}

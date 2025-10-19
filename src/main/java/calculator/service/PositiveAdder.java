package calculator.service;

import calculator.domain.Numbers;
import calculator.dto.ResponseDto;

public class PositiveAdder implements Adder {

    @Override
    public ResponseDto add(Numbers numbers) {
        int[] nums = numbers.getNumbers();

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return new ResponseDto(sum);
    }

}

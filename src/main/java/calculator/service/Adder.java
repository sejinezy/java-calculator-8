package calculator.service;

import calculator.domain.Numbers;
import calculator.dto.ResponseDto;

public class Adder {


    public static ResponseDto add(Numbers numbers) {
        int[] nums = numbers.getNumbers();

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return new ResponseDto(sum);
    }

}

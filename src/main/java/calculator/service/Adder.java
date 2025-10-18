package calculator.service;

import calculator.domain.Numbers;
import calculator.dto.ResponseDto;

public class Adder {


    public static ResponseDto add(Numbers numbers) {
        String[] nums = numbers.getNumbers();

        int sum = 0;
        for (String num : nums) {
            sum += Integer.parseInt(num);
        }

        return new ResponseDto(sum);
    }

}

package calculator.service;

import calculator.domain.Numbers;

public class PositiveAdder implements Adder {

    @Override
    public int add(Numbers numbers) {
        int[] nums = numbers.getNumbers();

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        return sum;
    }

}

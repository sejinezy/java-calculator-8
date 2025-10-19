package calculator.service;


import calculator.service.DefaultSeparator.Result;

public interface Separator {

    Result extract(String input);
}

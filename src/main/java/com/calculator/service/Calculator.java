package com.calculator.service;

import java.util.List;
import com.calculator.service.impl.CalcItem;


public interface Calculator {
    Double calculate(List<CalcItem> items);
}

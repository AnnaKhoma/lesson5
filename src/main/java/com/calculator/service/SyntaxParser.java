package com.calculator.service;

import java.util.List;
import com.calculator.service.impl.CalcItem;

public interface SyntaxParser {
    List<CalcItem> parse(String expression);
}

package com.calculator.service.impl;

import com.calculator.service.Calculator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Stack;


@Service
public class CalculatorImpl implements Calculator {
    @Override
    public Double calculate(List<CalcItem> items) {
		Stack<Operand> operands = new Stack<>();
        for (int i = 0; i <items.size(); i++) {
            if(items.get(i) instanceof Operand){
                operands.push((Operand) items.get(i));
            }
            else if (items.get(i) instanceof Operator){
                operands.push(((Operator)items.get(i)).calc(operands.pop(),operands.pop()));
            }
        }
        return operands.pop().getValue();
        //return 1d;
    }
}

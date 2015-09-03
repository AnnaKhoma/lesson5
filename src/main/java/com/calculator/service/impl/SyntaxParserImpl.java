package com.calculator.service.impl;

import com.calculator.service.SyntaxParser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


@Service
public class SyntaxParserImpl implements SyntaxParser {
    public static final char POINT = '.';
    public static final char OPEN_BRACKET = '(';
    public static final char CLOSE_BRACKET = ')';

    List<CalcItem> calcItem = new ArrayList<CalcItem>();
    private Stack<Character> stack = new Stack<Character>();
	
	@Override
    public List<CalcItem> parse(String expression) {
        String number = "";
        String var = "";
        char [] symbols = expression.toCharArray();
        for (int i = 0; i < symbols.length ; i++) {
            if(Character.isWhitespace(symbols[i]))
                continue;
            if(Character.isDigit(symbols[i]) || symbols[i] == POINT){
                number += symbols[i];
                if (i+1<symbols.length && (Character.isDigit(symbols[i+1]) ||symbols[i+1] == POINT))
                    continue;
                calcItem.add(new Number(number));
                number = "";
            }
            else if(symbols[i] == OPEN_BRACKET){
                stack.push(symbols[i]);
            }
            else if (symbols[i] == CLOSE_BRACKET) {
                while(!stack.empty()&& stack.peek()!= OPEN_BRACKET) {
                    calcItem.add(Operator.selectOperator(stack.pop()));
                }
                if(!stack.empty())
                    stack.pop();
            }
            else{
                while (!stack.empty()&& Operator.priority(symbols[i])<Operator.priority(stack.peek())) {
                    calcItem.add(Operator.selectOperator(stack.pop()));
                }
                stack.push(symbols[i]);
            }
        }
        while (!stack.empty()){
                calcItem.add(Operator.selectOperator(stack.pop()));
        }
        return calcItem;
    }
}

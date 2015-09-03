package com.calculator.service.impl;

import com.calculator.service.SyntaxAnalyzer;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SyntaxAnalyzerImpl implements SyntaxAnalyzer {
	private static final String SIMPLE_EXPRESSION = "^(\\(*(\\d+(\\.\\d+)?){1}\\)* ?(\\+|\\-|\\*|\\/){1} ?)*\\(*(\\d+(\\.\\d+)?){1}\\)*$";
    private static final char OPEN_BRACKET = '(';
    private static final char CLOSE_BRACKET = ')';

   @Override
    public void analyzeSyntax(String expression) throws IllegalSymbolException, SyntaxException, UncoordinatedBracketsException{
		if (!expression.matches("^[\\d\\+\\-\\*\\/\\(\\)\\.]*$")){
            throw new IllegalSymbolException();
        }
		if(!isCoordinateBrackets(expression)){
			throw new UncoordinatedBracketsException();
		}
        if(!expression.matches(SIMPLE_EXPRESSION)){
           throw new SyntaxException();
        }
		
    }
	
	private static boolean isCoordinateBrackets(String string){
		int countOpenBrackets = 0;
		int countCloseBrackets = 0;
		for (int i= 0; i<string.length(); i++){
			if(string.charAt(i) == OPEN_BRACKET){
				countOpenBrackets++;
			}
			if (string.charAt(i) == CLOSE_BRACKET){
				countCloseBrackets++;	
			}
		}
		if(countOpenBrackets==countCloseBrackets){
			return true;
		}
		return false;		
	}
}

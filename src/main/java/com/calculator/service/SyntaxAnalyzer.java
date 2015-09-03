package com.calculator.service;

import com.calculator.service.impl.IllegalSymbolException;
import com.calculator.service.impl.SyntaxException;
import com.calculator.service.impl.UncoordinatedBracketsException;


public interface SyntaxAnalyzer {
    void analyzeSyntax(String expression)throws IllegalSymbolException, SyntaxException, UncoordinatedBracketsException;
}

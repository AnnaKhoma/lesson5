package com.calculator.mvc;

import com.calculator.service.Calculator;
import com.calculator.service.SyntaxAnalyzer;
import com.calculator.service.SyntaxParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.calculator.service.impl.IllegalSymbolException;
import com.calculator.service.impl.SyntaxException;
import com.calculator.service.impl.UncoordinatedBracketsException;


/**
 * Created by gleb on 8/31/15.
 */
@Controller
@RequestMapping("/")
public class CalculatorController {

    @Autowired
    private Calculator calculator;

    @Autowired
    private SyntaxAnalyzer syntaxAnalyzer;

    @Autowired
    private SyntaxParser syntaxParser;

    private final static String HOME_VIEW = "index";

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return HOME_VIEW;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String calculateExpression(@RequestParam("expression") String expression, ModelMap model)throws IllegalSymbolException, SyntaxException, UncoordinatedBracketsException{
        syntaxAnalyzer.analyzeSyntax(expression);
        model.addAttribute("result", calculator.calculate(syntaxParser.parse(expression)));
        return HOME_VIEW;
    }
}

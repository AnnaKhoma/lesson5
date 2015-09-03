package com.calculator.service.impl;

public final class Multiplication extends Operator{
    final static int PRIORITY = 2;
    final static char MULT = '*';

    @Override
    protected boolean isOperator (String sOperator){
        return sOperator.matches("[\\*]");
    }

    @Override
    protected int getPriority(){ return PRIORITY; };


    @Override
    public Operand calc (Operand op2, Operand op1){ return new Number(op1.getValue() * op2.getValue()); }

    @Override
    public String toString(){
        return Character.toString(MULT);
    }

}

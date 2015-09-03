package com.calculator.service.impl;

 public abstract class Operator implements CalcItem {
    private static Operator [] allOperators = {new Plus(),new Minus(),new Multiplication(),new Division()};


    protected abstract boolean isOperator(String sOperator);
    protected abstract int getPriority();
    public abstract Operand calc(Operand op2, Operand op1);

    protected static Operator selectOperator (char operator){
        for (Operator op : allOperators){
            if (op.isOperator(Character.toString(operator))){
                return op;
            }
        }
        return null;
    }
    
    protected static int priority(char operator){
        return Operator.selectOperator(operator)!=null ? Operator.selectOperator(operator).getPriority() : 0;
    }


    @Override
    public String toString(){
        return "null";
    }
}


package com.calculator.service.impl;

public abstract class Operand implements CalcItem {

    public abstract double getValue();
    public abstract void  setValue(double value);

}

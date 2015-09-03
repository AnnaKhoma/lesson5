package com.calculator.service.impl;

class Number extends Operand{
    private double value;

    public Number(String string) {
        value = Double.parseDouble(string);
    }

    public Number(double value ) { this.value = value; }

    @Override
    public String toString(){
        return Double.toString(value);
    }

    @Override
    public double getValue(){ return value; }

    @Override
    public void setValue(double value) { this.value = value; }
}


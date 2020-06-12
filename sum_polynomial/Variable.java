package com.company;

public class Variable extends Node {
    String name;
    Double value;

    Variable(String name){
        this.name = name;
        this.value = 0.0;
    }

    void setValue(double d){
        value = d;
    }


    @Override
    double evaluate() {
        return sign*value;
    }


    @Override
    public String toString() {
        String sgn=sign<0?"-":"";
        return sgn+name;
    }
}

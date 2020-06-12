package com.company;

public class Main {
    static void buildAndPrint(){
        Variable x = new Variable("x");
        Node exp = new Sum()
                .add(2.1,new Power(x,3))//ok
                .add(new Power(x,2))//ok
                .add(-2,x)
                .add(7);//ok
        System.out.println(exp.toString());

    }

    public static void main(String[] args) {
	buildAndPrint();
    }
}

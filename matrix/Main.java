package com.company;

import java.lang.reflect.Array;

public class Main {

    public static void main(String[] args)
    {
	    double[][] tab = {{4,4,4},{4,4,4}};
	    double[][] tab1 = {{1,1,1,1,1,1},{1,1,1,1,1,1},{1,1,1,1,1,1}};

	    Matrix mat = new Matrix(tab);

	    System.out.print(mat.frobenius());
    }
}

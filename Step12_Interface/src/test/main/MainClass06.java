package test.main;

import test.mypac.Calculator;

public class MainClass06 {
	public static void main(String[] args) {
		Calculator add=(double a, double b)->{ return a+b; };
		// 위를 간략하게 하면 이렇게 된다.
		Calculator add2=(a, b)->a+b;
		Calculator sub=(a, b)->a-b;
		Calculator multi=(a, b)->a*b;
		Calculator divide=(a, b)->a/b;
		
		useCalculator(add);
		useCalculator(add2);
		useCalculator(sub);
		useCalculator(multi);
		useCalculator(divide);
		useCalculator((a, b)->a/b);
	}
	
	public static void useCalculator(Calculator cal) {
		double result=cal.exec(10, 20);
		System.out.println("result : "+result);
	}
}

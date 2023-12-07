// VIEW THE FILE NAMED "POLYNOMIAL" FOR THE CLASS CODE
// homework 4 program 1: implement polynomial class - 11/17/23
import java.util.*;

class HW4_P1_PolynomialMain {
  public static void main(String[] args) {
    ArrayList<Integer> coefficients = new ArrayList<Integer>();
    	coefficients.add(1);
    	coefficients.add(2);
    	coefficients.add(4);
    
    System.out.println("--------+----------------------------");
    
    Polynomial p1 = new Polynomial(coefficients);
    System.out.println("P1      | " + p1);
    System.out.println("x = 1   | " + p1.getValue(1));
    
    System.out.println("--------+----------------------------");
    
    Polynomial p2 = new Polynomial(coefficients);
    System.out.println("P2:     | " + p1);
    System.out.println("x = 1   | " + p2.getValue(1));
    
    System.out.println("--------+----------------------------");
    
    Polynomial pSum = p1.add(p2);
    System.out.println("P1 + P2 | " + pSum);
	System.out.println("x = 1   | " + pSum.getValue(1));
    
    System.out.println("--------+----------------------------");
    
    Polynomial pProduct = p1.multiply(p2);
    System.out.println("P1 * P2 | " + pProduct);
	System.out.println("x = 1   | " + pProduct.getValue(1));
    
    System.out.println("--------+----------------------------");
  }
}
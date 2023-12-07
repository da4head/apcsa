// VIEW THE FILE NAMED "POLYNOMIAL" FOR THE CLASS CODE
// VIEW THE FILE NAMED "POLYNOMIALDERIVATIVE" FOR THE CLASS CODE
// homework 4 program 2: implement polynomial derivitive class - 11/17/23
import java.util.*;

class HW4_P2_PolynomialDerivativeMain {
  public static void main(String[] args) {
    
    ArrayList<Integer> coefficients = new ArrayList<Integer>();
    	coefficients.add(1);
    	coefficients.add(2);
    	coefficients.add(4);
    	coefficients.add(8);
    
    System.out.println("--------+-------------------");
    
    Polynomial p = new Polynomial(coefficients);
    System.out.println("original| " + p);
    
    System.out.println("--------+-------------------");
    
    Polynomial pDerivative = PolynomialDerivative.derivative(p);
    System.out.println("derived | " + pDerivative);
    
    System.out.println("--------+-------------------");
  }
  
  
}
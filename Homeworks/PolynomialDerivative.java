import java.util.*;

public class PolynomialDerivative {
  public static Polynomial derivative(Polynomial p) {
    int length = p.getCoefficients().size();
    
    // initialize the array list
    ArrayList<Integer> coefficients = new ArrayList<Integer>();
    for (int i = 0; i < length - 1; i++) {
      coefficients.add(0);
    }  
    
    for (int i = 1; i < length; i++) {
      int currentCoefficient = p.getCoefficients().get(i);
      if (currentCoefficient != 0) coefficients.set(i - 1, currentCoefficient * i);
    }
    
    return new Polynomial(coefficients);
  }
}
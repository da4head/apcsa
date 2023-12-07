import java.util.*;
import java.math.BigDecimal;

public class Polynomial {
  private ArrayList<Integer> coefficients = new ArrayList<Integer>();
  
  Polynomial(ArrayList<Integer> coefficients) {
    for (int i = 0; i < coefficients.size(); i++) {
      this.coefficients.add(coefficients.get(i));
    }
  }
  
  public ArrayList<Integer> getCoefficients() {
    return this.coefficients;
  }
  
  public BigDecimal getValue(double x) {
    BigDecimal sum = new BigDecimal("0");
    
    for (int i = 0; i < this.getCoefficients().size(); i++) { // for each coefficient
      BigDecimal coefficient = new BigDecimal(String.valueOf(this.getCoefficients().get(i)));
      BigDecimal exponent = new BigDecimal(String.valueOf(x));
      exponent = exponent.pow(i);
      
      BigDecimal subSum = coefficient.multiply(exponent);
      sum = sum.add(subSum);
    }
    
    return sum;
  }
  
  public Polynomial add(Polynomial that) {
    int lengthThis = this.getCoefficients().size();
    int lengthThat = that.getCoefficients().size();
    int length = lengthThis > lengthThat ? lengthThis : lengthThat;
    ArrayList<Integer> coefficients = new ArrayList<Integer>();  
    
    for (int i = 0; i < length; i++) {
      if (i >= lengthThis) {
        coefficients.add(that.getCoefficients().get(i));
      } else if (i >= lengthThat) {
        coefficients.add(this.getCoefficients().get(i));
      } else {
        coefficients.add(this.getCoefficients().get(i) + that.getCoefficients().get(i));
      }
    }
    
    return new Polynomial(coefficients);
  }
  
  public Polynomial multiply(Polynomial that) {
    int lengthThis = this.getCoefficients().size();
    int lengthThat = that.getCoefficients().size();
    ArrayList<Integer> coefficients = new ArrayList<Integer>(); 
    
    // initialize the array list
    for (int i = 0; i < lengthThis + lengthThat - 1; i++) {
      coefficients.add(0);
    }    
    
    for (int iThis = 0; iThis < lengthThis; iThis++) {
      for (int iThat = 0; iThat < lengthThat; iThat++) {
        if (coefficients.get(iThis + iThat) == 0) {
          coefficients.set(iThis + iThat, this.getCoefficients().get(iThis) * that.getCoefficients().get(iThat));
        } else {
          coefficients.set(iThis + iThat, coefficients.get(iThis + iThat) + this.getCoefficients().get(iThis) * that.getCoefficients().get(iThat));
        }
      }
    }
    return new Polynomial(coefficients);
  }
  
  @Override
  public boolean equals(Object o) {
    if (o instanceof Polynomial) {
      return this.getCoefficients().equals(((Polynomial) o).getCoefficients());
    }
    return false;
  }
  
  @Override
  public String toString() {
    String output = "";
    int lastIndx = this.getCoefficients().size() - 1;
    
    for (int i = lastIndx; i >= 0; i--) {
      int currentCoefficient = this.getCoefficients().get(i);
      
      if (currentCoefficient != 0) {
        if (i != lastIndx) {
          output += " + ";
        }

        output += String.valueOf(currentCoefficient);

        if (i != 0) {
          output += "x";
          if (i != 1) {
            output += AlexPackage.toSuperscript(i);
          }
        }
      }
    }
    return output;
  }
}
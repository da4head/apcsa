package Lab;

// lab 3: print out n prime numbers - 9/27/23
import java.util.Scanner;

class Lab3_Prime {
  
  static Scanner s = new Scanner(System.in);
  static int NUMOFPRIMES;
  
  public static void main(String[] args) {
    
    System.out.println("I can output as many prime numbers as you want!");
    NUMOFPRIMES = setValidateNumber();
    
    int[] primes = new int[NUMOFPRIMES];
    int currentPrimeIndex = 0;
    int currentPrimeCandidate = 1;
    
    // build the array by iterating two variables
    while (true) {
      if (currentPrimeIndex == NUMOFPRIMES) break;
      
      do {
        currentPrimeCandidate++;
      }
      while (!isPrime(currentPrimeCandidate, primes, currentPrimeIndex));
      
      primes[currentPrimeIndex] = currentPrimeCandidate;
      currentPrimeIndex++;
    }
    
    // print the array
    printArray(primes);
    
  }
  
  static int setValidateNumber() {
    int num = 0;
    boolean numIsInt = false;
    
    System.out.print("Please enter a positive integer: ");
    
    while (!numIsInt) {
      try {
        num = Integer.parseInt(s.nextLine());
        if (num < 0) {
          throw new Exception("That is not a positive integer. Please enter a positive integer: ");
        }
		numIsInt = true;
      } catch (Exception e) {
        System.out.print("That is not a positive integer. Please enter a positive integer: ");
      } 
    }
    
    return num;
  }
  
  static boolean isPrime(int candidate, int[] primes, int currentPrimeIndex) {
    for (int i = 0; i < currentPrimeIndex; i++) {
      if (candidate % primes[i] == 0) {
        return false;
      }
    }
    return true;
  }
  
  static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.printf("%d, %d%n", i + 1, arr[i]);
    }
  }
  
}
// lab 1: divisible by 345 - 9/15/23
import java.util.Scanner;

class Lab1_Divisibility {
  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);
    
   	System.out.println("enter a number:");
    int x = s.nextInt();
    
    if (x % 5 == 0) {
      if ((x % 3 == 0) && (x % 4 == 0)) {
        System.out.println("the number " + x + " is divisible by 3, 4, and 5.");
      } else if (x % 3 == 0) {
        System.out.println("the number " + x + " is divisible by 3 and 5.");
      } else if (x % 4 == 0) {
        System.out.println("the number " + x + " is divisible by 4 and 5.");
      } else {
        System.out.println("the number " + x + " is divisible by 5.");
      }
    } else {
      if ((x % 3 == 0) && (x % 4 == 0)) {
        System.out.println("the number " + x + " is divisible by 3 and 4.");
      } else if (x % 3 == 0) {
        System.out.println("the number " + x + " is divisible by 3.");
      } else if (x % 4 == 0) {
        System.out.println("the number " + x + " is divisible by 4.");
      } else {
        System.out.println("the number " + x + " is not divisible by 3, 4, and 5.");
      }
    }
    
  }
}
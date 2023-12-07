// hw 1 program 1: reversing a string - 9/28/23
// there has to be a better way to do this...
import java.util.Scanner;

class HW2_P1_ReverseString {
  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);
    
    System.out.println("Enter some text for me to reverse: ");
    String text = s.nextLine();
    
    System.out.println("The reversed text is: ");
    printInReverse(text);
    
  }
  
  static void printInReverse(String text) {
    
    for (int i = text.length() - 1; i >= 0; i--) {
      System.out.print(text.charAt(i));
    }
    
  }
  
}
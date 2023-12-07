// hw 1 program 2: reversing a integer - 9/28/23
// there has to be a better way to do this...
import java.util.Scanner;

class HW2_P2_ReverseInt {
  
  static Scanner s = new Scanner(System.in);
  
  public static void main(String[] args) {
    
    int number = setValidateNumber();
    
    System.out.print("The reversed int is: ");
    System.out.print(reverse(number));
    
  }
  
  static int reverse(int num) {
	
    int oldNum = num;
    int newNum = 0;
    
    // this will output 4320 from 1234...
    while ( !(oldNum < 10) ) {
      newNum += oldNum % 10;
      newNum *= 10;
      oldNum /= 10;
    }
    // ..and this will bring to output to 4321
    newNum += oldNum;
    
    return newNum;
    
  }
  
  static int setValidateNumber() {
    
    int num = -1;
    boolean numIsValid = false;
    
    System.out.print("Please enter a positive integer: ");
    
    while (!numIsValid) {
      try {
        num = Integer.parseInt(s.nextLine());
        if (num < 0) {
          throw new Exception("That is not a positive integer. Please enter a positive integer: ");
        }
		numIsValid = true;
      } catch (Exception e) {
        System.out.print("That is not a positive integer. Please enter a positive integer: ");
      } 
    }
    
    return num;
    
  }
  
}
// homework 3 program 2: convert between different number systems - 10/8/23
import java.util.*;

class HW3_P2_NumSystemConversion {
  
  static Scanner s = new Scanner(System.in);
  
  public static void main(String[] args) {
    System.out.println("Lets convert numbers between different number systems!");
    System.out.println("\nWhat is your starting number system?");
    String startNumSystem = getNumSystem();
    
    System.out.println("\nWhat number do you want to convert?");
    String input = getValidInput(startNumSystem);
    
    System.out.println("\nWhat is your ending number system?");
    String endNumSystem = getNumSystem();
    
    String output = decimalTo(toDecimal(input, startNumSystem), endNumSystem); // this looks convoluted af... uh... dw about it
    System.out.printf("%n%s in %s is equal to %s in %s.", input, startNumSystem, output, endNumSystem);
  }
  
  static String getNumSystem() {
    
    System.out.print("Choose between \"binary\", \"octal\", \"decimal\", and \"hexadecimal\": ");
    String numSystem = s.nextLine();
    
    // i used == instead of .equals and spent 10 minutes wondering why my code wasn't working *crying
    while (!numSystem.equals("binary") && !numSystem.equals("octal") && !numSystem.equals("decimal") && !numSystem.equals("hexadecimal")) {
      System.out.print("That was not a valid input. Choose between \"binary\", \"octal\", \"decimal\", and \"hexidecimal\": ");
      numSystem = s.nextLine();
    }
    
    return numSystem;
  }
  
  public static String getValidInput(String numSystem) {
    
    System.out.print("Enter positive integers and/or letters A to F if you choose hexadecimal as your starting number system:");
    String input = s.nextLine();
    
    while (!validateInput(input, numSystem)) {
      System.out.print("That was not a valid input. ");
      System.out.print("Enter positive integers and/or letters A to F if you choose hexadecimal as your starting number system:");
      input = s.nextLine();
    }
    
    return input;
  }
  
  // there has to be a better way to do this method, you betta post your answer or rewrite my code ;-;
  public static boolean validateInput(String input, String numSystem) { 
    try {
      int placeholder = Integer.parseInt(input);
      if (placeholder < 0) return false; // we want positivity here
        
      boolean isBinary = true;
      boolean isOctal = true;

      for (int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if ((c - '0') > 1) isBinary = false;
        if ((c - '0') > 8) isOctal = false;
      }

      switch (numSystem) {
        case "binary": 
          return isBinary;
        case "octal": 
          return isOctal;
        case "decimal": 
          return true; // if input is an int, it has to be base 10 already
        default: 
          System.out.println("An error occurred.");
      }
    } catch (Exception e) {
      switch (numSystem) {
      case "hexadecimal": 
        for (int i = 0; i < input.length(); i++) {
          char c = input.charAt(i);
          if ((c < '0' || c > '9') && (c < 'A' || c > 'F')) return false;
        }
        return true;
      default: 
        return false;
      }
    }
    return false;
  }
  
  static int toDecimal(String input, String numSystem) {
    int output = 0;
    
    switch (numSystem) {
      case "binary": 
        output = binaryToDecimal(Integer.parseInt(input));
        break;
      case "octal": 
        output = octalToDecimal(Integer.parseInt(input));
        break;
      case "decimal": 
        output = Integer.parseInt(input);
        break;
      case "hexadecimal": 
        output = hexadecimalToDecimal(input);
        break;
      default: 
        System.out.println("An error occurred.");
      }
    
    return output;
  }
  
  // to combat the fact that hexadecimal has to be represented by a string 
  // and the rest of the number systems are easier to manipulate as ints
  // so in my methods i have to convert between these two datatypes and its scuffed af
  static String decimalTo(int intput, String numSystem) {
    String output = "";
    
    switch (numSystem) {
      case "binary": 
        output = String.valueOf(decimalToBinary(intput));
        break;
      case "octal": 
        output = String.valueOf(decimalToOctal(intput));
        break;
      case "decimal": 
        output = String.valueOf(intput);
        break;
      case "hexadecimal": 
        output = decimalToHexadecimal(intput);
        break;
      default: 
        System.out.println("An error occurred.");
      }
    
    return output;
  }
  
  static int binaryToDecimal(int binary) {
    int decimalNum = 0;
    int base = 1;
    
    while (binary > 0) {
      decimalNum += binary % 10 * base;
      binary /= 10;
      base *= 2;
    }
    
    return decimalNum;
  }
  
  static int octalToDecimal(int octal) {
    int decimalNum = 0;
    int base = 1;
    
    while (octal > 0) {
      decimalNum += octal % 10 * base;
      octal /= 10;
      base *= 8;
    }
    
    return decimalNum;
  }
  
  static int hexadecimalToDecimal(String hexadecimal) {
    int decimalNum = 0;
    int base = 1;
    int coefficient = 0;
    
    for (int i = hexadecimal.length() - 1; i >= 0; i--) {
      
      // aware that you can do a range from A to Z which is more efficient
      // but keeping this anyways as its originality is more charming
      switch (hexadecimal.charAt(i)) {
      case 'A': 
        coefficient = 10;
        break; // if you don't put break, it will continue
      case 'B': 
        coefficient = 11;
        break; // if you don't put break, it will continue
 	  case 'C': 
        coefficient = 12;
        break; // if you don't put break, it will continue
 	  case 'D': 
        coefficient = 13;
        break; // if you don't put break, it will continue
 	  case 'E': 
        coefficient = 14;
        break; // if you don't put break, it will continue
 	  case 'F': 
        coefficient = 15;
        break; // if you don't put break, it will continue
      default:
		// holly crap it took me 30 minutes to figure out this error
        // apparently you need to subtract 48 and idk why, please explain in your notes to me
        coefficient = hexadecimal.charAt(i) - 48;
      }
 
      decimalNum += coefficient * base;
      base *= 16;
    }
    
    return decimalNum;
  }
  
  static int decimalToBinary(int decimal) {
    ArrayList<Integer> binaryList = new ArrayList<Integer>();
    int binaryNum = 0;
    
    while (decimal != 0) {
      binaryList.add(decimal % 2);
      decimal /= 2;
    }
    
    // reverse the array
    for (int i = binaryList.size() - 1; i >= 0; i--) {
      binaryNum *= 10;
      binaryNum += binaryList.get(i);
    }
    
    return binaryNum;
  }
  
  static int decimalToOctal(int decimal) {
    ArrayList<Integer> octalList = new ArrayList<Integer>();
    int octalNum = 0;
    
    while (decimal != 0) {
      octalList.add(decimal % 8);
      decimal /= 8;
    }
    
    // reverse the array
    for (int i = octalList.size() - 1; i >= 0; i--) {
      octalNum *= 10;
      octalNum += octalList.get(i);
    }
    
    return octalNum;
  }
  
  static String decimalToHexadecimal(int decimal) {
    ArrayList<Integer> hexadecimalList = new ArrayList<Integer>();
    String hexadecimalNum = "";
    
    while (decimal != 0) {
      hexadecimalList.add(decimal % 16);
      decimal /= 16;
    }
    
    // reverse the array
    for (int i = hexadecimalList.size() - 1; i >= 0; i--) {
      switch (hexadecimalList.get(i)) {
      case 10: 
        hexadecimalNum += "A";
        break; // if you don't put break, it will continue
      case 11: 
        hexadecimalNum += "B";
        break; // if you don't put break, it will continue
      case 12: 
        hexadecimalNum += "C";
        break; // if you don't put break, it will continue
      case 13: 
        hexadecimalNum += "D";
        break; // if you don't put break, it will continue
      case 14: 
        hexadecimalNum += "E";
        break; // if you don't put break, it will continue
      case 15: 
        hexadecimalNum += "F";
        break; // if you don't put break, it will continue
      default: 
        hexadecimalNum += hexadecimalList.get(i);
      }
    }
    
    return hexadecimalNum;
  }
  
}
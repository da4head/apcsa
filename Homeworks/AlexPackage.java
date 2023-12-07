// temp holding space to copy paste methods
import java.util.*;

public class AlexPackage {
  
  public static boolean isPalindrome(String input) {
    return isPalindrome(input, 0, input.length());
  }
  public static boolean isPalindrome(String input, int start, int end) {
    if (end - 1 <= start) return true;
    if (input.charAt(start) != input.charAt(end - 1)) return false;
    return isPalindrome(input, start + 1, end -1);
  }
  
  public static void recSelectionSort(int[] arr, int start) {
    if (start == arr.length) return;
    int minIndx = start;
    for (int i = start + 1; i < arr.length; i++) {
      if (arr[i] < arr[minIndx]) minIndx = i;
    }
    
    // puts smallest value at tstart
    int temp = arr[start];
    arr[start] = arr[minIndx];
    arr[minIndx] = temp;
    
    recSelectionSort(arr, start + 1);
  }
  
  public static int recBinarySearch(int[] arr, int target, int start, int end) {
    if (start > end) return - 1;
    
    int mid = (start + end) / 2;
    
    if (arr[mid] == target) return mid;
    
    if (arr[mid] > target) return recBinarySearch(arr, target, start, mid - 1);
    
    if (arr[mid] < target) return recBinarySearch(arr, target, mid + 1, end);
    
    return -1;
     
  }
  
  public static String toSuperscript(int input) {
    String output = "";
    int length = String.valueOf(input).length();
    
    
    for (int i = 0; i < length; i++) { // the digits of each int in the reverse order...
      int currentDigit = input % 10;
      input /= 10;
      
      switch (currentDigit) { // push each superscript onto the front of output
        case 1:
          output = '\u00B9' + output;
          break;
        case 2:
          output = '\u00B2' + output;
          break;
        case 3:
          output = '\u00B3' + output;
          break;
        default:
          output = (char) ('\u2070' + currentDigit) + output;
      }
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
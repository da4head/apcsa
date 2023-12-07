// homework 1 program 1: converting birthday formats - 9/18/23
import java.util.Scanner;

class HW1_P1_BDayFormat {
  public static void main(String[] args) {
    
    Scanner s = new Scanner(System.in);
    
    System.out.print("enter your birthday in the form YYYYMMDD: ");
    int birthday = s.nextInt();
    
    int day = birthday % 100;
    int month = birthday / 100 % 100;
    int year = birthday / 10000;

    System.out.println("you were born " + month + "/" + day + "/" + year);
    
  }
}
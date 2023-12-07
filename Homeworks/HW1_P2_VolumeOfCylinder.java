// homework 1 program 2: one trick calculator volume of a cylinder - 9/18/23
import java.util.Scanner;
import java.text.DecimalFormat;

class HW1_P2_VolumeOfCylinder {
  public static void main(String[] args) {
    
	Scanner s = new Scanner(System.in);
    
    System.out.println("Let's make a cylinder!");
    System.out.print("Please enter a number to be the cylinder's radius: ");
    double radius = s.nextDouble(); 
    System.out.print("Please enter a number to be the cylinder's height: ");
    double height = s.nextDouble(); 
    
    double volume = Math.PI * Math.pow(radius, 2) * height;
    
    DecimalFormat df = new DecimalFormat( "#.###" );
    
    System.out.print("The volume of the cylinder is: ");
    System.out.print(df.format(volume));
    
  }
}
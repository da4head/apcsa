package Lab;

// lab 2: a humble rug - 9/25/23
class Lab2_Rug {
  
  static char [][] rug = new char [10][10];
  
  public static void main(String[] args) {
    
    // make grey border using a biger grey square...
    sqaureMaker(0, 10, '\u2592');
    // ...and a smaller empty square
    sqaureMaker(1, 9, ' ');
    
    // center square
    sqaureMaker(3, 7, '\u2592');
    
    // top left triangle
    for (int i = 1; i < 4; i++) {
      for (int j = 1; j < 5 - i; j++) {
        rug[i][j] = '\u2588';
      }
    }
    
    // top right triangle
    for (int i = 1; i < 4; i++) {
      for (int j = 8; j > 4 + i; j--) {
        rug[i][j] = '\u2588';
      }
    }
    
    // bottom left triangle
    for (int i = 6; i < 9; i++) {
      for (int j = 1; j < i - 4; j++) {
        rug[i][j] = '\u2588';
      }
    }
    
    // bottom right triangle
    for (int i = 6; i < 9; i++) {
      for (int j = 8; j > 13 - i; j--) {
        rug[i][j] = '\u2588';
      }
    }
    
 	// print out the rug
    printRug();
    
  }
  
  public static void sqaureMaker(int start, int end, char character) {
    
    for (int i = start; i < end; i++) {
      for (int j = start; j < end; j++) {
        rug[i][j] = character;
      }
    }
    
  }
  
  public static void printRug() {
    
    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 10; j++) {
        System.out.print(rug[i][j]);
      }
      System.out.println();
    }
    
  }
  
}
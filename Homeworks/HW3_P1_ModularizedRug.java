// homework 3 program 1: modularized rug - 10/8/23
class HW3_P1_ModularizedRug {
  
    static char[][] rug = new char[29][29];
    
    public static void main(String[] args) {
      
      border('\u2588');
      checkeredBox('\u2592', ' ', 1, 1, 27);
      box(' ', 1, 1, 9);
      box(' ', 19, 1, 9);
      box(' ', 1, 19, 9);
      box(' ', 19, 19, 9);
      box(' ', 10, 10, 9);
      triangle1('\u2593', 27, 1, 9);
      triangle2('\u2593', 27, 27, 9);
      triangle3('\u2593', 1, 27, 9);
      triangle4('\u2593', 1, 1, 9);
      diamond('\u2593', 14, 14, 9);
      printRug();
      
    }
    
    static void border(char fill) {
      for (int y = 0; y < rug.length; y++) {
        for (int x = 0; x < rug.length; x++) {
          rug[y][x] = fill;
        }
      }
      
      for (int y = 1; y < rug.length - 1; y++) {
        for (int x = 1; x < rug.length - 1; x++) {
          rug[y][x] = ' ';
        }
      } 
    }
    
    static void box(char fill, int xInitial, int yInitial, int length) {
      for (int y = yInitial; y < yInitial + length; y++) {
        for (int x = xInitial; x < xInitial + length; x++) {
          rug[y][x] = fill;
        }
      }
    }
    
    static void checkeredBox(char fill1, char fill2, int xInitial, int yInitial, int length) {
      for (int y = yInitial; y < yInitial + length; y++) {
        for (int x = xInitial; x < xInitial + length; x++) {
          if (y % 2 == 0) {
            if (x % 2 ==0) {
              rug[y][x] = fill1;
            } else {
              rug[y][x] = fill2;
            }
          } else {
            if (x % 2 ==0) {
              rug[y][x] = fill2;
            } else {
              rug[y][x] = fill1;
            }
          }
        }
      }
    }
    
    // case 1: top right triangle
    static void triangle1(char fill, int xInitial, int yInitial, int length) {
      for (int y = 0; y < length; y++) {
        for (int x = 0; x > y - length; x--) {
          rug[y + yInitial][x + xInitial] = fill;
        }
      }
    }
    
    // case 2: bottom right triangle
    static void triangle2(char fill, int xInitial, int yInitial, int length) {
      for (int y = 0; y > -length; y--) {
        for (int x = 0; x > -y - length; x--) {
          rug[y + yInitial][x + xInitial] = fill;
        }
      }
    }
    
    // case 3: bottom left triangle
    static void triangle3(char fill, int xInitial, int yInitial, int length) {
      for (int y = 0; y > -length; y--) {
        for (int x = 0; x < y + length; x++) {
          rug[y + yInitial][x + xInitial] = fill;
        }
      }
    }
    
    // case 4: top left triangle
    static void triangle4(char fill, int xInitial, int yInitial, int length) {
      for (int y = 0; y < length; y++) {
        for (int x = 0; x < -y + length; x++) {
          rug[y + yInitial][x + xInitial] = fill;
        }
      }
    }
    
    static void diamond(char fill, int xInitial, int yInitial, int length) {
      int scaledLength = (length + 1) / 2;
      triangle1(fill, xInitial, yInitial, scaledLength);
      triangle2(fill, xInitial, yInitial, scaledLength);
      triangle3(fill, xInitial, yInitial, scaledLength);
      triangle4(fill, xInitial, yInitial, scaledLength);
    }
    
    static void printRug() {
      for (int y = 0; y < rug.length; y++) {
        for (int x = 0; x < rug.length; x++) {
          System.out.print(rug[y][x]);
        }
        System.out.println();
      }
    }
  }
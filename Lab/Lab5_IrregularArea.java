package Lab;

class Lab5_IrregularArea {
  public static void main(String[] args) {
    
    System.out.printf("The area of image 1 is %.3f%n", imageOne());
    System.out.printf("The area of image 2 is %.3f%n", imageTwo());
    System.out.printf("The area of image 3 is %.3f%n", imageThree());
    
  }
  
  public static double imageOne() {
    double area = 0;
    
    area += (new Circle(1, false)).getArea() / 2; // top left semi circle
    area += (new Circle(1, false)).getArea() / 2; // top right semi circle
    area += (new Circle(1, false)).getArea() / 2; // bottom left semi circle
    area += (new Circle(1, false)).getArea() / 2; // bottom right semi circle
    
	area += (new Rectangle(10, 2, false)).getArea(); // top rectangle
    area += (new Rectangle(14, 3, false)).getArea(); // middle rectangle
    area += (new Rectangle(10, 2, false)).getArea(); // bottom rectangle
    
    area += (new Triangle(3, 3, true)).getArea(); // top left triangle
    area += (new Triangle(3, 3, true)).getArea(); // bottom right triangle
    
    return area;
  }
  
  public static double imageTwo() {
    double area = 0;
    
    area += (new Rectangle(15, 7, false)).getArea(); // total rectangle
    
    area += (new Triangle(1, 1, true)).getArea(); // left triangle A
    area += (new Triangle(1, 1, true)).getArea(); // middle triangle A
    area += (new Triangle(1, 1, true)).getArea(); // right triangle A
    area += (new Rectangle(1, 1, true)).getArea(); // top rectangle A
    area += (new Rectangle(1, 3, true)).getArea(); // bottom rectangle A
    
    area += (new Rectangle(1, 7, true)).getArea(); // rectangle A-P seperator
    
    area += (new Triangle(1, 1, true)).getArea(); // top triangle P
    area += (new Triangle(1, 2, true)).getArea(); // middle triangle P
    area += (new Triangle(1, 1, true)).getArea(); // bottom triangle P
    area += (new Rectangle(2, 3, true)).getArea(); // bottom rectangle P
    
    area += (new Rectangle(1, 7, true)).getArea(); // rectangle P-C seperator
    
    area += (new Triangle(1, 1, true)).getArea(); // top left triangle C
    area += (new Triangle(1, 1, true)).getArea(); // top right triangle C
    area += (new Triangle(1, 1, true)).getArea(); // bottom left triangle C
    area += (new Triangle(1, 1, true)).getArea(); // bottom right triangle C
    area += (new Triangle(1, 1, true)).getArea(); // upper middle triangle C
    area += (new Triangle(1, 1, true)).getArea(); // lower middle triangle C
    area += (new Rectangle(2, 3, true)).getArea(); // bottom rectangle C
    
    area += (new Rectangle(1, 7, true)).getArea(); // rectangle C-S seperator
    
	area += (new Triangle(1.5, 1, true)).getArea(); // top left triangle S
    area += (new Triangle(1.5, 1, true)).getArea(); // top right triangle S
    area += (new Triangle(1.5, 1, true)).getArea(); // bottom left triangle S
    area += (new Triangle(1.5, 1, true)).getArea(); // bottom right triangle S
    area += (new Triangle(1.5, 1, true)).getArea(); // lefter middle triangle C
    area += (new Triangle(1.5, 1, true)).getArea(); // righter middle triangle S
    
    return area;
  }
  
  public static double imageThree() {
    double area = 0;
    // smoke
    area += (new Circle(1, false)).getArea(); // top circle
    area += (new Circle(0.75, false)).getArea(); // middle circle
    area += (new Circle(0.5, false)).getArea(); // bottom circle
    
    // chimney
    area += (new Rectangle(1.5, 1, false)).getArea(); // top rectangle
    area += (new Triangle(1, 1, false)).getArea(); //  bottom triangle
    
    // roof
    area += (new Triangle(10, 4, false)).getArea(); // total triangle
    area += (new Rectangle(1, 1, true)).getArea(); // rectangle window
    area += (new Circle(0.5, false)).getArea(); // circle window

    // body
    area += (new Rectangle(8, 7, false)).getArea(); // total rectangle
    area += (new Rectangle(2, 2, true)).getArea(); // left rectangle window
    area += (new Rectangle(2, 2, true)).getArea(); // right rectangle window
    area += (new Rectangle(2, 3, true)).getArea(); // rectangle door
    area += (new Circle((double) 1 / 6, false)).getArea(); // bottom circle
    
    return area;
  }
}

class Circle {
  private double radius;
  private double area;
  private boolean isNegativeSpace;
  
  Circle(double radius, boolean isNegative) {
    this.radius = radius;
    this.area = Math.PI * this.radius * this.radius;
    this.isNegativeSpace = isNegative;
  }
  
  public double getArea() {
    return this.isNegativeSpace ? -1 * this.area : this.area;
  }
}

class Rectangle {
  private double length;
  private double width;
  private double area;
  private boolean isNegativeSpace;
  
  Rectangle(double length, double width, boolean isNegative) {
    this.length = length;
    this.width = width;
    this.area = this.length * this.width;
    this.isNegativeSpace = isNegative;
  }
  
  public double getArea() {
    return this.isNegativeSpace ? -1 * this.area : this.area;
  }
}

class Triangle {
  private double length;
  private double width;
  private double area;
  private boolean isNegativeSpace;
  
  Triangle(double length, double width, boolean isNegative) {
    this.length = length;
    this.width = width;
    this.area = this.length * this.width / 2;
    this.isNegativeSpace = isNegative;
  }
  
  public double getArea() {
    return this.isNegativeSpace ? -1 * this.area : this.area;
  }
}

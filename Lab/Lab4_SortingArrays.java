package Lab;

// lab 4: using insertion sort / selection sort / bubble sort to sort integer arrays - oct 6
import java.util.*;

class Lab4_SortingArrays {
  public static void main(String[] args) {
    
    // results of bubbleSort
    int [] arr = initRandomArray(20);
    
    System.out.println("Initial array: ");
    System.out.println(Arrays.toString(arr));
    
    System.out.println("After sorting with bubble sort: ");
    bubbleSort(arr);
   	System.out.println(Arrays.toString(arr));
    
    // results of selection sort
    arr = initRandomArray(20);
    
    System.out.println("\nInitial array: ");
    System.out.println(Arrays.toString(arr));
    
    System.out.println("After sorting with selection sort: ");
    selectionSort(arr);
   	System.out.println(Arrays.toString(arr));
    
    // results of insertion sort
    arr = initRandomArray(20);
    
    System.out.println("\nInitial array: ");
    System.out.println(Arrays.toString(arr));

    System.out.println("After sorting with insertion sort: ");
    insertionSort(arr);
   	System.out.println(Arrays.toString(arr));
    
  }

  public static void bubbleSort(int [] arr) {
    // use arr.length - 1 as even in the worst case senario 
    // where the smallest number is at the end
    // it only has to go through array length - 1 swaps to get to the beginning
    for (int n = 0; n < arr.length - 1; n++) {
      
      boolean swapped = false;
      
      // using arr.length - 1 so it doesn't exceed array length
      // iterate through all indexes
      for (int i = 0; i < arr.length - 1; i++) {
        
        // if a element is greater than the one on its left => swap them
        if (arr[i] > arr[i + 1]) {
          int temp = arr[i];
          arr[i] = arr[i + 1];
          arr[i + 1] = temp;
          swapped = true;
        }
      }
   	  // if there are no more elements to swap then the sorting is done
      // => thus we will break to stop the loop early
      if (!swapped) break;
    }
  }
  
  public static void selectionSort(int [] arr) {
    // iterate through unsorted indexes until all indexes are sorted
    // use arr.length - 1 as the last index has to be sorted if every index before it is sorted
    for (int unsortedIndx = 0; unsortedIndx < arr.length - 1; unsortedIndx++) {
      
      int minIndx = unsortedIndx;
      // use unsortedIndx + 1 as unsortedIndx is already included with the above variable declaration
      // another for loop to find index of the minimum of the remainder of the array
      for (int i = unsortedIndx + 1; i < arr.length; i++) {
        // if smaller number found => store index of smaller number
        if (arr[i] < arr[minIndx]) minIndx = i;
      }
      
      // swap the element of the unsorted index with the element of the minimum index
      int temp = arr[unsortedIndx];
      arr[unsortedIndx] = arr[minIndx];
      arr[minIndx] = temp;
    }
  }
  
  // the geeks for geeks insertion sort is better 
  // though my way is more faithful to the animation you showed us
  public static void insertionSort(int [] arr) {
    // iterate through unsorted indexes until all indexes are sorted
    // you start at one as index 0 is counted as already sorted
    for (int unsortedIndx = 1; unsortedIndx < arr.length; unsortedIndx++) {
      
	  // the current unsorted index is our candidate index
      int candidateIndx = unsortedIndx;
      
      // while the candidate element is less than the element on its left =>
      // swap candidate element with the element on the left until it is sorted 
      // use candidateIndx != 0 to stop the loop when the element reaches the beggining
      while (candidateIndx != 0 && arr[candidateIndx] < arr[candidateIndx - 1]) {
        // swap the element of the candidate index with the element on its left
        int temp = arr[candidateIndx];
        arr[candidateIndx] = arr[candidateIndx - 1];
        arr[candidateIndx - 1] = temp;
        
        // update the candidate index now that the candidate has moved to the left after the swap
        candidateIndx--;
      }
    }
  }
  
  public static int [] initRandomArray(int len) {
    int [] arr = new int[len];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = (int) (Math.random()*100);
    }
    return arr;
  }
}
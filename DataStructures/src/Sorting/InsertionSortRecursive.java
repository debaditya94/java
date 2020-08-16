package Sorting;

public class InsertionSortRecursive {
    public static void main (String [] args) {
        System.out.println("Insertion sorting recursive code");
        int[] intArray = { 2, 35, -15, 7, 55, 1, -22};

        insertionSort(intArray, intArray.length);

        for (int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
    public static void insertionSort (int[] intArray, int numItems) {
        if (numItems < 2) {
            return ;
        }
          insertionSort(intArray, numItems - 1);
            int newElement = intArray[numItems - 1];
            int i;
            for ( i = numItems - 1; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;

//            insertionSort(intArray, ++unsortedPos);
    }
}

package Arrays;

public class hackerRankCountNotification {
    public static void main (String[] args) {
        int[] expenditure = {2,3,4,2,3,6,8,4,5};
        int d = 5;
        int notificationCount = 0;
        double median = 0.0;
        int k = 0;
        while (d < expenditure.length) {
            median = returnMedian(expenditure, d, k);
            System.out.println(median);
            if (expenditure[d] >= 2 * median){
                notificationCount++;
            }
            k++;
            d++;
        }
        System.out.println(notificationCount);
    }
    static double returnMedian (int[] arr, int pos, int begPos) {
        int[] intArray = new int [pos - begPos];
        for (int i = begPos, j = 0; j < intArray.length; i++, j++) {
            intArray[j] = arr[i];
        }
        double median = 0.0;
        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            int i;
            for ( i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }
        if (intArray.length % 2 == 1) {
            median =  intArray[intArray.length / 2];
        } else {
            median =  (intArray[(intArray.length / 2) - 1] + intArray[intArray.length / 2]) / 2.0;
        }
        return median;
    }
}

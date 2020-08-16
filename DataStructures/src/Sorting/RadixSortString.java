package Sorting;

public class RadixSortString {
    public static void main (String [] args) {
        System.out.println("Radix String sorting code");
        String[] stringArray = { "bcdef", "dbaqc", "abcde", "omadd", "bbbbb" };

        radixSort(stringArray, 26, 5);

        for (int i = 0; i < stringArray.length; i++) {
            System.out.println(stringArray[i]);
        }
    }

    public static void radixSort (String[] input, int radix, int width) {
        for (int i = width - 1; i >= 0; i--) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(String[] input, int position, int radix) {

        int numItems = input.length;
        int[] countArray = new int [radix];

        for (String value: input) {
            countArray[getAlphabet(position, value)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        String[] temp = new String[numItems];
        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getAlphabet(position, input[tempIndex])]]
                    = input[tempIndex];
        }
        for (int tempIndex = 0; tempIndex < numItems; tempIndex++) {
            input[tempIndex] = temp[tempIndex];
        }

    }

    public static int getAlphabet(int position, String value) {

//        return value / (int) Math.pow(radix, position) % radix;
        return (value.charAt(position)) - 'a';
    }
}

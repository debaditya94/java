package Strings;

public class RepeatedString {
    public static void main (String[] args) {
        String s = "aba";
        long substringLength = 10;
        long count = 0;
        char[] stringArray = s.toCharArray();
        boolean[] aPosArray = new boolean [s.length()];

        long quotient = substringLength / s.length();
        long remainder = substringLength % s.length();

        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i] == 'a') {
                aPosArray[i] = true;
                count ++;
            }
        }
        count = count * quotient;

        if (remainder > 0) {
            for (int i = 0; i < aPosArray.length; i++) {
                if (aPosArray[i] && (i <= (remainder - 1)) ) {
                    count++;
                }
            }
        }

//        for (int i = 1; i <= quotient; i++) {
//            str = str.concat(s);
//        }

//        char [] stringArray  = s.toCharArray();
//        for (long i = 0; i < remainder; i++) {
//            str = str + stringArray[(int)(i)];
//        }
//        for (int i = 0; i < str.length(); i++) {
//            if (str.charAt(i) == 'a') {
//                count++;
//            }
//        }
//        System.out.println(str);
        System.out.println(count);
    }
}

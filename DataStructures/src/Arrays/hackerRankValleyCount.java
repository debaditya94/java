package Arrays;

public class hackerRankValleyCount {
    public static void main(String[] args) {
        String steps = "UDDDUDUU";
        int valleyCount = 0;
        int seaLevel = 0;
        boolean isInsideValley = false;


        for (int i = 0; i < steps.length(); i++) {
            if (steps.charAt(i) == 'U') {
                seaLevel++;
                if (seaLevel == 0) {
                    isInsideValley = false;
                }
            }
            if (steps.charAt(i) == 'D') {
                seaLevel--;
                if (seaLevel + 1 == 0 && !isInsideValley) {
                    valleyCount++;
                    isInsideValley = true;
                }
            }
        }
        System.out.println(valleyCount);
    }
}

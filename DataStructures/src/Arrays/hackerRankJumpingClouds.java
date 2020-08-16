package Arrays;

public class hackerRankJumpingClouds {
    public static void main(String[] args) {
        int [] c = { 0,0,0,1,0,0 };
        int jumpCount = 0;
        for (int i = 0; i <= c.length - 2; i++) {
            if (((i + 2) < c.length) && c[i + 2] % 2 != 1) {
                i = i + 1;
            }
            jumpCount++;
        }
        System.out.println(jumpCount);
    }
}

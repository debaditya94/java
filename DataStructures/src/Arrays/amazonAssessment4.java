package Arrays;
import java.util.*;

public class amazonAssessment4 {
    static Queue<Zombie> queue = new LinkedList<>();
    public static int humanDays(int[][] matrix) {
        int totalDays = 0;

        if (matrix.length == 0) {
            return 0;
        } else {
            if (matrix[0].length == 0) {
                return 0;
            }
        }

        int[][] a = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 1) {
                    AddZombieToQueue(matrix, i, j, 0);
                }
            }
        }

        if (queue.size() == 0) return -1;

        while(queue.size() > 0)
        {
            Zombie o = queue.remove();
            queue.remove();

            // Update the turn. (This zombie is definitely infected last, cuz q).
            totalDays = o.days;

            // Handle infecting any neighbors.
            InfectNeighbors(matrix, o.i, o.j, o.days + 1);
        }

        return totalDays;
    }
    public static void AddZombieToQueue(int[][] matrix, int i, int j, int dayInfected) {
        matrix[i][j] = 1;
        Zombie z = new Zombie(i, j, dayInfected);
        queue.add(z);
    }
    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 1, 1, 0, 1}, {0, 1, 0, 1, 0}, {0, 0, 0, 0, 1}, {0, 1, 0, 0, 0}}; //2
        int[][] grid2 = new int[][]{{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}; //-1
        int[][] grid3 = new int [0][0];
        int[][] grid4 = new int[][]{{1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}, {1, 1, 1, 1, 1}}; //0
        System.out.println(humanDays(grid));
        System.out.println(humanDays(grid2));
        System.out.println(humanDays(grid3));
        System.out.println(humanDays(grid4));
    }
    public static void InfectNeighbors(int[][] matrix, int i, int j, int dayInfected)
    {
        // Look at the cells up, down, left, and right, if valid cells in the grid.
        // If there's a human there, convert it to a zombie and add it to the queue.

        // Up
        if(i-1 >= 0 && matrix[i-1][j] == 0)
        { AddZombieToQueue(matrix, i-1, j, dayInfected); }

        // Down
        if(i+1 < matrix.length && matrix[i+1][j] == 0)
        { AddZombieToQueue(matrix, i+1, j, dayInfected); }

        // Left
        if(j-1 >= 0 && matrix[i][j-1] == 0)
        { AddZombieToQueue(matrix, i, j-1, dayInfected); }

        // Right
        if(j+1 < matrix[i].length && matrix[i][j+1] == 0)
        { AddZombieToQueue(matrix, i, j+1, dayInfected); }
    }
}
class Zombie {
    int i;
    int j;
    int days;

    Zombie(int i, int j, int days) {
        this.i = i;
        this.j = j;
        this.days = days;
    }
}

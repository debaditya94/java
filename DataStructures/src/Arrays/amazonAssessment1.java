package Arrays;
import java.util.*;

public class amazonAssessment1 {
    public static void main(String[] args) {
        int [] ropes = {5, 13, 23, 33, 45};
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int totalCost = 0;
        for (int i = 0; i < ropes.length; i++) {
            pq.add(ropes[i]);
        }
        while(pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            totalCost += ( min1 + min2 );
            pq.add( min1 + min2);
        }
        System.out.println(totalCost);
    }

}

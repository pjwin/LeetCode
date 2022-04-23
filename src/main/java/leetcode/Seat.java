package leetcode;

public class Seat {
    public int maxDistToClosest(int[] seats) {
        int count=1;
        int max=1;
        boolean bound = false;

        for (int i=0; i<seats.length; i++) {
            if (seats[i] == 1) {
                if (bound == false) {
                    if (count > max) max = count -1;
                } else {
                    if (count/2 > max) max = count/2;
                }
                bound = true;
                count = 1;
            } else {
                count++;
            }
        }
        if (seats[seats.length-1] == 0) {
            if (count > max) max = count -1;
        }

        return max;
    }
}

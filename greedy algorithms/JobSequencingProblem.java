// shayad ye code galat hoga fo example is array ke liye
// int jobsAndProfits[][] = {{1,20}, {3,30}, {4,40}, {1,10}};

/* 
    Given an array of jobs where every job has a deadline and profit if the job is finished
    before the deadline. It is also given that every job takes a single unit of time, so the
    minimum possible deadline for any job is 1. Maximize the total profit if only one job can
    be scheduled at a time.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class JobSequencingProblem {
    public static void main(String[] args) {

        int jobsAndProfits[][] = {{4,20}, {1,10}, {1,40}, {1,30}};
        int time = 0;

        Arrays.sort(jobsAndProfits, Comparator.comparingDouble(o -> o[1]));

        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = jobsAndProfits.length-1; i >= 0; i--) {
            if (time < jobsAndProfits[i][0]) {
                answer.add(i);
                time++;
            }
        }

        System.out.println("Total number of jobs performed: " + answer.size());
        System.out.println("Job sequence: " + answer);
    }
}

/*  
    You are given n activities with their start and end times. Select the maximum number of activities that can be performed by a single person, 
    assuming that a person can only work on a single activity at a time. Activities are sorted according to end time. 
*/

import java.util.*;

public class activitySelection {

    public static void main(String[] args) {

        int start[] = {1,3,0,5,8,5};
        int end[] = {2,4,6,7,9,9};    // end time sorted. But if not sorted:

        // creating a dda to store the times and sort them according to asc order of end time. 
        int activities[][] = new int[end.length][3];
        for (int i = 0; i < activities.length; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2])); // lambda function is used

        ArrayList<Integer> ans = new ArrayList<>();

        // adding 1st activity
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];

        for (int i = 1; i < end.length; i++) {
            // here we will add only those activities whose start time is greater than or equal to 
            // the end time of the previous completed activity.
            if (activities[i][1] >= lastEnd) {
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Total no. of activities performed: " + ans.size());
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }

    }
}
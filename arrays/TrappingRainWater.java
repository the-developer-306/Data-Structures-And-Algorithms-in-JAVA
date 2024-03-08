public class TrappingRainWater {

    public static void main(String[] args) {

        int arr[] = new int[] { 4, 2, 0, 6, 3, 2, 5 };

        int leftMax[] = new int[arr.length];
        int rightMax[] = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int waterVolume = 0;
        int trappedWater;

        // auxillary array 1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                leftMax[i] = arr[i];
                max = arr[i];
            } else {
                leftMax[i] = max;
            }
        }

        max = Integer.MIN_VALUE;

        // auxillary array 2
        for (int i = (arr.length - 1); i >= 0; i--) {
            if (arr[i] > max) {
                rightMax[i] = arr[i];
                max = arr[i];
            } else {
                rightMax[i] = max;
            }
        }

        //calculating trapped water
        for (int i = 0; i < arr.length; i++) {
            trappedWater = (Math.min(leftMax[i], rightMax[i])) - arr[i];
            waterVolume += trappedWater;
        }

        System.out.println(waterVolume);

    }

}

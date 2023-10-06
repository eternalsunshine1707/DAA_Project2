import java.util.*;

public class ConvexHull {
    //Method to find the convex hull using the Divide and Conquer Algorithm
    public static List<int[]> convexHull(int[][] points) {
        //If there are less than 3 points, it returns the input as the convex hull
        if (points.length < 3) {
            return Arrays.asList(points);
        }

        //Sorting the points based on their x-coordinates (and y-coordinates if x-coordinates are equal)
        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<int[]> upper = new ArrayList<>(); //Upper hull
        List<int[]> lower = new ArrayList<>(); //Lower hull

        //Computing the upper hull
        for (int[] point : points) {
            while (upper.size() >= 2 && isNotRightTurn(upper.get(upper.size() - 2), upper.get(upper.size() - 1), point)) {
                upper.remove(upper.size() - 1); //Removes the last point if it makes a non-right turn
            }
            upper.add(point); //Adds the current point to the upper hull
        }

        //Computing the lower hull
        for (int i = points.length - 1; i >= 0; i--) {
            int[] point = points[i];
            while (lower.size() >= 2 && isNotRightTurn(lower.get(lower.size() - 2), lower.get(lower.size() - 1), point)) {
                lower.remove(lower.size() - 1); //Removes the last point if it makes a non-right turn
            }
            lower.add(point); //Adds the current point to the lower hull
        }

        //Combining upper and lower hulls to form the convex hull
        HashSet<int[]> hull = new HashSet<>(upper);
        hull.addAll(lower);
        return new ArrayList<>(hull);
    }

    //To check if three points are making non-right turn(collinear) 
    //If they are the function returns true, indicating that these points could potentially be part of the convex hull.
    private static boolean isNotRightTurn(int[] a, int[] b, int[] c) {
        return (b[0] - a[0]) * (c[1] - a[1]) - (b[1] - a[1]) * (c[0] - a[0]) <= 0;
    }

    //Generates random points within a given range
    public static int[][] generateRandomPoints(int n, int min, int max) {
        int[][] points = new int[n][2];
        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            int x = rand.nextInt(max - min + 1) + min;
            int y = rand.nextInt(max - min + 1) + min;
            points[i][0] = x;
            points[i][1] = y;
        }

        return points;
    }

    //Main method to test the implementation
    public static void main(String[] args) {
        int n = 10000; //Change this to the number of random points you want
        int[][] points = generateRandomPoints(n, 0, 100); //Range can be adjusted as needed

        System.out.println("Generated Points:");
        for (int[] point : points) {
            System.out.println(point[0] + "," + point[1]);
        }

        long startTime = System.nanoTime(); //Gets the start time

        List<int[]> hull = convexHull(points); //Computes the convex hull
        
        long endTime = System.nanoTime(); //Gets the end time
        long totalTime = endTime - startTime; //Calculates the total time taken

        System.out.println("Convex Hull of given " + n + " points:");
        for (int[] point : hull) {
            System.out.println(point[0] + "," + point[1]);
        }
        System.out.println("Total time taken: " + totalTime + " nanoseconds"); //prints total time taken to execute the code
    }
}
import java.util.Arrays;

public class MaxMatrixSum {

    public static long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;

        // Traverse the matrix
        for (int[] row : matrix) {
            for (int value : row) {
                totalSum += Math.abs(value);
                if (value < 0) {
                    negativeCount++;
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        // Adjust the total sum if there is an odd number of negatives
        if (negativeCount % 2 == 1) {
            totalSum -= 2L * minAbsValue;
        }

        return totalSum;
    }

    public static void displayMatrix(int[][] matrix) {
        System.out.println("Matrix:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {
            {1, -2, 3},
            {-4, 5, -6},
            {7, 8, -9}
        };

        // Display the matrix
        displayMatrix(matrix);

        // Calculate the max matrix sum
        long result = maxMatrixSum(matrix);

        // Display the result
        System.out.println("\nMaximum Matrix Sum: " + result);
    }
}

package algorithm.top100medium.RotateImage;

public class Solution {
    public void rotate(int[][] matrix) {
        reverse(matrix);
        symmetry(matrix);
    }

    public void reverse(int[][] matrix) {
        for (int i = 0, j = matrix.length - 1; i < j; i++, j--) {
            for (int k = 0; k < matrix[0].length; k++) {
                matrix[i][k] = matrix[i][k] ^ matrix[j][k];
                matrix[j][k] = matrix[i][k] ^ matrix[j][k];
                matrix[i][k] = matrix[i][k] ^ matrix[j][k];
            }
        }
    }

    public void symmetry(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                matrix[i][j] = matrix[i][j]^matrix[j][i];
                matrix[j][i] = matrix[i][j]^matrix[j][i];
                matrix[i][j] = matrix[i][j]^matrix[j][i];
            }
        }
    }
}

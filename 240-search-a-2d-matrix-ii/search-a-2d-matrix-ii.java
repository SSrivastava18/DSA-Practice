class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        return search(matrix, 0, matrix[0].length - 1, target);
    }

    private boolean search(int[][] matrix, int row, int col, int target) {

        if (row >= matrix.length || col < 0) {
            return false;
        }

        if (matrix[row][col] == target) {
            return true;
        }

        if (matrix[row][col] > target) {
            return search(matrix, row, col - 1, target);
        }

        else {
            return search(matrix, row + 1, col, target);
        }
    }
}
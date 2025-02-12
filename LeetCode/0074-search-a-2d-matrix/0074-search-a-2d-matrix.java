class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom) {
            int mid = (top + bottom) / 2;

            if (matrix[mid][0] <= target && matrix[mid][matrix[0].length - 1] >= target) {
                break;
            } else if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else if (matrix[mid][0] < target) {
                top = mid + 1;
            }
        }

        int row = (top + bottom) / 2;

        int left = 0;
        int right = matrix[0].length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                right = mid - 1;
            } else if (matrix[row][mid] < target) {
                left = mid + 1;
            }
        }

        return false;
    }
}
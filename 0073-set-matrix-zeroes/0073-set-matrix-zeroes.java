class Solution {
    public void setZeroes(int[][] matrix) {
        int[][] copy = new int[matrix.length][];
        for(int i = 0; i < matrix.length; i++) {
            copy[i] = matrix[i].clone();
        }

        for(int i = 0; i < copy.length; i++) {
            for(int j = 0; j < copy[i].length; j++) {
                if(copy[i][j] == 0) {
                    setZero(matrix, i, j);
                }
            }
        }
    }

    private void setZero(int[][] matrix, int row, int col) {
        // Set entire row to zero
        for(int j = 0; j < matrix[row].length; j++) {
            matrix[row][j] = 0;
        }
        
        // Set entire column to zero
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
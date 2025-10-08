class Solution {
    public void rotate(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        int x=0;
        int y=cols-1;
        while(x<=y){
            for(int i=0;i<rows;i++){
                int temp=transposedMatrix[i][x];
                transposedMatrix[i][x]=transposedMatrix[i][y];
                transposedMatrix[i][y]=temp;
                
            }
            x++;
            y--;
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                matrix[i][j]=transposedMatrix[i][j];
            }
        }
        

    }
}
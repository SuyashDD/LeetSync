class Solution {
    public void setZeroes(int[][] mat) {
        int firstColZero = 1;

        for(int r = 0 ; r < mat.length ; r++){
            for(int c = 0 ; c < mat[0].length ; c++){
                if(mat[r][c] == 0){
                    mat[r][0] = 0;
                    if(c != 0){
                        mat[0][c] = 0;
                    }
                    else{
                        firstColZero = 0;
                    }
                }
            }
        }

        for(int r = 1 ; r < mat.length ; r++){
            for(int c = 1 ; c < mat[0].length ; c++){
                if(mat[r][0] == 0 || mat[0][c] == 0){
                    mat[r][c] = 0;
                }
            }
        }
        if(mat[0][0] == 0){
            for(int c = 0 ; c < mat[0].length ; c++){
                mat[0][c] = 0;
            }
        }
        if(firstColZero == 0){
            for(int r = 0 ; r < mat.length ; r++){
                mat[r][0] = 0;
            }
        }
    }
}
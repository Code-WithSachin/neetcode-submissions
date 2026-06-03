class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;

        int i = 0, j = (m*n)-1;

        while(i <= j){
            int mid = i + (j-i)/2;

            int indexI = mid/m;
            int indexJ = mid%m;

            System.out.println(indexI+" "+indexJ);

            if(matrix[indexI][indexJ] == target) return true;

            if(matrix[indexI][indexJ] > target){
                j = mid -1;
            }else{
                i = mid +1;
            }
        }

        return false;
    }
}

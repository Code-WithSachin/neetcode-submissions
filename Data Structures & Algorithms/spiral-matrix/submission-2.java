class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int uRow = 0, lRow = matrix.length-1, lColumn = 0, rColumn = matrix[0].length-1;
        int direction = 0;
        List<Integer> list = new ArrayList<>();

        while(uRow <= lRow && lColumn <= rColumn){
            if(direction == 0){
                for(int i = lColumn; i<= rColumn; i++){
                    list.add(matrix[uRow][i]);
                }
                direction = 1;
                uRow++;
            }else if(direction == 1){
                for(int i = uRow; i<= lRow; i++){
                    list.add(matrix[i][rColumn]);
                }
                direction = 2;
                rColumn--;
            }else if(direction == 2){
                for(int i = rColumn; i>= lColumn; i--){
                    list.add(matrix[lRow][i]);
                }
                direction = 3;
                lRow--;
            }else{
                for(int i = lRow; i >= uRow; i--){
                    list.add(matrix[i][lColumn]);
                }
                direction = 0;
                lColumn++;
            }
        }

        return list;
    }
}
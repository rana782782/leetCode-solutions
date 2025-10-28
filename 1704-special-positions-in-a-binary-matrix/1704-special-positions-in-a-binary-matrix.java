class Solution {
    public int numSpecial(int[][] mat) {
        HashMap<Integer,Integer>rowMap = new HashMap<>();
        HashMap<Integer,Integer>colMap = new HashMap<>();
        
       for(int row = 0; row<mat.length; row++){
        for(int col = 0; col<mat[0].length; col++){
            if(mat[row][col] == 1){
                rowMap.put(row,rowMap.getOrDefault(row,0)+1);
                colMap.put(col,colMap.getOrDefault(col,0)+1);
            }
        }
       }
  int output = 0;

  for(int i = 0; i<mat.length; i++){
    for(int j = 0; j<mat[0].length; j++){
        if(mat[i][j] == 1 && rowMap.get(i)<=1 && colMap.get(j)<=1)output++;
    }
  }

  return output;

    }
}
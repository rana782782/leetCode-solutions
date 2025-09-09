// LeetCode: Magic Squares In Grid (magic-squares-in-grid)
// Submission ID: 1764687518
// Language: java
// Timestamp (UTC): 2025-09-09T07:57:39Z

class Solution {
    static int m,n;

   public static boolean isMagicGrid(int i, int j, int grid[][]){
    int startRow = i - 2;  // top-left row of the 3x3
    int startCol = j - 2;  // top-left col of the 3x3
        
    HashMap<Integer,Integer> rowSum = new HashMap<>();
    HashMap<Integer,Integer> colSum = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    int diagSum = 0;
    for(int row = startRow; row <= i; row++){
        for(int col = startCol; col <= j; col++){
            int ele = grid[row][col];
            if(ele < 1 || ele > 9) return false;
            if(set.contains(ele)) return false;
            set.add(ele);
            rowSum.put(row, rowSum.getOrDefault(row,0) + ele);
            colSum.put(col, colSum.getOrDefault(col,0) + ele);
            if((row - startRow) == (col - startCol)) diagSum += ele;
        }
    }
    if(set.size() != 9) return false;
    int antiDiag = 0;
    int colIdx = j;
    for(int row = startRow; row <= i; row++){
        antiDiag += grid[row][colIdx];
        colIdx--;
    }
    if(diagSum != antiDiag) return false;
    for(int val : rowSum.values()){
        if(val != diagSum) return false;
    }
    for(int val : colSum.values()){
        if(val != diagSum) return false;
    }
    return true;
}

    public int numMagicSquaresInside(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
        int count = 0;


        for(int i = 2; i<m; i++){
            for(int j = 2; j<n; j++){
                if(isMagicGrid(i,j,grid))count++;
            }
        }
         System.out.print(count);
        return count;
    }
}
// LeetCode: Maximal Rectangle (maximal-rectangle)
// Submission ID: 1730135622
// Language: java
// Timestamp (UTC): 2025-08-10T13:17:57Z

class Solution {
    public static int largestHistoGram(int arr[]){
   Deque<Integer> st = new ArrayDeque<>();
   int n = arr.length;
   int rs[] = new int[n];
   int ls[] = new int[n];

// Next smaller to right (strictly smaller). If none, set to n.
for (int i = n - 1; i >= 0; i--) {
    while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
        st.pop();
    }
    rs[i] = st.isEmpty() ? n : st.peek();
    st.push(i);
}

st.clear();

// Next smaller to left (strictly smaller). If none, set to -1.
for (int i = 0; i < n; i++) {
    while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
        st.pop();
    }
    ls[i] = st.isEmpty() ? -1 : st.peek();
    st.push(i);
}

int max_area = 0;
for (int i = 0; i < n; i++) {
    int width = rs[i] - ls[i] - 1; // not abs difference
    int area = width * arr[i];
    if (area > max_area) max_area = area;
}
return max_area;

    }
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int grid[][] = new int[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == '1')grid[i][j] = 1;
                else{
                    grid[i][j] = 0;
                }
            }
        }

        int output = 0;

        for(int i = 0; i<m; i++){
            for(int j =0; j<n;j++){
                if(i!=0){
                    if(grid[i][j] == 1){
                        grid[i][j]+=grid[i-1][j];
                    }
                    else{
                        grid[i][j] = 0;
                    }
                }
            }
        }

        for(int arr[] : grid){
            output = Math.max(output,largestHistoGram(arr));
        }

        return output;

    }
}
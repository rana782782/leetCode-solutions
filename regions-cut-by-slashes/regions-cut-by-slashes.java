// LeetCode: Regions Cut By Slashes (regions-cut-by-slashes)
// Submission ID: 1473550941
// Language: java
// Timestamp (UTC): 2024-12-08T14:41:09Z

class Solution {
    public int regionsBySlashes(String[] grid) {
      int n=grid.length;
       int[] parent=new int[(n+1)*(n+1)];
       int[] rank=new int[(n+1)*(n+1)];
        for(int i=0;i<(n+1)*(n+1);i++)
        {
            parent[i]=i;
        }
       
        connect0(n,parent,rank);
        
        int count=1;
        for(int i=0;i<n;i++){
            String row=grid[i];
            for(int j=0;j<row.length();j++){
                char c=row.charAt(j);
                if(c=='/'){
                    int x=(n+1)*i+(j+1);
                    int y=(n+1)*(i+1)+j;
                    boolean ans=union(x, y, parent, rank);
                    
                    if(ans){
                        count++;
                    }
                }
                else if(c=='\\') {
                    int x = (n + 1) * i + (j);
                    int y = (n + 1) * (i + 1) + j + 1;
                    boolean ans=union(x, y, parent, rank);
                   
                    if(ans){
                        count++;
                    }

                }
            }
        }

       return (count);

    }
    public static boolean union(int x,int y,int[] parent,int[] rank)
    {
        int parent_x=find(x,parent);
        int parent_y=find(y,parent);

        if(parent_x==parent_y){
            return true;
        }

            if(rank[parent_x]==rank[parent_y]){
                parent[parent_y]=parent_x;
            }
            else if(rank[parent_x]>rank[parent_y]){
                parent[parent_x]=parent_y;
                rank[parent_x]++;
            }
            else {
                parent[parent_y]=parent_x;
                rank[parent_y]++;
            }

        return false;
    }
    public static int find(int x,int[] parent)
    {

        if(x==parent[x])
        {
            return x;
        }
        return parent[x]=find(parent[x],parent);
    }


    public static void connect0(int n,int[] parent,int[] rank)
    {
        // Connect boundaries
        for (int i = 0; i <= n; i++) {
            int topBoundary = i;
            int bottomBoundary = (n + 1) * n + i;
            int leftBoundary = (n + 1) * i;
            int rightBoundary = (n + 1) * i + n;

            union(0,bottomBoundary, parent, rank);
            union(0, rightBoundary, parent, rank);
            union(0,topBoundary, parent, rank);
            union(0,leftBoundary, parent, rank);

        }
    }
}
class Solution {
    static HashMap<String,int[]>map;
        public static int[] dfs(int vertex,List<List<Integer>>graph,String labels,boolean visited[]){
            visited[vertex] = true;
            int output[] = new int[26];

            for(int nbrs : graph.get(vertex)){
               if(!visited[nbrs]){
                 int temp[] = dfs(nbrs,graph,labels,visited);
                for(int i = 0; i<26; i++){
                    output[i]+=temp[i];
                }
               }
            }

            output[labels.charAt(vertex)-'a']++;
            String code = vertex+"_"+labels.charAt(vertex);
            map.put(code,output);
            return output;
        }
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        List<List<Integer>>graph = new ArrayList<>();
            map = new HashMap<>();
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int d[] : edges){
            int u = d[0];
             int v = d[1];
             graph.get(u).add(v);
             graph.get(v).add(u);
        }

            boolean visited[] = new boolean[n];
            dfs(0,graph,labels,visited);

  int ans[] = new int[n];

  for(int i = 0; i<labels.length(); i++){
        char ch = labels.charAt(i);
        String code = i+"_"+ch;
        int temp[] = map.get(code);
        ans[i] = temp[ch-'a']; 

  }
  return ans;
       
    }
}
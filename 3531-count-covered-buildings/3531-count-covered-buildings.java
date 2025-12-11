class Solution {
        public static int getIdx(int vertex,List<Integer>ls){
            int l = 0;
            int h = ls.size()-1;

            while(l<=h){
                int mid = l+(h-l)/2;

                if(ls.get(mid) == vertex)return mid;
                else if(ls.get(mid)<vertex)l = mid+1;
                else h = mid-1;
            }

            return -1;
        }
    public static boolean solution(int arr[],HashMap<Integer,List<Integer>>mapx,HashMap<Integer,List<Integer>>mapy){
             
             int x = arr[0];
              int y = arr[1];

              List<Integer>lsY = mapx.get(x);

              int idx = getIdx(y, lsY);
              if(idx!=-1){

                int rightEle = lsY.size()-idx-1;
                if(rightEle<1)return false;

                int leftEle = idx-0;
                if(leftEle<1)return false;

                List<Integer>lsX = mapy.get(y);

                idx = getIdx(x, lsX);
                if(idx!=-1){
                      rightEle = lsX.size()-idx-1;
                if(rightEle<1)return false;

                 leftEle = idx-0;
                if(leftEle<1)return false;

                return true;
                }
              }
              return false;
    }
    public int countCoveredBuildings(int n, int[][] buildings) {
        Arrays.sort(buildings, (a, b) -> {
    if (a[0] != b[0]) return a[0] - b[0];   
    return a[1] - b[1];                   
});

HashMap<Integer,List<Integer>>mapx = new HashMap<>();
HashMap<Integer,List<Integer>>mapy = new HashMap<>();

for(int b[] : buildings){
    int x = b[0];
    int y = b[1];

    List<Integer>subListX = mapx.getOrDefault(x,new ArrayList<>());
    subListX.add(y);
    mapx.put(x,subListX);

    List<Integer>subListY = mapy.getOrDefault(y,new ArrayList<>());
    subListY.add(x);
    mapy.put(y,subListY);
}

int count = 0;

for(int b[] : buildings){
    if(solution(b,mapx,mapy))count++;
}

return count;
    }
}
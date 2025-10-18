class Solution {
    public static List<Integer> generate(int n){
        List<Integer>output = new ArrayList<>();
        output.add(1);
        output.add(2);
        
        while(output.get(output.size()-1)+output.get(output.size()-2)<=n){
           output.add(output.get(output.size()-1)+output.get(output.size()-2));
        }
        return output;
    }

    public static int solution(List<Integer>list,int n){
        int count = 0;
        int idx = list.size()-1;
        while(idx>=0){
            if(n == 0)break;
            if(list.get(idx)<=n){
                n-=list.get(idx);
                count++;
                continue;
            }
            else{
                idx--;
            }
        }
        return count;
    }
    public int findMinFibonacciNumbers(int k) {
        List<Integer>list = generate(k);

        for(int ele : list){
            System.out.println(ele);
        }
          return solution(list,k);
       
    }
}
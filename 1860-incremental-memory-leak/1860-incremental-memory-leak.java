class Solution {
    public int[] memLeak(int memory1, int memory2) {
     

        int time = 1;

        boolean flag = true;

        while(flag){
            if(time>memory1 && time>memory2){
                break;
            }
            if(memory1 == memory2){
                if(time<=memory1){
                    memory1-=time;
                    time++;
                }
            }
            else if(memory1>memory2){
                 if(time<=memory1){
                    memory1-=time;
                    time++;
                }
            }
            else{
                 if(time<=memory2){
                    memory2-=time;
                    time++;
                }
            }
        }

       int output[] = {time,memory1,memory2};

       return output;

    
        
    }
}
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total =numBottles;
        int emptyBot = numBottles;
        
        while(emptyBot>=numExchange){
            emptyBot-=numExchange;
            numExchange+=1;
            total+=1;
            emptyBot+=1;
        }

        return total;
    }
}
// LeetCode: Design A Leaderboard (design-a-leaderboard)
// Submission ID: 1652949938
// Language: java
// Timestamp (UTC): 2025-06-03T17:32:25Z

class Leaderboard {
    static HashMap<Integer,Integer>map;

    public Leaderboard() {
        map = new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        map.put(playerId,map.getOrDefault(playerId,0)+score);
    }
    
    public int top(int K) {
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        
        for(int key : map.keySet()){
            if(pq.size()<K)pq.add(map.get(key));
            else if(pq.peek()<map.get(key)){
                pq.poll();
                pq.add(map.get(key));
            }
        }
        
        int sum = 0;
        while(!pq.isEmpty())sum+=pq.poll();
        
        return sum;
    }
    
    public void reset(int playerId) {
        map.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
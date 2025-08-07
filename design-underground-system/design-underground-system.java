// LeetCode: Design Underground System (design-underground-system)
// Submission ID: 1726823807
// Language: java
// Timestamp (UTC): 2025-08-07T12:27:13Z

class UndergroundSystem {
    public class Pair{
        String stPoint;
        int stTime;

        Pair(String stPoint, int stTime){
            this.stPoint = stPoint;
            this.stTime = stTime;
        }
    }

    static HashMap<Integer,Pair>map1;

    public class TimeCount{
        int totalTime;
         int totalTrip;

         TimeCount(int totalTime, int totalTrip){
            this.totalTime = totalTime;
            this.totalTrip = totalTrip;
         }
    }

    static HashMap<String,TimeCount>map2;

    public UndergroundSystem() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Pair p = new Pair(stationName,t);

        map1.put(id,p);
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair p = map1.get(id);
        int diff = t-p.stTime;

        String inIdx = p.stPoint+"_"+stationName;

        TimeCount p2 = map2.getOrDefault(inIdx, new TimeCount(0, 0));

        p2.totalTime+=diff;
        p2.totalTrip++;

        map2.put(inIdx,p2);
        map1.remove(id);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        String inIdx = startStation+"_"+endStation;

        TimeCount p2 = map2.get(inIdx);

            return (double)p2.totalTime/p2.totalTrip;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
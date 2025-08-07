// LeetCode: Design HashSet (design-hashset)
// Submission ID: 1726792453
// Language: java
// Timestamp (UTC): 2025-08-07T11:46:55Z

class MyHashSet {
   static int m;
    static ArrayList<Integer> arr[];

    public MyHashSet() {
        m = 100001;
        arr = new ArrayList[m];

        Arrays.fill(arr,new ArrayList<>());
    }
    
    public void add(int key) {
        if(contains(key))return;
        
        int getIdx = key%m;

        arr[getIdx].add(key);

    }
    
    public void remove(int key) {
        if(contains(key)){
            int getIdx = key%m;

            ArrayList<Integer>subList = arr[getIdx];
            for(int i = 0; i<subList.size(); i++){
                if(subList.get(i) == key){
                    subList.remove(i);
                    return;
                }
            }
        }
    }
    
    public boolean contains(int key) {
        int getIdx = key%m;
        ArrayList<Integer>subList = arr[getIdx];
        if(subList.contains(key))return true;
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
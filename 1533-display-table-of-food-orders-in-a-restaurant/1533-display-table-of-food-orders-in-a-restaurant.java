class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String>set = new TreeSet<>();
        TreeMap<Integer,TreeMap<String,Integer>>map = new TreeMap<>();

        for(List<String>subList : orders){
            int tableNum = Integer.parseInt(subList.get(1));
            String dish = subList.get(2);
            set.add(dish);
            TreeMap<String,Integer> subMap = map.getOrDefault(tableNum,new TreeMap<>());
            subMap.put(dish,subMap.getOrDefault(dish,0)+1);
            map.put(tableNum,subMap);
        }

        List<List<String>>output = new ArrayList<>();
        List<String>subAns = new ArrayList<>();
        subAns.add("Table");
        for(String str : set){
            subAns.add(str);
        }

        output.add(subAns);
       for(int key : map.keySet()){
        subAns = new ArrayList<>();
        subAns.add(String.valueOf(key));
        TreeMap<String,Integer>subMap = map.get(key);
        for(String str : set){
            if(subMap.containsKey(str))subAns.add(String.valueOf(subMap.get(str)));
            else{
                subAns.add("0");
            }
        }
        output.add(subAns);

       }

       return output;
    }
}
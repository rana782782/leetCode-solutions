// LeetCode: Remove Sub-Folders from the Filesystem (remove-sub-folders-from-the-filesystem)
// Submission ID: 1708854171
// Language: java
// Timestamp (UTC): 2025-07-23T18:02:11Z

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String>output = new ArrayList<>();

        HashSet<String>set = new HashSet<>();

        for(String str : folder){

            String subArr[] = str.split("/");

              StringBuilder code = new StringBuilder();
              boolean flag = false;
            for(String subStr : subArr){
                  code.append(subStr+"_");
                  if(set.contains(code.toString())){
                    flag = true;
                    break;
                  }
            }

            if(!flag){
                set.add(code.toString());
                output.add(str);
            }
        }

        return output;
    }
}
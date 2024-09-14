// LeetCode: Convert Date to Binary (convert-date-to-binary)
// Submission ID: 1389396511
// Language: java
// Timestamp (UTC): 2024-09-14T04:44:19Z

class Solution {
  	public static String convert(int num) {
		StringBuilder ans = new StringBuilder();
		while(num!=0) {
			if(num%2 == 0) {
				ans.append("0");
			}
			else {
				ans.append("1");
			}
			num = num/2;
		}
		return ans.reverse().toString();
		
	}
	
	 public static String convertDateToBinary(String date) {
	         String arr[] = date.split("-");
	         StringBuilder output = new StringBuilder();
	         String year = convert(Integer.parseInt(arr[0]));
	         String month = convert(Integer.parseInt(arr[1]));
	         String tarik = convert(Integer.parseInt(arr[2]));
	         output.append(year+'-'+month+"-"+tarik);
	         return output.toString();
	         
	    }
}
// LeetCode: Design Browser History (design-browser-history)
// Submission ID: 1726752497
// Language: java
// Timestamp (UTC): 2025-08-07T10:55:10Z

class BrowserHistory {
    public static class Dll{

        String data;
        Dll next;
        Dll prev;

        Dll(String data){
            this.data = data;
            this.next = null;
            this.prev = prev;
        }
    }

  static Dll temp = null;
    public BrowserHistory(String homepage) {
        Dll head = new Dll(homepage);
        temp = head;
    }
    
    public void visit(String url) {
        Dll currNode = new Dll(url);
        temp.next = currNode;
        currNode.prev = temp;
        temp = temp.next;
    }
    
    public String back(int steps) {
        
        while(temp.prev!=null && steps!=0){
            temp = temp.prev;
            steps--;
        }

        return temp.data;
    }
    
    public String forward(int steps) {
        
        while(temp.next!=null && steps!=0){
            temp = temp.next;
            steps--;
        }

        return temp.data;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */